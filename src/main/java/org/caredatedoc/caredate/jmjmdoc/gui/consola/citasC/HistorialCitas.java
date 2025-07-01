package org.caredatedoc.caredate.jmjmdoc.gui.consola.citasC;

import org.caredatedoc.caredate.jmjmdoc.jdbc.impl.CitaJdbcImpl;
import org.caredatedoc.caredate.jmjmdoc.model.Cita;
import org.caredatedoc.caredate.jmjmdoc.negocio.Ejecutable;

import java.util.List;
import java.util.Scanner;

public class HistorialCitas implements Ejecutable {

    private static final HistorialCitas instancia = new HistorialCitas();
    private boolean flag = false;

    private HistorialCitas() {}

    public static HistorialCitas getInstance() {
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
            System.out.print("Ingresa el ID del paciente: ");
            int idPaciente = Integer.parseInt(sc.nextLine());

            List<Cita> citas = CitaJdbcImpl.getInstance().obtenerCitasPorPaciente(idPaciente);

            if (citas == null || citas.isEmpty()) {
                System.out.println(">>> No hay citas agendadas para este paciente.");
                return;
            }

            System.out.println("\n===== HISTORIAL DE CITAS =====");
            for (Cita c : citas) {
                System.out.println("ID Cita       : " + c.getIdGestionCitas());
                System.out.println("Fecha         : " + c.getDiaCita());
                System.out.println("Horario       : " + c.getHorarioCita());
                System.out.println("Motivo        : " + c.getMotivoGeneral());
                System.out.println("Notas Médicas : " + c.getNotasMed());
                System.out.println("ID Clínica    : " + c.getIdClinica());
                System.out.println("----------------------------------");
            }

        } catch (Exception e) {
            System.err.println(">>> Error al consultar historial: " + e.getMessage());
        }
    }
}