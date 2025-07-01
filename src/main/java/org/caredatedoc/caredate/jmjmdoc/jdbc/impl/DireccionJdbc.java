package org.caredatedoc.caredate.jmjmdoc.jdbc.impl;

import org.caredatedoc.caredate.jmjmdoc.model.Direccion;

import java.util.List;

public interface DireccionJdbc {
    List<Direccion> findAll();
    boolean save (Direccion direccion);
    Direccion findById (Integer id);
}
