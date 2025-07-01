package org.caredatedoc.caredate.jmjmdoc.model;

/**
 * Modelo para representar la dirección de un paciente.
 */
public class Direccion {

    private int id;
    private String alcaldiaP;
    private String coloniaP;
    private String calleP;
    private int numeroP;
    private int cpP;

    public Direccion() {
    }

    public Direccion(String alcaldiaP, String coloniaP, String calleP, int numeroP, int cpP) {
        this.alcaldiaP = alcaldiaP;
        this.coloniaP = coloniaP;
        this.calleP = calleP;
        this.numeroP = numeroP;
        this.cpP = cpP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlcaldiaP() {
        return alcaldiaP;
    }

    public void setAlcaldiaP(String alcaldiaP) {
        this.alcaldiaP = alcaldiaP;
    }

    public String getColoniaP() {
        return coloniaP;
    }

    public void setColoniaP(String coloniaP) {
        this.coloniaP = coloniaP;
    }

    public String getCalleP() {
        return calleP;
    }

    public void setCalleP(String calleP) {
        this.calleP = calleP;
    }

    public int getNumeroP() {
        return numeroP;
    }

    public void setNumeroP(int numeroP) {
        this.numeroP = numeroP;
    }

    public int getCpP() {
        return cpP;
    }

    public void setCpP(int cpP) {
        this.cpP = cpP;
    }
}