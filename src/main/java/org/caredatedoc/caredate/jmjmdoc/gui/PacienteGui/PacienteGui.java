package org.caredatedoc.caredate.jmjmdoc.gui.PacienteGui;

import org.caredatedoc.caredate.jmjmdoc.model.Paciente;

import javax.swing.*;
import java.awt.*;

public class PacienteGui extends JFrame {
    private JTextField nombreField;
    private JTextField aPaternoField;
    private JTextField aMaternoField;
    private JTextField curpField;
    private JTextField fechaNacField;
    private JTextField emailField;
    private JComboBox<String> sexoBox;

    public PacienteGui() {
        setTitle("Registro de Paciente");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        // === Estilos personalizados ===
        Color fondo     = Color.decode("#2E2E2C");
        Color texto     = Color.decode("#f3f1e4");
        Color entrada   = Color.decode("#D5D0C3");
        Color boton     = Color.decode("#B6AC94");

        Font fontSub    = new Font("Aharoni", Font.PLAIN, 18);
        Font fontTxt    = new Font("Aptos Mono", Font.PLAIN, 14);

        JPanel panel = new JPanel(new GridLayout(9, 2, 10, 10));
        panel.setBackground(fondo);

        JLabel nombreLbl = new JLabel("Nombre:");
        nombreLbl.setForeground(texto); nombreLbl.setFont(fontSub);
        panel.add(nombreLbl);
        nombreField = new JTextField(); nombreField.setBackground(entrada); nombreField.setFont(fontTxt);
        panel.add(nombreField);

        JLabel paternoLbl = new JLabel("Apellido Paterno:");
        paternoLbl.setForeground(texto); paternoLbl.setFont(fontSub);
        panel.add(paternoLbl);
        aPaternoField = new JTextField(); aPaternoField.setBackground(entrada); aPaternoField.setFont(fontTxt);
        panel.add(aPaternoField);

        JLabel maternoLbl = new JLabel("Apellido Materno:");
        maternoLbl.setForeground(texto); maternoLbl.setFont(fontSub);
        panel.add(maternoLbl);
        aMaternoField = new JTextField(); aMaternoField.setBackground(entrada); aMaternoField.setFont(fontTxt);
        panel.add(aMaternoField);

        JLabel curpLbl = new JLabel("CURP:");
        curpLbl.setForeground(texto); curpLbl.setFont(fontSub);
        panel.add(curpLbl);
        curpField = new JTextField(); curpField.setBackground(entrada); curpField.setFont(fontTxt);
        panel.add(curpField);

        JLabel fechaLbl = new JLabel("Fecha de Nacimiento (YYYY-MM-DD):");
        fechaLbl.setForeground(texto); fechaLbl.setFont(fontSub);
        panel.add(fechaLbl);
        fechaNacField = new JTextField(); fechaNacField.setBackground(entrada); fechaNacField.setFont(fontTxt);
        panel.add(fechaNacField);

        JLabel sexoLbl = new JLabel("Sexo:");
        sexoLbl.setForeground(texto); sexoLbl.setFont(fontSub);
        panel.add(sexoLbl);
        sexoBox = new JComboBox<>(new String[]{"M", "F"});
        sexoBox.setBackground(entrada); sexoBox.setFont(fontTxt);
        panel.add(sexoBox);

        JLabel correoLbl = new JLabel("Correo Electrónico:");
        correoLbl.setForeground(texto); correoLbl.setFont(fontSub);
        panel.add(correoLbl);
        emailField = new JTextField(); emailField.setBackground(entrada); emailField.setFont(fontTxt);
        panel.add(emailField);

        JButton registrarBtn = new JButton("Registrar");
        registrarBtn.setBackground(boton); registrarBtn.setFont(fontTxt);
        panel.add(registrarBtn);

        JButton cancelarBtn = new JButton("Cancelar");
        cancelarBtn.setBackground(boton); cancelarBtn.setFont(fontTxt);
        panel.add(cancelarBtn);

        add(panel);

        registrarBtn.addActionListener(e -> registrarPaciente());
        cancelarBtn.addActionListener(e -> dispose());
    }

    private void registrarPaciente() {
        try {
            Paciente paciente = new Paciente(
                    nombreField.getText(),
                    aPaternoField.getText(),
                    aMaternoField.getText(),
                    curpField.getText(),
                    fechaNacField.getText(),
                    emailField.getText(),
                    sexoBox.getSelectedItem().toString().charAt(0)
            );

            RegistroDomicilioGui domicilioGui = new RegistroDomicilioGui();
            domicilioGui.setVisible(true);

            dispose();

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Paciente registrado exitosamente.");
    }
}