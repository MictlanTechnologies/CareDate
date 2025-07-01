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
        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
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

        JButton consultarBtn = new JButton("Consultar Citas");
        consultarBtn.setFont(new Font("Aptos Mono", Font.BOLD, 14));
        consultarBtn.setBackground(Color.decode("#B6AC94"));
        consultarBtn.setForeground(Color.decode("#2E2E2C"));
        panel.add(consultarBtn);

        JButton eliminarBtn = new JButton("Eliminar Cita");
        eliminarBtn.setFont(new Font("Aptos Mono", Font.BOLD, 14));
        eliminarBtn.setBackground(Color.decode("#B6AC94"));
        eliminarBtn.setForeground(Color.decode("#2E2E2C"));
        panel.add(eliminarBtn);

        JButton menuBtn = new JButton("Menú Principal");
        menuBtn.setFont(new Font("Aptos Mono", Font.BOLD, 14));
        menuBtn.setBackground(Color.decode("#D5D0C3"));
        menuBtn.setForeground(Color.decode("#2E2E2C"));
        panel.add(menuBtn);

        add(panel);

        agendarBtn.addActionListener(e -> {
            AgendarCitaGui agendarGui = new AgendarCitaGui(clinicaSeleccionada);
            agendarGui.setVisible(true);
            dispose();
        });

        consultarBtn.addActionListener(e -> {
            ConsultarCitasGui consultarGui = new ConsultarCitasGui(clinicaSeleccionada);
            consultarGui.setVisible(true);
        });

        eliminarBtn.addActionListener(e -> {
            EliminarCitasGui eliminarGui = new EliminarCitasGui(clinicaSeleccionada);
            eliminarGui.setVisible(true);
        });

        menuBtn.addActionListener(e -> {
            MenuPrincipalGui menu = new MenuPrincipalGui();
            menu.setVisible(true);
        });
    }
}