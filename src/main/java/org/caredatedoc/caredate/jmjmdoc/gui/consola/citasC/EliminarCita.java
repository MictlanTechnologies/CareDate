package org.caredatedoc.caredate.jmjmdoc.gui.consola.citasC;

import org.caredatedoc.caredate.jmjmdoc.jdbc.impl.CitaJdbcImpl;
import org.caredatedoc.caredate.jmjmdoc.negocio.Ejecutable;

import java.util.Scanner;

/**
 * Permite eliminar una cita por ID.
 */
public class EliminarCita implements Ejecutable {

    private static final EliminarCita instancia = new EliminarCita();
    private boolean flag = false;

    private EliminarCita() {}

    public static EliminarCita getInstance() {
        return instancia;
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
            System.out.print("ID de la cita a eliminar: ");
            int id = Integer.parseInt(sc.nextLine());

            if (CitaJdbcImpl.getInstance().eliminarCita(id)) {
                System.out.println(">>> Cita eliminada correctamente.");
            } else {
                System.out.println(">>> No se pudo eliminar la cita.");
            }

        } catch (Exception e) {
            System.err.println(">>> Error: " + e.getMessage());
        }
    }
}