package org.caredatedoc.caredate.jmjmdoc.model;

public class DatosMedPac extends Catalogo {
    private String tipoSangre = "";
    private String medicamentos = "";
    private String enfCronicas = "";
    private String alergias = "";
    private String cirugiasPre = "";

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getEnfCronicas() {
        return enfCronicas;
    }

    public void setEnfCronicas(String enfCronicas) {
        this.enfCronicas = enfCronicas;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getCirugiasPre() {
        return cirugiasPre;
    }

    public void setCirugiasPre(String cirugiasPre) {
        this.cirugiasPre = cirugiasPre;
    }

    @Override
    public String toString() {
        return "DatosMedPac{" +
                "tipoSangre='" + tipoSangre + '\'' +
                ", medicamentos='" + medicamentos + '\'' +
                ", enfCronicas='" + enfCronicas + '\'' +
                ", alergias='" + alergias + '\'' +
                ", cirugiasPre='" + cirugiasPre + '\'' +
                ", id=" + id +
                '}';
    }
}
