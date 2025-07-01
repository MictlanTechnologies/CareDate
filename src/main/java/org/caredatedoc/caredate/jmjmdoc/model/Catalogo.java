package org.caredatedoc.caredate.jmjmdoc.model;

public class Catalogo {

    protected Integer id;

    public Catalogo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Catálogo{" +
                "id = " + id +
                '}';
    }
}