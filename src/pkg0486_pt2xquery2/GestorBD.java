/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg0486_pt2xquery2;

import java.util.Scanner;
import javax.xml.xquery.*;

/**
 * Classe GestorBD que conté mètodes per gestionar la base de dades
 *
 * @author Yamila Cazalla Recio
 */
public class GestorBD {
    
    /*
     * Mètode principal que s'encarrega de gestionar la connexió a la base de dades
     * i d'executar les consultes i actualitzacions.
     *
     * @param args Arguments de la línia de comandes (no s'utilitzen).
     */
    public static void executeQuery(XQConnection conn, String query, String message) {
        try {
            // Executa la consulta i obté el resultat
            XQExpression expr = conn.createExpression();
            XQResultSequence result = expr.executeQuery(query);
            System.out.println(message);
            // Itera sobre els resultats i imprimeix cada element
            while (result.next()) {
                System.out.println(result.getItemAsString(null));
            }
        } catch (XQException e) {
            // Maneja les excepcions i imprimeix l'error
            System.err.println("Error executant la consulta: " + e.getMessage());
        }
    }

    /*
     * Mètode per executar una actualització a la base de dades.
     *
     * @param conn Connexió a la base de dades.
     * @param update Consulta d'actualització a executar.
     * @param message Missatge a imprimir després de l'actualització.
     */
    public static void executeUpdate(XQConnection conn, String update, String message) {
        try {
            // Executa l'actualització i imprimeix el missatge
            XQExpression expr = conn.createExpression();
            expr.executeCommand(update);
            System.out.println(message);
        } catch (XQException e) {
            // Maneja les excepcions i imprimeix l'error
            System.err.println("Error executant l'actualització: " + e.getMessage());
        }
    }

    /*
     * Mètode per consultar els departaments de la base de dades.
     *
     * @param conn Connexió a la base de dades.
     * @param codi Codi del departament a consultar (null o buit per a tots els departaments).
     */
    public static void consultarDepartaments(XQConnection conn, String codi) {
        
        System.out.println("");
        // Consulta per obtenir els departaments
        String query = (codi == null || codi.isEmpty())
        ? "for $d in doc('empresa/empresa.xml')//dept "
        + "return concat('Departament: ', data($d/@codi), ' | Nom: ', "
        + "data($d/nom), ' | Localitat: ', data($d/localitat))"
        : "for $d in doc('empresa/empresa.xml')//dept[@codi='" + codi + "'] "
        + "return concat('Departament: ', data($d/@codi), ' | Nom: ', "
        + "data($d/nom), ' | Localitat: ', data($d/localitat))";
        // Executa la consulta i imprimeix els resultats
        executeQuery(conn, query, "-- Departaments --");
        System.out.println("");
        
    }

    /*
     * Mètode per consultar els empleats de la base de dades.
     *
     * @param conn Connexió a la base de dades.
     * @param codi Codi de l'empleat a consultar (null o buit per a tots els empleats).
     */
    public static void consultarEmpleats(XQConnection conn, String codi) {
        
        System.out.println("");
        // Consulta per obtenir els empleats
        String query = (codi == null || codi.isEmpty())
        ? "for $e in doc('empresa/empresa.xml')//emp "
        + "return concat('Empleat: ', data($e/@codi), "
        + "' | Dept: ', data($e/@dept), "
        + "' | Cap: ', data($e/@cap), "
        + "' | Cognom: ', data($e/cognom), "
        + "' | Ofici: ', data($e/ofici), "
        + "' | Data Alta: ', data($e/dataAlta), "
        + "' | Salari: ', data($e/salari), "
        + "' | Comissió: ', data($e/comissio))"
        : "for $e in doc('empresa/empresa.xml')//emp[@codi='" + codi + "'] "
        + "return concat('Empleat: ', data($e/@codi), "
        + "' | Dept: ', data($e/@dept), "
        + "' | Cap: ', data($e/@cap), "
        + "' | Cognom: ', data($e/cognom), "
        + "' | Ofici: ', data($e/ofici), "
        + "' | Data Alta: ', data($e/dataAlta), "
        + "' | Salari: ', data($e/salari), "
        + "' | Comissió: ', data($e/comissio))";
        // Executa la consulta i imprimeix els resultats
        executeQuery(conn, query, "-- Empleats --");
        System.out.println("");
        
    }

    /*
     * Mètode per consultar els departaments i empleats associats a un departament.
     *
     * @param conn Connexió a la base de dades.
     * @param codi Codi del departament a consultar.
     */
    public static void consultesCreuades(XQConnection conn, String codi) {
        
        System.out.println("");
        // Consulta per obtenir els departaments i empleats associats
        String query =
        "let $d := doc('empresa/empresa.xml')//dept[@codi='" + codi + "'] " +
        "let $emps := doc('empresa/empresa.xml')//emp[@dept='" + codi + "'] " +
        "return concat(" +
        "  'Departament: ', data($d/@codi), ' | Nom: ', data($d/nom), " +
        "' | Localitat: ', data($d/localitat), '&#10;', " +
        "  string-join( " +
        "    for $e in $emps " +
        "    return concat('     Empleat: ', data($e/@codi)," +
        "    ' | Dept: ', data($e/@dept), ' | Cap: ', data($e/@cap), " +
        "    ' | Cognom: ', data($e/cognom), ' | Ofici: ', data($e/ofici), " +
        "    ' | Data Alta: ', data($e/dataAlta), ' | Salari: ', data($e/salari), " +
        "    ' | Comissió: ', data($e/comissio))" +
        "  , '&#10;')" +
        ")";
        // Executa la consulta i imprimeix els resultats
        executeQuery(conn, query, "-- Departamens i empleats --");
        System.out.println("");
        
    }

    /*
     * Mètode per inserir un nou departament a la base de dades.
     *
     * @param conn Connexió a la base de dades.
     * @param codi Codi del nou departament.
     * @param nom Nom del nou departament.
     * @param localitat Localitat del nou departament.
     */
    public static void inserirDepartament(XQConnection conn, String codi,
                                            String nom, String localitat) {
        // Inserir un nou departament a la base de dades
        String update = 
            "update insert <dept codi='" + codi + "'>" +
            "<nom>" + nom + "</nom>" +
            "<localitat>" + localitat + "</localitat>" +
            "</dept> " +
            "into doc('empresa/empresa.xml')//departaments";
        // Executar l'actualització i imprimir el missatge
        executeUpdate(conn, update, "Departament inserit correctament.");
        System.out.println("");
        
    }

    /*
     * Mètode per inserir un nou empleat a la base de dades.
     *
     * @param conn Connexió a la base de dades.
     * @param codi Codi de l'empleat.
     * @param dept Departament de l'empleat.
     * @param cap Cap de l'empleat (opcional).
     * @param cognom Cognom de l'empleat.
     * @param ofici Ofici de l'empleat.
     * @param dataAlta Data d'alta de l'empleat.
     * @param salari Salari de l'empleat.
     * @param comissio Comissió de l'empleat.
     */
    public static void inserirEmpleat(XQConnection conn, String codi,
                                        String dept, String cap, String cognom,
                                        String ofici, String dataAlta,
                                        double salari, double comissio) {

        // Inserir un nou empleat a la base de dades
        String update = 
        "update insert <emp codi='" + codi + "' dept='" + dept + "' cap='" + cap + "'>" +
        "<cognom>" + cognom + "</cognom>" +
        "<ofici>" + ofici + "</ofici>" +
        "<dataAlta>" + dataAlta + "</dataAlta>" +
        "<salari>" + salari + "</salari>" +
        "<comissio>" + comissio + "</comissio>" +
        "</emp> into doc('empresa/empresa.xml')//empleats";
        // Executar l'actualització i imprimir el missatge
        executeUpdate(conn, update, "Empleat inserit correctament.");
        System.out.println("");
        
    }

    /**
     * Mètode per actualitzar un departament a la base de dades.
     *
     * @param conn Connexió a la base de dades.
     * @param codi Codi del departament a actualitzar.
     * @param nouNom Nou nom del departament.
     * @param novaLoc Nova localitat del departament.
     */
    public static void actualitzarDepartament(XQConnection conn, String codi,
                                                String nouNom, String novaLoc) {

        // Actualitzar el nom i la localitat d'un departament a la base de dades
        String update1 = "update value doc('/db/empresa/empresa.xml')"
            + "//dept[@codi='" + codi + "']/nom with '" + nouNom + "'";

        String update2 = "update value doc('/db/empresa/empresa.xml')"
            + "//dept[@codi='" + codi + "']/localitat with '" + novaLoc + "'";

        // Executar les actualitzacions i imprimir els missatges
        executeUpdate(conn, update1, "Nom del departament actualitzat.");
        executeUpdate(conn, update2, "Localitat del departament actualitzada.");
        System.out.println("");
        
    }

    /**
     * Mètode per actualitzar un empleat a la base de dades.
     *
     * @param conn Connexió a la base de dades.
     * @param codi Codi de l'empleat a actualitzar.
     * @param nouOfici Nou ofici de l'empleat.
     * @param nouSalari Nou salari de l'empleat.
     * @param novaComissio Nova comissió de l'empleat.
     */
    public static void actualitzarEmpleat(XQConnection conn, String codi,
                                            String nouOfici, double nouSalari,
                                            double novaComissio) {

        // Actualitzar l'ofici, salari i comissió d'un empleat a la base de dades
        String update1 = "update value doc('empresa/empresa.xml')//emp[@codi='"
                + codi + "']/ofici with '" + nouOfici + "'";
        String update2 = "update value doc('empresa/empresa.xml')//emp[@codi='"
                + codi + "']/salari with '" + nouSalari + "'";
        String update3 = "update value doc('empresa/empresa.xml')//emp[@codi='"
                + codi + "']/comissio with '" + novaComissio + "'";

        // Executar les actualitzacions i imprimir els missatges
        executeUpdate(conn, update1, "Ofici de l'empleat actualitzat.");
        executeUpdate(conn, update2, "Salari de l'empleat actualitzat.");
        executeUpdate(conn, update3, "Comissio de l'empleat actualitzada.");
        System.out.println("");
        
    }

    /**
     * Mètode per esborrar un departament i els seus empleats associats a la base de dades.
     *
     * @param conn Connexió a la base de dades.
     * @param codi Codi del departament a esborrar.
     */
    public static void esborrarDepartament(XQConnection conn, String codi) {

        // Esborrar un departament i els seus empleats associats a la base de dades
        String update1 = "update delete doc('empresa/empresa.xml')//dept[@codi='" + codi + "']";
        String update2 = "update delete doc('empresa/empresa.xml')//emp[@dept='" + codi + "']";
        // Executar les actualitzacions i imprimir els missatges
        executeUpdate(conn, update1, "Departament esborrat.");
        executeUpdate(conn, update2, "Departament esborrat.");
        
    
    }

    /**
     * Mètode per esborrar un empleat de la base de dades.
     *
     * @param conn Connexió a la base de dades.
     * @param codi Codi de l'empleat a esborrar.
     */
    public static void esborrarEmpleat(XQConnection conn, String codi) {

        // Esborrar un empleat de la base de dades
        String update = "update delete doc('empresa/empresa.xml')//emp[@codi='" + codi + "']";
        // Executar l'actualització i imprimir el missatge
        executeUpdate(conn, update, "Empleat esborrat.");
        System.out.println("");
        
    }
    
}
