package org.caredatedoc.caredate.jmjmdoc.jdbc.impl;

import org.caredatedoc.caredate.jmjmdoc.model.DatosMedPac;
import org.caredatedoc.caredate.jmjmdoc.model.Direccion;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DmedPacJdbcImplTest {

    @Test
    void getInstance() {
        assertNotNull(DmedPacJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        DmedPacJdbc dmedPacJdbc = DmedPacJdbcImpl.getInstance();
        List<DatosMedPac> list;
        list = dmedPacJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 0);
        list.stream().forEach(System.out::println);
    }

    @Test
    void save() {
        DmedPacJdbc dmedPacJdbc = DmedPacJdbcImpl.getInstance();
        DatosMedPac datosMedPac = new DatosMedPac();
        datosMedPac.setAlergias("grtg");
        datosMedPac.setMedicamentos("ferfv");
        datosMedPac.setCirugiasPre("verv");
        datosMedPac.setTipoSangre("cfrf");
        datosMedPac.setEnfCronicas("frfr");
        assertTrue(dmedPacJdbc.save(datosMedPac));
    }

    @Test
    void update() {
        DmedPacJdbc dmedPacJdbc = DmedPacJdbcImpl.getInstance();
        DatosMedPac datosMedPac = new DatosMedPac();
        datosMedPac.setAlergias("vhtjyumj");
        datosMedPac.setMedicamentos("vgtbth");
        datosMedPac.setCirugiasPre("bthnjy");
        datosMedPac.setTipoSangre("drfrt");
        datosMedPac.setEnfCronicas("drfe");
        datosMedPac.setId(1);
        assertTrue(dmedPacJdbc.update(datosMedPac));
    }

    @Test
    void delete() {
        DmedPacJdbc dmedPacJdbc = DmedPacJdbcImpl.getInstance();
        DatosMedPac datosMedPac = new DatosMedPac();
        datosMedPac.setAlergias("bhyjnut");
        datosMedPac.setId(1);
        assertTrue(dmedPacJdbc.delete(datosMedPac));
    }

    @Test
    void findById() {
        DmedPacJdbc dmedPacJdbc = DmedPacJdbcImpl.getInstance();
        DatosMedPac datosMedPac = dmedPacJdbc.findById(1);
        assertNotNull(datosMedPac);
        System.out.println( datosMedPac );

    }
}