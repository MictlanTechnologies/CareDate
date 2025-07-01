package org.caredatedoc.caredate.jmjmdoc.gui.PacienteGui;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class AgendarCitaGui extends JFrame {
    private UtilDateModel dateModel;
    private JDatePickerImpl datePicker;
    private JComboBox<String> horarioCombo;

    public AgendarCitaGui(String clinicaSeleccionada) {
        setTitle("Agendar Cita");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));
        getContentPane().setBackground(Color.decode("#2E2E2C"));

        Font fontTitulo     = new Font("Aharoni", Font.BOLD, 24);
        Font fontSubtitulo  = new Font("Aharoni", Font.PLAIN, 18);
        Font fontTexto      = new Font("Aptos Mono", Font.PLAIN, 14);

        // Modelo y configuración del datepicker
        dateModel = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Hoy");
        p.put("text.month", "Mes");
        p.put("text.year", "Año");
        JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        JLabel fechaLbl = new JLabel("Seleccione la fecha:");
        fechaLbl.setForeground(Color.decode("#f3f1e4"));
        fechaLbl.setFont(fontSubtitulo);
        add(fechaLbl);
        add(datePicker);

        JLabel horarioLbl = new JLabel("Seleccione el horario:");
        horarioLbl.setForeground(Color.decode("#f3f1e4"));
        horarioLbl.setFont(fontSubtitulo);
        add(horarioLbl);

        horarioCombo = new JComboBox<>();
        horarioCombo.setBackground(Color.decode("#D5D0C3"));
        horarioCombo.setFont(fontTexto);
        add(horarioCombo);

        dateModel.addChangeListener(e -> actualizarHorariosDisponibles());

        JButton agendarBtn = new JButton("Agendar Cita");
        agendarBtn.setBackground(Color.decode("#B6AC94"));
        agendarBtn.setFont(fontTexto);
        add(agendarBtn);

        agendarBtn.addActionListener(e -> agendarCita());
    }

    private void actualizarHorariosDisponibles() {
        horarioCombo.removeAllItems();
        Date fechaSeleccionada = (Date) datePicker.getModel().getValue();
        if (fechaSeleccionada == null) return;

        String[] horarios = {
                "09:00 AM", "10:00 AM", "11:00 AM",
                "01:00 PM", "02:00 PM", "03:00 PM"
        };

        for (String h : horarios) {
            horarioCombo.addItem(h);
        }
    }

    private void agendarCita() {
        Date fecha = (Date) datePicker.getModel().getValue();
        String horario = (String) horarioCombo.getSelectedItem();

        if (fecha == null) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fecha.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (horario == null) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un horario.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaStr = sdf.format(fecha);

        JOptionPane.showMessageDialog(this,
                "Cita agendada para el " + fechaStr + " a las " + horario + ".");
        dispose();
    }

    public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
        private final String datePattern = "dd/MM/yyyy";
        private final SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }
            return "";
        }
    }
}