package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.negocio.Ejecutable;

public class    ListaCatalogos extends LecturaAccion {

    public static ListaCatalogos listaCatalogos;

    private ListaCatalogos() {
    }

    public static ListaCatalogos getInstance() {
        if (listaCatalogos == null) {
            listaCatalogos = new ListaCatalogos();
        }
        return listaCatalogos;
    }

    @Override
    public void despliegaMenu() {
        System.out.println("Seleccione una opción");
        System.out.println("1.-Direccón Paciente");
        System.out.println("2.-Dirección Clinica");
        System.out.println("2.-Salir");

    }

    @Override
    public int valorMinMenu() {
        return 1;
    }

    @Override
    public int valorMaxMenu() {
        return 3;
    }

    @Override
    public void procesaOpcion() {
        Ejecutable ejecutable = null;

        switch (opcion) {
            case 1:
                System.out.println("no impl");
                break;
            case 2:
                System.out.println("por impl");
                break;
        }
        ejecutable.setFlag(true);
        ejecutable.run();
    }

}
