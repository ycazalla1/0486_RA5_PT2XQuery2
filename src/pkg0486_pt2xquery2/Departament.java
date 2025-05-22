/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg0486_pt2xquery2;

/**
 * Classe que representa un departament
 * 
 * @author Yamila Cazalla Recio
 */
public class Departament {

    // Atributs
    private String codi;
    private String nom;
    private String localitat;

    /*
     * Constructor parametritzat per inicialitzar un objecte Departament
     *
     * @param codi Codi del departament
     * @param nom Nom del departament
     * @param localitat Localitat del departament
     */
    public Departament(String codi, String nom, String localitat) {
        this.codi = codi;
        this.nom = nom;
        this.localitat = localitat;
    }

    /**
     * Mètode que retorna el codi del departament
     *
     * @return Codi del departament
     */
    public String getCodi() {
        return codi;
    }

    /**
     * Mètode que retorna el nom del departament
     *
     * @return Nom del departament
     */
    public String getNom() {
        return nom;
    }

    /**
     * Mètode que retorna la localitat del departament
     *
     * @return Localitat del departament
     */
    public String getLocalitat() {
        return localitat;
    }

    /**
     * Mètode que modifica el codi del departament
     *
     * @param codi Codi del departament
     */
    public void setCodi(String codi) {
        this.codi = codi;
    }

    /**
     * Mètode que modifica el nom del departament
     *
     * @param nom Nom del departament
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Mètode que modifica la localitat del departament
     *
     * @param localitat Localitat del departament
     */
    public void setLocalitat(String localitat) {
        this.localitat = localitat;
    }

    /**
     * Mètode que retorna una cadena de text amb la informació del departament
     *
     * @return Cadena de text amb la informació del departament
     */
    @Override
    public String toString() {
        return "Departament{" + "codi=" + codi + ", nom=" + nom + ", localitat=" + localitat + '}';
    }
    
}
