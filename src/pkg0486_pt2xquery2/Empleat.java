/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg0486_pt2xquery2;

/**
 *
 * @author Yamila Cazalla Recio
 */
public class Empleat {
    private String codi;
    private String dept;
    private String cap;
    private String cognom;
    private String ofici;
    private String dataAlta;
    private double salari;
    private double comissio;

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

    // Getters i setters
    public String getCodi() {
        return codi;
    }

    public String getDept() {
        return dept;
    }

    public String getCap() {
        return cap;
    }

    public String getCognom() {
        return cognom;
    }

    public String getOfici() {
        return ofici;
    }

    public String getDataAlta() {
        return dataAlta;
    }

    public double getSalari() {
        return salari;
    }

    public double getComissio() {
        return comissio;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public void setOfici(String ofici) {
        this.ofici = ofici;
    }

    public void setDataAlta(String dataAlta) {
        this.dataAlta = dataAlta;
    }

    public void setSalari(double salari) {
        this.salari = salari;
    }

    public void setComissio(double comissio) {
        this.comissio = comissio;
    }

    @Override
    public String toString() {
        return "Empleat{" + "codi=" + codi + ", dept=" + dept + ", cap=" + cap +
                ", cognom=" + cognom + ", ofici=" + ofici + ", dataAlta=" +
                dataAlta + ", salari=" + salari + ", comissio=" + comissio + '}';
    }
    
}

