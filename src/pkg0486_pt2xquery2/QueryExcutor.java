/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg0486_pt2xquery2;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;

/**
 *
 * @author Yamila Cazalla Recio
 */

class QueryExecutor {

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
}
