package org.caredatedoc.caredate.jmjmdoc.gui.PacienteGui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ConsultarCitasGui extends JFrame {

    public ConsultarCitasGui(String clinicaSeleccionada) {
        setTitle("Consultar Citas - " + clinicaSeleccionada);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Citas en " + clinicaSeleccionada, SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(titulo, BorderLayout.NORTH);

        List<String> citas = (List<String>) BdCitasGui.obtenerCitas(clinicaSeleccionada);

        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        for (String cita : citas) {
            modeloLista.addElement(cita);
        }

        JList<String> listaCitas = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaCitas);
        add(scrollPane, BorderLayout.CENTER);

        JButton cerrarBtn = new JButton("Cerrar");
        cerrarBtn.addActionListener(e -> dispose());
        add(cerrarBtn, BorderLayout.SOUTH);
    }
}
