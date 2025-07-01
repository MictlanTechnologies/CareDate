package org.caredatedoc.caredate.jmjmdoc.jdbc.impl;

import org.caredatedoc.caredate.jmjmdoc.model.DatosMedPac;

import java.util.List;

public interface DmedPacJdbc {
    List<DatosMedPac> findAll();
    boolean save (DatosMedPac datosMedPac);
    boolean update (DatosMedPac datosMedPac);
    boolean delete (DatosMedPac datosMedPac);
    DatosMedPac findById (Integer id);
}
