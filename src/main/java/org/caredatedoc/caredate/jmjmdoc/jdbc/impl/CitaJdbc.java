package org.caredatedoc.caredate.jmjmdoc.jdbc.impl;

import org.caredatedoc.caredate.jmjmdoc.model.Cita;

import java.util.List;

public interface CitaJdbc {
    boolean agendarCita(Cita cita);
    boolean eliminarCita(int idCita);
    List<Cita> obtenerCitasPorPaciente(int idPacMed);
}
