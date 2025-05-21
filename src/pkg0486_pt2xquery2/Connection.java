package pkg0486_pt2xquery2;


import javax.xml.xquery.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Yamila Cazalla Recio
 */
public class Connection {

    private String server;
    private String port;
    private String user;
    private String password;
    private XQDataSource xqDataSource;

    public Connection(String server, String port, String user, String password) {
        this.server = server;
        this.port = port;
        this.user = user;
        this.password = password;
        this.xqDataSource = new net.xqj.exist.ExistXQDataSource();
    }

    public XQConnection toConnect() {
        try {
            xqDataSource.setProperty("serverName", server);
            xqDataSource.setProperty("port", port);
            xqDataSource.setProperty("user", user);
            xqDataSource.setProperty("password", password);
            XQConnection conn = xqDataSource.getConnection();
            System.out.println("Connexió establerta correctament!");
            return conn;
        } catch (XQException e) {
            System.err.println("Error en la connexió: " + e.getMessage());
            return null;
        }
    }
}
