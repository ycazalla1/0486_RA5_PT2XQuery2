/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg0486_pt2xquery2;

/**
 * Classe que representa un empleat
 *
 * @author Yamila Cazalla Recio
 */
public class Empleat {

    // Atributs
    private String codi;
    private String dept;
    private String cap;
    private String cognom;
    private String ofici;
    private String dataAlta;
    private double salari;
    private double comissio;

    /*
     * Constructor parametritzat per inicialitzar un objecte Empleat
     *
     * @param codi Codi de l'empleat
     * @param dept Departament de l'empleat
     * @param cap Cap de l'empleat
     * @param cognom Cognom de l'empleat
     * @param ofici Ofici de l'empleat
     * @param dataAlta Data d'alta de l'empleat
     * @param salari Salari de l'empleat
     * @param comissio Comissió de l'empleat
     */
    public Empleat(String codi, String dept, String cap, String cognom,
            String ofici, String dataAlta, double salari, double comissio) {
        this.codi = codi;
        this.dept = dept;
        this.cap = cap;
        this.cognom = cognom;
        this.ofici = ofici;
        this.dataAlta = dataAlta;
        this.salari = salari;
        this.comissio = comissio;
    }

    /**
     * Mètode que retorna el codi de l'empleat
     *
     * @return Codi de l'empleat
     */
    public String getCodi() {
        return codi;
    }

    /**
     * Mètode que retorna el departament de l'empleat
     *
     * @return Departament de l'empleat
     */
    public String getDept() {
        return dept;
    }

    /**
     * Mètode que retorna el cap de l'empleat
     *
     * @return Cap de l'empleat
     */
    public String getCap() {
        return cap;
    }

    /**
     * Mètode que retorna el cognom de l'empleat
     *
     * @return Cognom de l'empleat
     */
    public String getCognom() {
        return cognom;
    }

    /**
     * Mètode que retorna l'ofici de l'empleat
     *
     * @return Ofici de l'empleat
     */
    public String getOfici() {
        return ofici;
    }

    /**
     * Mètode que retorna la data d'alta de l'empleat
     *
     * @return Data d'alta de l'empleat
     */
    public String getDataAlta() {
        return dataAlta;
    }

    /**
     * Mètode que retorna el salari de l'empleat
     *
     * @return Salari de l'empleat
     */
    public double getSalari() {
        return salari;
    }

    /**
     * Mètode que retorna la comissió de l'empleat
     *
     * @return Comissió de l'empleat
     */
    public double getComissio() {
        return comissio;
    }

    /**
     * Mètodes setters per modificar els atributs de l'empleat
     *
     * @param codi Codi de l'empleat
     */
    public void setCodi(String codi) {
        this.codi = codi;
    }

    /**
     * Mètodes setters per modificar els atributs de l'empleat
     *
     * @param dept Departament de l'empleat
     */
    public void setDept(String dept) {
        this.dept = dept;
    }

    /**
     * Mètodes setters per modificar els atributs de l'empleat
     *
     * @param cap Cap de l'empleat
     */
    public void setCap(String cap) {
        this.cap = cap;
    }

    /**
     * Mètodes setters per modificar els atributs de l'empleat
     *
     * @param cognom Cognom de l'empleat
     */
    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    /**
     * Mètodes setters per modificar els atributs de l'empleat
     *
     * @param ofici Ofici de l'empleat
     */
    public void setOfici(String ofici) {
        this.ofici = ofici;
    }

    /**
     * Mètodes setters per modificar els atributs de l'empleat
     *
     * @param dataAlta Data d'alta de l'empleat
     */
    public void setDataAlta(String dataAlta) {
        this.dataAlta = dataAlta;
    }

    /**
     * Mètodes setters per modificar els atributs de l'empleat
     *
     * @param salari Salari de l'empleat
     */
    public void setSalari(double salari) {
        this.salari = salari;
    }

    /**
     * Mètodes setters per modificar els atributs de l'empleat
     *
     * @param comissio Comissió de l'empleat
     */
    public void setComissio(double comissio) {
        this.comissio = comissio;
    }

    /**
     * Mètode toString per mostrar la informació de l'empleat
     *
     * @return String amb la informació de l'empleat
     */
    @Override
    public String toString() {
        return "Empleat{" + "codi=" + codi + ", dept=" + dept + ", cap=" + cap +
                ", cognom=" + cognom + ", ofici=" + ofici + ", dataAlta=" +
                dataAlta + ", salari=" + salari + ", comissio=" + comissio + '}';
    }
    
}

