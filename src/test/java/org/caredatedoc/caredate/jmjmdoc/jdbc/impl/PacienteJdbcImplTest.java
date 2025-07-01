package org.caredatedoc.caredate.jmjmdoc.jdbc.impl;

import org.caredatedoc.caredate.jmjmdoc.model.Direccion;
import org.caredatedoc.caredate.jmjmdoc.model.Paciente;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PacienteJdbcImplTest {

    @Test
    void getInstance() {
        assertNotNull(PacienteJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        PacienteJdbc pacienteJdbc = PacienteJdbcImpl.getInstance();
        List<Paciente> list = pacienteJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 0);
        list.stream().forEach(System.out::println);
    }

    @Test
    void save() {
        PacienteJdbc pacienteJdbc = PacienteJdbcImpl.getInstance();
        Paciente paciente = new Paciente();
        paciente.setNombre("vbgtbtg");
        paciente.setaPaterno("ferfv");
        paciente.setaMaterno("verv");
        paciente.setCurp("7U87U87U87U87U87U8");
        paciente.setFechaNac("2007-09-09");
        paciente.setSexo('M');
        paciente.setEmail("vfvf@gmail.com");

        assertTrue(pacienteJdbc.save(paciente));
    }

    @Test
    void findById() {
        PacienteJdbc pacienteJdbc = PacienteJdbcImpl.getInstance();
        Paciente paciente = pacienteJdbc.findById( 1 );
        assertNotNull(paciente);
        System.out.println( paciente );
    }
}