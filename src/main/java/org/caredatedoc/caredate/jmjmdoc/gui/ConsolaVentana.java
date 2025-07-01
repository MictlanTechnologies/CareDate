package org.caredatedoc.caredate.jmjmdoc.gui;

import org.caredatedoc.caredate.jmjmdoc.gui.PacienteGui.MenuPrincipalGui;
import org.caredatedoc.caredate.jmjmdoc.gui.consola.Consola;
import org.caredatedoc.caredate.jmjmdoc.gui.consola.LecturaAccion;
import org.caredatedoc.caredate.jmjmdoc.gui.consola.ventana.Ventana;
import org.caredatedoc.caredate.jmjmdoc.negocio.Ejecutable;

import javax.swing.*;

public class ConsolaVentana extends LecturaAccion {

    public static ConsolaVentana consolaVentana;

    private ConsolaVentana() {
    }

    public static ConsolaVentana getInstance() {
        if (consolaVentana == null) {
            consolaVentana = new ConsolaVentana();
        }
        return consolaVentana;
    }

    @Override
    public void despliegaMenu() {
        System.out.println("Seleccione la opción");
        System.out.println("1.- Consola");
        System.out.println("2.- Ventana");
        System.out.println("3.- Salir");
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
        if (opcion == 1) {
            ejecutable = Consola.getInstance();
            if (ejecutable != null) {
                ejecutable.setFlag(true);
                ejecutable.run();
            }
            System.exit(0);
        } else if (opcion == 2) {
            // Mostrar tu MenuPrincipalGui
            SwingUtilities.invokeLater(() -> {
                MenuPrincipalGui menu = new MenuPrincipalGui();
                menu.setVisible(true);
            });
            // Opción 3: Salir
        }
        else if (opcion == 3) {
            // Opción 3: Salir
            System.exit(0);
        }
        else {
            System.out.println("Opción inválida. Intenta de nuevo.");
        }
    }
}

