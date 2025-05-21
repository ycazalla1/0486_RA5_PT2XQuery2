/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg0486_pt2xquery2;

import javax.xml.xquery.*;

/**
 * Classe ConnectBD que gestiona la connexió a la base de dades
 *
 * @author Yamila Cazalla Recio
 */
public class ConnectBD {

    // Atributs
    private String server;
    private String port;
    private String user;
    private String password;
    private XQDataSource xqDataSource;

    /**
     * Constructor parametritzat per inicialitzar un objecte ConnectBD
     *
     * @param server Nom del servidor
     * @param port Port de connexió
     * @param user Nom d'usuari
     * @param password Contrasenya
     */
    public ConnectBD(String server, String port, String user, String password) {
        this.server = server;
        this.port = port;
        this.user = user;
        this.password = password;
        this.xqDataSource = new net.xqj.exist.ExistXQDataSource();
    }

    /**
     * Mètode que retorna el servidor
     *
     * @return Nom del servidor
     */
    public XQConnection toConnect() {
        try {
            // Configuració de la connexió
            xqDataSource.setProperty("serverName", server);
            xqDataSource.setProperty("port", port);
            xqDataSource.setProperty("user", user);
            xqDataSource.setProperty("password", password);
            // Creació de la connexió
            XQConnection conn = xqDataSource.getConnection();
            System.out.println("Connexió establerta correctament!");
            return conn;
        } catch (XQException e) {
            // Gestió d'errors
            System.err.println("Error en la connexió: " + e.getMessage());
            return null;
        }
    }
    
}
