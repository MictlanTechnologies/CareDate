package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.gui.consola.citasC.AgendarCita;
import org.caredatedoc.caredate.jmjmdoc.gui.consola.citasC.EliminarCita;
import org.caredatedoc.caredate.jmjmdoc.gui.consola.citasC.HistorialCitas;
import org.caredatedoc.caredate.jmjmdoc.negocio.Ejecutable;

import java.util.Scanner;

public class ClinicasCatalogo implements Ejecutable {

    private static ClinicasCatalogo instancia;

    private ClinicasCatalogo() {}

    public static ClinicasCatalogo getInstance() {
        if (instancia == null) {
            instancia = new ClinicasCatalogo();
        }
        return instancia;
    }

    @Override
    public void setFlag(boolean flag) {}

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);

        String[] clinicas = {
                "1. Av. Instituto Politécnico Nacional 123, Lindavista, Gustavo A. Madero",
                "2. Calzada de los Gallos 55, San Álvaro, Azcapotzalco",
                "3. Av. Universidad 460, Copilco, Coyoacán",
                "4. Av. Presidente Masaryk 112, Polanco, Miguel Hidalgo",
                "5. Av. Revolución 899, San Ángel, Álvaro Obregón",
                "6. Av. Insurgentes Sur 1432, Del Valle, Benito Juárez",
                "7. Prolongación División del Norte 307, Santa Cruz Acalpixca, Xochimilco",
                "8. Av. Montevideo 300, La Villa, Gustavo A. Madero",
                "9. Calle Clavería 100, Clavería, Azcapotzalco",
                "10. Calle Felipe Carrillo 140, Villa Coyoacán, Coyoacán",
                "11. Bahía de San Hipólito 250, Anzures, Miguel Hidalgo",
                "12. Calle 10 541, Olivar del Conde, Álvaro Obregón",
                "13. Av. Cuauhtémoc 500, Narvarte, Benito Juárez",
                "14. Calle Pino 150, San Mateo Xalpa, Xochimilco",
                "15. Calzada Ticomán 601, San Pedro Zacatenco, Gustavo A. Madero",
                "16. Calle Fresno 33, San Miguel Amantla, Azcapotzalco",
                "17. Calle Cerro del Agua 90, Pedregal de Santo Domingo, Coyoacán",
                "18. Av. Marina Nacional 212, Tacuba, Miguel Hidalgo",
                "19. Calle Goya 119, Colinas del Sur, Álvaro Obregón",
                "20. Av. Patriotismo 655, Nápoles, Benito Juárez"
        };

        System.out.println("::::: LISTA DE CLÍNICAS :::::");
        for (String clinica : clinicas) {
            System.out.println(clinica);
        }

        System.out.print("Selecciona el ID de la clínica: ");
        int idClinicaSeleccionada;
        try {
            idClinicaSeleccionada = Integer.parseInt(sc.nextLine());
            if (idClinicaSeleccionada < 1 || idClinicaSeleccionada > clinicas.length) {
                System.out.println(">>> ID de clínica no válido.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println(">>> Entrada inválida.");
            return;
        }

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nMENÚ DE PACIENTE:");
            System.out.println("1. Agendar cita");
            System.out.println("2. Cancelar cita");
            System.out.println("3. Consultar historial de citas");
            System.out.println("4. Salir");

            System.out.print("Selecciona una opción: ");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println(">>> Has elegido: Agendar cita");
                    AgendarCita.getInstance().setIdClinica(idClinicaSeleccionada);
                    AgendarCita.getInstance().setFlag(true);
                    AgendarCita.getInstance().run();
                    break;
                case 2:
                    System.out.println(">>> Has elegido: Cancelar cita");
                    EliminarCita.getInstance().setFlag(true);
                    EliminarCita.getInstance().run();
                    break;
                case 3:
                    System.out.println(">>> Has elegido: Consultar historial de citas");
                    HistorialCitas.getInstance().setFlag(true);
                    HistorialCitas.getInstance().run();
                    break;
                case 4:
                    System.out.println(">>> Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println(">>> Opción inválida.");
            }
        }
    }
}