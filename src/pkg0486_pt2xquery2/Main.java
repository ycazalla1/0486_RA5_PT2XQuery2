/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg0486_pt2xquery2;

import java.util.Scanner;
import javax.xml.xquery.*;

/**
 * Classe Main que conté el menú de l'aplicació
 *
 * @author Yamila Cazalla Recio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Declaració de l'escàner
        Scanner sc = new Scanner(System.in);

        // Declaració de la variable fi, que indica si l'usuari vol sortir del programa
        boolean fi = false;

        // Creació de la connexió a la base de dades
        ConnectBD connection = new ConnectBD("localhost", "8080", "admin", "1234");
        // Connexió a la base de dades
        XQConnection conn = connection.toConnect();

        // Comprovació de la connexió
        if (conn != null) {
            // Si la connexió és correcta, es mostra el menú
            while (!fi) {
                // Menú de l'aplicació
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
                int resposta = sc.nextInt(); // Llegim la resposta

                // Netegem el buffer
                sc.nextLine();

                // Comprovem la resposta
                switch (resposta) {
                    // Opció 1: Consultar Departaments
                    case 1:
                        // Preguntem si vol realitzar una consulta genèrica
                        System.out.print("\nVols realitzar una consulta genèrica (S/N): ");
                        String respostaCD = sc.nextLine();
                        // Si la resposta és S, es consulta tots els departaments
                        if (respostaCD.equalsIgnoreCase("S")) {
                            GestorBD.consultarDepartaments(conn, null);
                        // Si la resposta és N, es consulta un departament en concret
                        } else if (respostaCD.equalsIgnoreCase("N")) {
                            System.out.print("Quin departament vols consultar: ");
                            GestorBD.consultarDepartaments(conn, codiDepartament());
                        // Si la resposta no és S ni N, es mostra un missatge d'error
                        } else {
                            System.out.println("Resposta incorrecta.");
                        }
                        break;
                    // Opció 2: Consultar Empleats
                    case 2:
                        // Preguntem si vol realitzar una consulta genèrica
                        System.out.print("\nVols realitzar una consulta genèrica (S/N): ");
                        String respostaCE = sc.nextLine();
                        // Si la resposta és S, es consulta tots els empleats
                        if (respostaCE.equalsIgnoreCase("S")) {
                            GestorBD.consultarEmpleats(conn, null);
                        // Si la resposta és N, es consulta un empleat en concret
                        } else if (respostaCE.equalsIgnoreCase("N")) {
                            System.out.print("Quin empleat vols consultar: ");
                            GestorBD.consultarEmpleats(conn, codiEmpleat());
                        // Si la resposta no és S ni N, es mostra un missatge d'error
                        } else {
                            System.out.println("Resposta incorrecta.");
                        }
                        break;
                    // Opció 3: Consultar Departaments i Empleats
                    case 3:
                        System.out.println("");
                        // Preguntem si vol realitzar una consulta genèrica
                        System.out.print("Introdueix el codi del departament"
                                + " per mostrar els seus empleats: ");
                        String codiD = codiDepartament();
                        GestorBD.consultesCreuades(conn, codiD);
                        break;
                    // Opció 4: Inserir Departaments
                    case 4:
                        System.out.println("");
                        dadesDepartaments(conn);
                        break;
                    // Opció 5: Inserir Empleats
                    case 5:
                        System.out.println("");
                        dadesEmpleats(conn);
                        break;
                    // Opció 6: Actualitzar Departaments
                    case 6:
                        System.out.println("");
                        actDept(conn);
                        break;
                    // Opció 7: Actualitzar Empleats
                    case 7:
                        System.out.println("");
                        actEmp(conn);
                        break;
                    // Opció 8: Eliminar Departaments
                    case 8:
                        System.out.println("");
                        System.out.print("\nQuin departament vols eliminar: ");
                        GestorBD.esborrarDepartament(conn, codiDepartament());
                        break;
                    // Opció 9: Eliminar
                    case 9:
                        System.out.println("");
                        System.out.print("\nQuin empleat vols eliminar: ");
                        GestorBD.esborrarEmpleat(conn, codiEmpleat());
                        break;
                    // Opció 10: Sortir
                    case 10:
                        System.out.println("");
                        System.out.println("\nHas sortit de la base de dades.");
                        fi = true;
                        break;
                    // Opció incorrecta
                    default:
                        System.out.println("");
                        System.out.println("\nResposta incorrecte. Torna a "
                                + "intentar-ho.");
                        break;

                }
            }
        }
    }

    /**
     * Mètode que demana el codi d'un departament
     *
     * @return Retorna el codi del departament
     */
    public static String codiDepartament() {
        
        Scanner sc = new Scanner(System.in);
        
        String codi = sc.nextLine();
        
        return codi;
    }

    /**
     * Mètode que demana el codi d'un empleat
     *
     * @return Retorna el codi de l'empleat
     */
    public static String codiEmpleat() {
        Scanner sc = new Scanner(System.in);
        
        String codi = sc.nextLine();
        
        return codi;
    }

    /**
     * Mètode que demana les dades d'un departament
     *
     * @param conn Connexió a la base de dades
     */
    public static void dadesDepartaments(XQConnection conn) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Introdueix el codi del departament: ");
        String codi = sc.nextLine();
        
        System.out.print("Introdueix el nom del departament: ");
        String nom = sc.nextLine();
        
        System.out.print("Introdueix la localitat de l'empresa: ");
        String localitat = sc.nextLine();

        // Inserim el departament a la base de dades
        GestorBD.inserirDepartament(conn, codi, nom, localitat);
    }

    /**
     * Mètode que demana les dades d'un empleat
     *
     * @param conn Connexió a la base de dades
     */
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
        System.out.print("Data d'alta: ");
        String dataAlta = sc.nextLine();
        System.out.print("Salari: ");
        double salari = sc.nextDouble();
        System.out.print("Comissió: ");
        double comissio = sc.nextDouble();

        // Inserim l'empleat a la base de dades
        GestorBD.inserirEmpleat(conn, codi, dept, cap, cognom, ofici, dataAlta, salari,
                        comissio);
        
    }

    /**
     * Mètode que demana les dades d'un departament
     *
     * @param conn Connexió a la base de dades
     */
    public static void actDept(XQConnection conn){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Quin departament vols actualitzar? ");
        String codi = sc.nextLine();
        
        System.out.print("-- Dades a actualitzar --"
                + "\nNom: ");
        String nom = sc.nextLine();
        System.out.print("Localitat: ");
        String localitat = sc.nextLine();

        // Actualitzem el departament a la base de dades
        GestorBD.actualitzarDepartament(conn, codi, nom, localitat);
        
    }

    /**
     * Mètode que demana les dades d'un empleat
     *
     * @param conn Connexió a la base de dades
     */
    public static void actEmp(XQConnection conn) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Quin empleat vols actualitzar: ");
        String codi = sc.nextLine();
        
        System.out.print("-- Dades a actualiztar --"
                + "\nOfici: ");
        String ofici = sc.nextLine();
        System.out.print("Salari: ");
        double salari = sc.nextDouble();
        System.out.print("Comissio: ");
        double comissio = sc.nextDouble();

        // Actualitzem l'empleat a la base de dades
        GestorBD.actualitzarEmpleat(conn, codi, ofici, salari, comissio);
        
    }
    
}
