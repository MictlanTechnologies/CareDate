package org.caredatedoc.caredate.jmjmdoc.model;

import java.sql.Date;
import java.sql.Time;

public class Cita {

    private int idGestionCitas;
    private Date diaCita;
    private Time horarioCita;
    private String motivoGeneral;
    private String notasMed;
    private int idPaciente;
    private int idClinica;

    public Cita() {}

    public Cita(Date diaCita, Time horarioCita, String motivoGeneral, String notasMed, int idPaciente, int idClinica) {
        this.diaCita = diaCita;
        this.horarioCita = horarioCita;
        this.motivoGeneral = motivoGeneral;
        this.notasMed = notasMed;
        this.idPaciente = idPaciente;
        this.idClinica = idClinica;
    }

    public int getIdGestionCitas() {
        return idGestionCitas;
    }

    public void setIdGestionCitas(int idGestionCitas) {
        this.idGestionCitas = idGestionCitas;
    }

    public Date getDiaCita() {
        return diaCita;
    }

    public void setDiaCita(Date diaCita) {
        this.diaCita = diaCita;
    }

    public Time getHorarioCita() {
        return horarioCita;
    }

    public void setHorarioCita(Time horarioCita) {
        this.horarioCita = horarioCita;
    }

    public String getMotivoGeneral() {
        return motivoGeneral;
    }

    public void setMotivoGeneral(String motivoGeneral) {
        this.motivoGeneral = motivoGeneral;
    }

    public String getNotasMed() {
        return notasMed;
    }

    public void setNotasMed(String notasMed) {
        this.notasMed = notasMed;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(int idClinica) {
        this.idClinica = idClinica;
    }
}