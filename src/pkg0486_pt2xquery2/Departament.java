/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg0486_pt2xquery2;

/**
 *
 * @author Yamila Cazalla Recio
 */
public class Departament {
    
    private String codi;
    private String nom;
    private String localitat;

    public Departament(String codi, String nom, String localitat) {
        this.codi = codi;
        this.nom = nom;
        this.localitat = localitat;
    }

    public String getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    public String getLocalitat() {
        return localitat;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLocalitat(String localitat) {
        this.localitat = localitat;
    }

    @Override
    public String toString() {
        return "Departament{" + "codi=" + codi + ", nom=" + nom + ", localitat=" + localitat + '}';
    }
    
}
