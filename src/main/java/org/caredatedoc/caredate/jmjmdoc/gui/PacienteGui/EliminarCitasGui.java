package org.caredatedoc.caredate.jmjmdoc.gui.PacienteGui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EliminarCitasGui extends JFrame {

        public EliminarCitasGui(String clinicaSeleccionada) {
            setTitle("Eliminar Citas - " + clinicaSeleccionada);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setSize(400, 300);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout());

            JLabel titulo = new JLabel("Selecciona una cita para eliminar", SwingConstants.CENTER);
            titulo.setFont(new Font("Arial", Font.BOLD, 16));
            add(titulo, BorderLayout.NORTH);

            DefaultListModel<String> modeloLista = new DefaultListModel<>();
            JList<String> listaCitas = new JList<>(modeloLista);
            JScrollPane scrollPane = new JScrollPane(listaCitas);
            add(scrollPane, BorderLayout.CENTER);

            List<String> citas = (List<String>) BdCitasGui.obtenerCitas(clinicaSeleccionada);
            for (String cita : citas) {
                modeloLista.addElement(cita);
            }

            JPanel panelBotones = new JPanel();

            JButton eliminarBtn = new JButton("Eliminar");
            JButton cerrarBtn = new JButton("Cerrar");

            panelBotones.add(eliminarBtn);
            panelBotones.add(cerrarBtn);
            add(panelBotones, BorderLayout.SOUTH);

            eliminarBtn.addActionListener(e -> {
                int indice = listaCitas.getSelectedIndex();
                if (indice >= 0) {
                    String citaSeleccionada = listaCitas.getSelectedValue();

                    int confirm = JOptionPane.showConfirmDialog(
                            this,
                            "¿Seguro que deseas eliminar esta cita?\n" + citaSeleccionada,
                            "Confirmar Eliminación",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (confirm == JOptionPane.YES_OPTION) {
                        BdCitasGui.eliminarCita(clinicaSeleccionada, citaSeleccionada);
                        modeloLista.remove(indice);
                        JOptionPane.showMessageDialog(this, "Cita eliminada.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Selecciona una cita para eliminar.");
                }
            });

            cerrarBtn.addActionListener(e -> dispose());
        }
}
