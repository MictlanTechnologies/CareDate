package org.caredatedoc.caredate.jmjmdoc.gui.PacienteGui;

import java.util.ArrayList;
import java.util.List;

public class BdCitasGui {

    // Simulación de base de datos en memoria
    private static final List<String> citas = new ArrayList<>();

    // Este método devuelve la lista de citas filtradas por clínica
    public static List<String> obtenerCitas(String clinicaSeleccionada) {
        List<String> resultado = new ArrayList<>();

        // Aquí solo agregamos citas que coincidan con la clínica seleccionada
        for (String cita : citas) {
            if (cita.contains(clinicaSeleccionada)) {
                resultado.add(cita);
            }
        }

        return resultado;
    }

    // Agregar nueva cita
    public static void agregarCita(String clinicaSeleccionada, String citaDetalle) {
        citas.add("[" + clinicaSeleccionada + "] " + citaDetalle);
    }

    // Eliminar cita exacta
    public static void eliminarCita(String clinicaSeleccionada, String citaDetalle) {
        citas.remove("[" + clinicaSeleccionada + "] " + citaDetalle);
    }
}
