package org.caredatedoc.caredate.jmjmdoc.inicio;

import org.caredatedoc.caredate.jmjmdoc.gui.ConsolaVentana;

public class Inicio {

    public static void main(String[] args) {
        System.out.println("INICIO CAREDATE");
        ConsolaVentana.getInstance().run();
        System.out.println("FINALIZANDO CAREDATE");
    }
}
