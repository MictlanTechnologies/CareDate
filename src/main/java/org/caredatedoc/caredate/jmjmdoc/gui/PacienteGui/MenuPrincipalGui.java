package org.caredatedoc.caredate.jmjmdoc.gui.PacienteGui;

import org.caredatedoc.caredate.jmjmdoc.gui.PacienteGui.PacienteGui;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipalGui extends JFrame {

    public MenuPrincipalGui() {
        setTitle("Menú Principal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel(new GridLayout(3, 1, 15, 15));
        panel.setBackground(Color.decode("#2E2E2C"));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título
        JLabel tituloLabel = new JLabel("CareDate - Menú Principal", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Aharoni", Font.BOLD, 24));
        tituloLabel.setForeground(Color.decode("#f3f1e4"));
        panel.add(tituloLabel);

        // Botón Registrar Paciente
        JButton registrarPacienteBtn = new JButton("Registrar Paciente");
        registrarPacienteBtn.setFont(new Font("Aptos Mono", Font.PLAIN, 14));
        registrarPacienteBtn.setBackground(Color.decode("#B6AC94"));
        registrarPacienteBtn.setForeground(Color.decode("#2E2E2C"));
        panel.add(registrarPacienteBtn);

        // Botón Salir
        JButton salirBtn = new JButton("Salir");
        salirBtn.setFont(new Font("Aptos Mono", Font.PLAIN, 14));
        salirBtn.setBackground(Color.decode("#D5D0C3"));
        salirBtn.setForeground(Color.decode("#2E2E2C"));
        panel.add(salirBtn);

        add(panel);

        registrarPacienteBtn.addActionListener(e -> {
            PacienteGui pacienteGui = new PacienteGui();
            pacienteGui.setVisible(true);
            dispose();
        });

        salirBtn.addActionListener(e -> dispose());
    }
}