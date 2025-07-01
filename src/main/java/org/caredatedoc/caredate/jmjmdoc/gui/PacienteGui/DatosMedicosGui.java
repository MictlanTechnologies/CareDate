package org.caredatedoc.caredate.jmjmdoc.gui.PacienteGui;

import javax.swing.*;
import java.awt.*;

public class DatosMedicosGui extends JFrame {

    public DatosMedicosGui() {
        setTitle("Datos Médicos del Paciente");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Colores personalizados
        Color fondo = Color.decode("#2E2E2C");
        Color texto = Color.decode("#f3f1e4");
        Color boton = Color.decode("#D5D0C3");

        // Título
        JLabel titulo = new JLabel("Registrar Datos Médicos", SwingConstants.CENTER);
        titulo.setFont(new Font("Aharoni", Font.BOLD, 24));
        titulo.setForeground(texto);

        // Panel de formulario
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBackground(fondo);

        // Etiquetas y campos
        JLabel alergiasLbl = new JLabel("¿Tiene alguna alergia?");
        alergiasLbl.setFont(new Font("Aharoni", Font.PLAIN, 18));
        alergiasLbl.setForeground(texto);
        JTextField alergiasField = new JTextField();
        alergiasField.setFont(new Font("Aptos Mono", Font.PLAIN, 14));

        JLabel enfermedadesLbl = new JLabel("¿Padece una enfermedade crónica?");
        enfermedadesLbl.setFont(new Font("Aharoni", Font.PLAIN, 18));
        enfermedadesLbl.setForeground(texto);
        JTextField enfermedadesField = new JTextField();
        enfermedadesField.setFont(new Font("Aptos Mono", Font.PLAIN, 14));

        JLabel medicamentosLbl = new JLabel("¿Actualmente consume algún medicamento?");
        medicamentosLbl.setFont(new Font("Aharoni", Font.PLAIN, 18));
        medicamentosLbl.setForeground(texto);
        JTextField medicamentosField = new JTextField();
        medicamentosField.setFont(new Font("Aptos Mono", Font.PLAIN, 14));

        JLabel cirugiasLbl = new JLabel("¿Ha tenido cirugías?");
        cirugiasLbl.setFont(new Font("Aharoni", Font.PLAIN, 18));
        cirugiasLbl.setForeground(texto);
        JTextField cirugiasField = new JTextField();
        cirugiasField.setFont(new Font("Aptos Mono", Font.PLAIN, 14));

        JLabel tipoSangreLbl = new JLabel("Seleccione su tipo de sangre:");
        tipoSangreLbl.setFont(new Font("Aharoni", Font.PLAIN, 18));
        tipoSangreLbl.setForeground(texto);
        JComboBox<String> tipoSangreBox = new JComboBox<>(new String[]{
                "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"
        });
        tipoSangreBox.setFont(new Font("Aptos Mono", Font.PLAIN, 14));

        // Agregar componentes al panel
        panel.add(alergiasLbl);      panel.add(alergiasField);
        panel.add(enfermedadesLbl);  panel.add(enfermedadesField);
        panel.add(medicamentosLbl);  panel.add(medicamentosField);
        panel.add(cirugiasLbl);      panel.add(cirugiasField);
        panel.add(tipoSangreLbl);    panel.add(tipoSangreBox);

        // Botón
        JButton finalizarBtn = new JButton("Finalizar Registro");
        finalizarBtn.setFont(new Font("Aharoni", Font.PLAIN, 18));
        finalizarBtn.setBackground(boton);
        finalizarBtn.setForeground(Color.BLACK);

        // Panel contenedor general
        JPanel contenedor = new JPanel(new BorderLayout(10, 10));
        contenedor.setBackground(fondo);
        contenedor.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        contenedor.add(titulo, BorderLayout.NORTH);
        contenedor.add(panel, BorderLayout.CENTER);
        contenedor.add(finalizarBtn, BorderLayout.SOUTH);

        add(contenedor);

        // Acción del botón
        finalizarBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Datos médicos registrados correctamente.",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);

            int opcion = JOptionPane.showOptionDialog(
                    this,
                    "¿Deseas consultar clínicas disponibles o salir?",
                    "¿Qué deseas hacer?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[]{"Consultar clínicas", "Salir"},
                    "Consultar clínicas"
            );

            if (opcion == 0) {
                SeleccionClinicaGui selector = new SeleccionClinicaGui();
                selector.seleccionarClinica();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Gracias por usar CareDate.");
                dispose();
            }
        });
    }
}