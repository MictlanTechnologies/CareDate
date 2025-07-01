package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.model.Paciente;
import org.caredatedoc.caredate.jmjmdoc.negocio.Ejecutable;
import org.caredatedoc.caredate.jmjmdoc.jdbc.impl.PacienteJdbcImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RegistroPaciente implements Ejecutable {

    private static RegistroPaciente instance = new RegistroPaciente();
    private boolean flag = false;

    private RegistroPaciente() {}

    public static RegistroPaciente getInstance() {
        return instance;
    }

    @Override
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (!flag) return;

        Scanner sc = new Scanner(System.in);
        String nombre, aPaterno, aMaterno, curp, fechaNac, email;
        char sexo;
        LocalDate fechaConvertida = null;

        try {
            // Nombre
            while (true) {
                System.out.println("::::: REGISTRO PACIENTE :::::");
                System.out.print("Nombre: ");
                nombre = sc.nextLine().trim();
                if (!nombre.isEmpty()) break;
                System.out.println(" El nombre no puede estar vacío.");
            }

            // Apellido paterno
            while (true) {
                System.out.print("Apellido paterno: ");
                aPaterno = sc.nextLine().trim();
                if (!aPaterno.isEmpty()) break;
                System.out.println(" El apellido paterno no puede estar vacío.");
            }

            // Apellido materno
            while (true) {
                System.out.print("Apellido materno: ");
                aMaterno = sc.nextLine().trim();
                if (!aMaterno.isEmpty()) break;
                System.out.println(" El apellido materno no puede estar vacío.");
            }

            // CURP
            while (true) {
                System.out.print("CURP (18 caracteres): ");
                curp = sc.nextLine().trim().toUpperCase();
                if (curp.matches("^[A-Z0-9]{18}$")) break;
                System.out.println(" CURP inválida. Debe tener exactamente 18 caracteres alfanuméricos.");
            }

            // Fecha de nacimiento
            while (true) {
                System.out.print("Fecha de nacimiento (dd/MM/yyyy): ");
                fechaNac = sc.nextLine().trim();
                try {
                    DateTimeFormatter entrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    fechaConvertida = LocalDate.parse(fechaNac, entrada);
                    break;
                } catch (Exception e) {
                    System.out.println(" Fecha inválida. Usa el formato dd/MM/yyyy.");
                }
            }

            // Sexo
            while (true) {
                System.out.print("Sexo (M/F): ");
                String inputSexo = sc.nextLine().trim().toUpperCase();
                if (inputSexo.length() == 1 && (inputSexo.charAt(0) == 'M' || inputSexo.charAt(0) == 'F')) {
                    sexo = inputSexo.charAt(0);
                    break;
                }
                System.out.println(" Sexo inválido. Ingresa 'M' o 'F'.");
            }

            // Email
            while (true) {
                System.out.print("Email: ");
                email = sc.nextLine().trim().toLowerCase();
                if (!email.isEmpty()) {
                    if (!email.contains("@")) {
                        email += "@gmail.com";
                    } else if (!email.endsWith("@gmail.com")) {
                        System.out.println(" Solo se permiten correos @gmail.com.");
                        continue;
                    }
                    break;
                }
                System.out.println(" El email no puede estar vacío.");
            }

            // Crear objeto paciente
            Paciente paciente = new Paciente(nombre, aPaterno, aMaterno, curp, fechaNac, email, sexo);

            // Guardar en la base de datos
            boolean guardado = PacienteJdbcImpl.getInstance().save(paciente);
            if (guardado) {
                System.out.println("Paciente registrado correctamente.");
            } else {
                System.out.println("Error al guardar el paciente en la base de datos.");
            }

        } catch (Exception e) {
            System.err.println("Error general en el registro del paciente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}