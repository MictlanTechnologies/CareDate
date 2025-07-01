package org.caredatedoc.caredate.jmjmdoc.jdbc.impl;

import org.caredatedoc.caredate.jmjmdoc.model.Direccion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DireccionJdbcImplTest {

    @Test
    void getInstance() {
        assertNotNull(DireccionJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        DireccionJdbc direccionJdbc = DireccionJdbcImpl.getInstance();
        List<Direccion> list;
        list = direccionJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 0);
        list.stream().forEach(System.out::println);
    }

    @Test
    void save() {
        DireccionJdbc direccionJdbc = DireccionJdbcImpl.getInstance();
        Direccion direccion = new Direccion();
        direccion.setAlcaldiaP("frgr");
        direccion.setColoniaP("ferfv");
        direccion.setCalleP("verv");
        direccion.setNumeroP(Integer.valueOf("90"));
        direccion.setCpP(Integer.valueOf("34"));
        direccion.setId(1);
        assertTrue(direccionJdbc.save(direccion));
    }

    @Test
    void findById() {
        /*DireccionJdbc direccionJdbc = DireccionJdbcImpl.getInstance();
        Direccion direccion = direccionJdbc.findById( 1 );
        assertNotNull(direccion);
        System.out.println( direccion );*/

        /*DireccionJdbc direccionJdbc = DireccionJdbcImpl.getInstance();
        Direccion direccion1 = new Direccion("frgr", "ferfv", "verv", 123, 8989);
        boolean dir = direccionJdbc.save(direccion1);
        Direccion direccion = direccionJdbc.findById(1);
        assertNotNull(direccion);
        System.out.println( direccion );*/

    }
}