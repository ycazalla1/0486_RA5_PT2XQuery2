/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg0486_pt2xquery2;

import java.util.Scanner;
import javax.xml.xquery.*;

/**
 *
 * @author Yamila Cazalla Recio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean fi = false;

        Connection connection = new Connection("localhost", "8080", "admin", "1234");
        XQConnection conn = connection.toConnect();
        if (conn != null) {
            while (!fi) {
                System.out.print("--- Empresa ---"
                        + "\n\t1. Consultar Departaments"
                        + "\n\t2. Consultar Empleats"
                        + "\n\t3. Consultar Departaments i Empleats"
                        + "\n\t4. Inserir Departaments"
                        + "\n\t5. Inserir Empleats"
                        + "\n\t6. Actualitzar Departaments"
                        + "\n\t7. Actualitzar Empleats"
                        + "\n\t8. Eliminar Departamens"
                        + "\n\t9. Eliminar Empleats"
                        + "\n\t10. Sortir"
                        + "\nResposta: ");
                int resposta = sc.nextInt();

                switch (resposta) {

                    case 1:
                        GestorBD.consultarDepartaments(conn, null);
                        break;
                    case 2:
                        GestorBD.consultarEmpleats(conn, null);
                        break;
                    case 3:
                        System.out.print("Introdueix el codi del departament"
                                + " per mostrar els seus empleats: ");
                        String codiD = codiDepartament();
                        GestorBD.consultesCreuades(conn, codiD);
                        break;
                    case 4:
                        dadesDepartaments(conn);
                        break;
                    case 5:
                        dadesEmpleats(conn);
                        break;
                    case 6:
                        GestorBD.actualitzarDepartament(conn, "d10", "Hola", "Santvi");
                        break;
                    case 7:
                        break;
                    case 8:
                        GestorBD.esborrarDepartament(conn, "d20");
                        break;
                    case 9:
                        break;
                    case 10:
                        fi = true;
                        break;
                    default:
                        break;

                }
            }
        }
    }
    
    public static String codiDepartament() {
        
        Scanner sc = new Scanner(System.in);
        
        String codi = sc.nextLine();
        
        return codi;
    }
    
    public static void dadesDepartaments(XQConnection conn) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introdueix el codi del departament: ");
        String codi = sc.nextLine();
        
        System.out.print("Introdueix el nom del departament: ");
        String nom = sc.nextLine();
        
        System.out.print("Introdueix la localitat de l'empresa: ");
        String localitat = sc.nextLine();
        
        GestorBD.inserirDepartament(conn, codi, nom, localitat);
    }
    
    public static void dadesEmpleats(XQConnection conn) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introducció de dades de l'empleat:"
                + "\nCodi: ");
        String codi = sc.nextLine();
        System.out.print("Departament: ");
        String dept = sc.nextLine();
        System.out.print("Cap: ");
        String cap = sc.nextLine();
        System.out.print("Cognom: ");
        String cognom = sc.nextLine();
        System.out.print("Ofici: ");
        String ofici = sc.nextLine();
        System.out.println("Data d'alta: ");
        String dataAlta = sc.nextLine();
        System.out.println("Salari: ");
        double salari = sc.nextDouble();
        System.out.println("Comissió: ");
        double comissio = sc.nextDouble();
        
        GestorBD.inserirEmpleat(conn, codi, dept, cap, cognom, ofici, dataAlta, salari,
                        comissio);
        
    }
    
}
