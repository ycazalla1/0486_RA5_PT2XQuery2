/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg0486_pt2xquery2;

import java.util.Scanner;
import javax.xml.xquery.*;

/**
 *
 * @author Yamila Cazalla Recio
 */
public class GestorBD {
    
    // Executa consultes de lectura
    public static void executeQuery(XQConnection conn, String query, String message) {
        try {
            XQExpression expr = conn.createExpression();
            XQResultSequence result = expr.executeQuery(query);
            System.out.println(message);
            while (result.next()) {
                System.out.println(result.getItemAsString(null));
            }
        } catch (XQException e) {
            System.err.println("Error executant la consulta: " + e.getMessage());
        }
    }
    
    // Executa ordres d'actualització
    public static void executeUpdate(XQConnection conn, String update, String message) {
        try {
            XQExpression expr = conn.createExpression();
            expr.executeCommand(update);
            System.out.println(message);
        } catch (XQException e) {
            e.printStackTrace();
            System.err.println("Error executant l'actualització: " + e.getMessage());
        }
    }
    
    public static void consultarDepartaments(XQConnection conn, String codi) {
        
        String query = (codi == null || codi.isEmpty())
            ? "for $d in doc('empresa/empresa.xml')//dept return $d"
            : "for $d in doc('empresa/empresa.xml')//dept[@codi='" + codi + "'] return $d";
        executeQuery(conn, query, "Resultat de departaments:");
        
    }
    
    public static void consultarEmpleats(XQConnection conn, String codi) {
        
        String query = (codi == null || codi.isEmpty())
            ? "for $e in doc('empresa/empresa.xml')//emp return $e"
            : "for $e in doc('empresa/empresa.xml')//emp[@codi='" + codi + "'] return $e";
        executeQuery(conn, query, "Resultat de empleats:");
        
    }
    
    public static void consultesCreuades(XQConnection conn, String codi) {
        
        String query = "let $d := doc('empresa/empresa.xml')//dept[@codi='" + codi + "']" +
            " let $e := doc('empresa/empresa.xml')//emp[@dept='" + codi + "'] " +
            "return <resultat>{ $d }<empleats>{ $e }</empleats></resultat>";
        executeQuery(conn, query, "Departament i empleats:");
        
    }
    
    public static void inserirDepartament(XQConnection conn, String codi,
                                            String nom, String localitat) {
        
        String update = 
            "update insert <dept codi='" + codi + "'>" +
            "<nom>" + nom + "</nom>" +
            "<localitat>" + localitat + "</localitat>" +
            "</dept> " +
            "into doc('empresa/empresa.xml')//departaments";
        executeUpdate(conn, update, "Departament inserit correctament.");
        
    }
    
    public static void inserirEmpleat(XQConnection conn, String codi,
                                        String dept, String cap, String cognom,
                                        String ofici, String dataAlta,
                                        double salari, double comissio) {
        
        StringBuilder emp = new StringBuilder();
        emp.append("<emp codi='").append(codi).append("' dept='").append(dept).append("'");
        if (cap != null && !cap.isEmpty()) {
            emp.append(" cap='").append(cap).append("'");
        }
        emp.append(">");
        emp.append("<cognom>").append(cognom).append("</cognom>");
        emp.append("<ofici>").append(ofici).append("</ofici>");
        emp.append("<dataAlta>").append(dataAlta).append("</dataAlta>");
        emp.append("<salari>").append(salari).append("</salari>");
        emp.append("<comissio>").append(comissio).append("</comissio>");
        emp.append("</emp>");

        String update = "update insert " + emp + " into doc('empresa/empresa.xml')//empleats";
        executeUpdate(conn, update, "Empleat inserit correctament.");
        
    }
    
    public static void actualitzarDepartament(XQConnection conn, String codi,
                                                String nouNom, String novaLoc) {
        
        String update1 = "update value doc('/db/empresa/empresa.xml')"
            + "//dept[@codi='" + codi + "']/nom with '" + nouNom + "'";

    String update2 = "update value doc('/db/empresa/empresa.xml')"
            + "//dept[@codi='" + codi + "']/localitat with '" + novaLoc + "'";

    executeUpdate(conn, update1, "Nom del departament actualitzat.");
    executeUpdate(conn, update2, "Localitat del departament actualitzada.");
        
    }
    
    public static void actualitzarEmpleat(XQConnection conn, String codi,
                                            String nouOfici, int nouSalari) {
            
        String update1 = "update replace value of node doc('empresa/empresa.xml')//emp[@codi='"
                + codi + "']/ofici with '" + nouOfici + "'";
        String update2 = "update replace value of node doc('empresa/empresa.xml')//emp[@codi='"
                + codi + "']/salari with '" + nouSalari + "'";
    
        executeUpdate(conn, update1, "Ofici de l'empleat actualitzat.");
        executeUpdate(conn, update2, "Salari de l'empleat actualitzat.");
                                            
    }
    
    public static void esborrarDepartament(XQConnection conn, String codi) {
        
        String update = "update delete doc('empresa/empresa.xml')//dept[@codi='" + codi + "']";
        executeUpdate(conn, update, "Departament esborrat.");
    
    }
    
    public static void esborrarEmpleat(XQConnection conn, String codi) {
        
        String update = "update delete doc('empresa/empresa.xml')//emp[@codi='" + codi + "']";
        executeUpdate(conn, update, "Empleat esborrat.");
        
    }
    
}
