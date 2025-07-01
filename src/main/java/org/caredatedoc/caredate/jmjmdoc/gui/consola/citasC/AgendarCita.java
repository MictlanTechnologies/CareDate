package org.caredatedoc.caredate.jmjmdoc.gui.consola.citasC;

import org.caredatedoc.caredate.jmjmdoc.jdbc.impl.CitaJdbcImpl;
import org.caredatedoc.caredate.jmjmdoc.model.Cita;
import org.caredatedoc.caredate.jmjmdoc.negocio.Ejecutable;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class AgendarCita implements Ejecutable {

    private static final AgendarCita instancia = new AgendarCita();
    private boolean flag = false;
    private int idClinica;
    private AgendarCita() {}

    public static AgendarCita getInstance() {
        return instancia;
    }

    public void setIdClinica(int idClinica) {
        this.idClinica = idClinica;
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
            System.out.print("ID del paciente: ");
            int idPaciente = Integer.parseInt(sc.nextLine());

            System.out.print("Fecha de la cita (YYYY-MM-DD): ");
            LocalDate fecha = LocalDate.parse(sc.nextLine());

            System.out.print("Horario de la cita (HH:MM): ");
            LocalTime hora = LocalTime.parse(sc.nextLine());

            System.out.print("Motivo general de la cita: ");
            String motivo = sc.nextLine();

            System.out.print("Notas médicas (opcional): ");
            String notas = sc.nextLine();

            // Crear nueva cita
            Cita nuevaCita = new Cita();
            nuevaCita.setDiaCita(Date.valueOf(fecha));
            nuevaCita.setHorarioCita(Time.valueOf(hora));
            nuevaCita.setMotivoGeneral(motivo);
            nuevaCita.setNotasMed(notas);
            nuevaCita.setIdPaciente(idPaciente);
            nuevaCita.setIdClinica(idClinica);

            // Guardar en la base de datos
            boolean ok = CitaJdbcImpl.getInstance().agendarCita(nuevaCita);
            if (ok) {
                System.out.println(">>> Cita agendada exitosamente.");
            } else {
                System.out.println(">>> No se pudo agendar la cita.");
            }

        } catch (Exception e) {
            System.err.println(">>> Error al agendar cita: " + e.getMessage());
        }
    }
}