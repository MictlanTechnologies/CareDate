package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.jdbc.impl.DireccionJdbcImpl;
import org.caredatedoc.caredate.jmjmdoc.model.Direccion;
import org.caredatedoc.caredate.jmjmdoc.negocio.Ejecutable;

import java.util.Scanner;

public class RegistroDirPac implements Ejecutable {

    private static RegistroDirPac instance = new RegistroDirPac();
    private boolean flag = false;

    private RegistroDirPac() {}

    public static RegistroDirPac getInstance() {
        return instance;
    }

    @Override
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (!flag) return;

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("\n::::: REGISTRO DE DIRECCIÓN DE PACIENTE :::::");

            System.out.print("ID del paciente: ");
            int idPaciente = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Calle: ");
            String calle = sc.nextLine().trim();

            System.out.print("Número: ");
            int numero = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Colonia: ");
            String colonia = sc.nextLine().trim();

            System.out.print("Alcaldía: ");
            String alcaldia = sc.nextLine().trim();

            System.out.print("Código Postal: ");
            int cp = Integer.parseInt(sc.nextLine().trim());

            // Crear objeto dirección
            Direccion direccion = new Direccion(alcaldia, colonia, calle, numero, cp);

            // Guardar dirección
            boolean dirGuardada = DireccionJdbcImpl.getInstance().save(direccion);

            // Guardar relación dirección-paciente
            if (dirGuardada) {
                boolean rel = DireccionJdbcImpl.getInstance().guardarRelacionPacienteDireccion(
                        idPaciente, direccion.getId()
                );

                if (rel) {
                    System.out.println("Dirección registrada y vinculada correctamente.");
                } else {
                    System.out.println("Dirección guardada, pero no se pudo vincular al paciente.");
                }
            } else {
                System.out.println("No se pudo guardar la dirección.");
            }

        } catch (Exception e) {
            System.err.println("Error al registrar dirección del paciente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}