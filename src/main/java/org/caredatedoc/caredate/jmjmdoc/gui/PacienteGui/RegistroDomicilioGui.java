package org.caredatedoc.caredate.jmjmdoc.gui.PacienteGui;

import javax.swing.*;
import java.awt.*;

public class RegistroDomicilioGui extends JFrame {
    public RegistroDomicilioGui() {
        setTitle("Registro de Domicilio del Paciente");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // === Estilos personalizados ===
        Color fondo     = Color.decode("#2E2E2C");
        Color texto     = Color.decode("#f3f1e4");
        Color entrada   = Color.decode("#D5D0C3");
        Color boton     = Color.decode("#B6AC94");

        Font fontSub    = new Font("Aharoni", Font.PLAIN, 18);
        Font fontTxt    = new Font("Aptos Mono", Font.PLAIN, 14);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBackground(fondo);

        JLabel alcaldiaLbl = new JLabel("Alcaldía:");
        alcaldiaLbl.setForeground(texto); alcaldiaLbl.setFont(fontSub);
        JTextField alcaldiaField = new JTextField(); alcaldiaField.setBackground(entrada); alcaldiaField.setFont(fontTxt);
        panel.add(alcaldiaLbl);
        panel.add(alcaldiaField);

        JLabel coloniaLbl = new JLabel("Colonia:");
        coloniaLbl.setForeground(texto); coloniaLbl.setFont(fontSub);
        JTextField coloniaField = new JTextField(); coloniaField.setBackground(entrada); coloniaField.setFont(fontTxt);
        panel.add(coloniaLbl);
        panel.add(coloniaField);

        JLabel calleLbl = new JLabel("Calle:");
        calleLbl.setForeground(texto); calleLbl.setFont(fontSub);
        JTextField calleField = new JTextField(); calleField.setBackground(entrada); calleField.setFont(fontTxt);
        panel.add(calleLbl);
        panel.add(calleField);

        JLabel numeroLbl = new JLabel("Número:");
        numeroLbl.setForeground(texto); numeroLbl.setFont(fontSub);
        JTextField numeroField = new JTextField(); numeroField.setBackground(entrada); numeroField.setFont(fontTxt);
        panel.add(numeroLbl);
        panel.add(numeroField);

        JLabel cpLbl = new JLabel("CP:");
        cpLbl.setForeground(texto); cpLbl.setFont(fontSub);
        JTextField cpField = new JTextField(); cpField.setBackground(entrada); cpField.setFont(fontTxt);
        panel.add(cpLbl);
        panel.add(cpField);

        JButton siguienteBtn = new JButton("Siguiente");
        siguienteBtn.setBackground(boton); siguienteBtn.setFont(fontTxt);
        panel.add(siguienteBtn);

        panel.add(new JLabel()); // Espacio vacío para alinear

        add(panel);

        siguienteBtn.addActionListener(e -> {
            DatosMedicosGui datosMedicosGui = new DatosMedicosGui();
            datosMedicosGui.setVisible(true);
            dispose();
        });
    }
}