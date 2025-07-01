package org.caredatedoc.caredate.jmjmdoc.jdbc.impl;

import org.caredatedoc.caredate.jmjmdoc.model.Direccion;
import org.caredatedoc.caredate.jmjmdoc.model.Paciente;

import java.util.List;

public interface PacienteJdbc {
    List<Paciente> findAll();
    boolean save (Paciente paciente);
    Paciente findById (Integer id);
}
