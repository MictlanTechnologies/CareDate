package org.caredatedoc.caredate.jmjmdoc.gui.PacienteGui;

import javax.swing.*;
import java.awt.*;

public class ModuloCitasGui extends JFrame {

    public ModuloCitasGui(String clinicaSeleccionada) {
        setTitle("Módulo de Citas");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Panel principal con fondo oscuro
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBackground(Color.decode("#2E2E2C"));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título
        JLabel tituloLabel = new JLabel("Clínica Seleccionada:");
        tituloLabel.setFont(new Font("Aharoni", Font.BOLD, 24));
        tituloLabel.setForeground(Color.decode("#f3f1e4"));
        panel.add(tituloLabel);

        JLabel clinicaLabel = new JLabel(clinicaSeleccionada);
        clinicaLabel.setFont(new Font("Aptos Mono", Font.PLAIN, 14));
        clinicaLabel.setForeground(Color.decode("#D5D0C3"));
        panel.add(clinicaLabel);

        JButton agendarBtn = new JButton("Agendar Nueva Cita");
        agendarBtn.setFont(new Font("Aptos Mono", Font.BOLD, 14));
        agendarBtn.setBackground(Color.decode("#B6AC94"));
        agendarBtn.setForeground(Color.decode("#2E2E2C"));
        panel.add(agendarBtn);

        JButton historialBtn = new JButton("Ver Historial de Citas");
        historialBtn.setFont(new Font("Aptos Mono", Font.BOLD, 14));
        historialBtn.setBackground(Color.decode("#B6AC94"));
        historialBtn.setForeground(Color.decode("#2E2E2C"));
        panel.add(historialBtn);

        add(panel);

        agendarBtn.addActionListener(e -> {
            AgendarCitaGui agendarGui = new AgendarCitaGui(clinicaSeleccionada);
            agendarGui.setVisible(true);
            dispose();
        });

        /*historialBtn.addActionListener(e -> {
            HistorialCitasGui historial = new HistorialCitasGui(clinicaSeleccionada);
            historial.setVisible(true);
            dispose();
        });*/
    }
}