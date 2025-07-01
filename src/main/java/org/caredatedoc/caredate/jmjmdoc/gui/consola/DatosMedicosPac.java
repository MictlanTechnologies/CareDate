package org.caredatedoc.caredate.jmjmdoc.gui.consola;

import org.caredatedoc.caredate.jmjmdoc.negocio.Ejecutable;
import org.caredatedoc.caredate.jmjmdoc.jdbc.impl.Conexion;

import java.sql.PreparedStatement;
import java.util.Scanner;

public class DatosMedicosPac extends Conexion<Object> implements Ejecutable {

    private static DatosMedicosPac instance = new DatosMedicosPac();
    private boolean flag = false;

    private DatosMedicosPac() {}

    public static DatosMedicosPac getInstance() {
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
        String tipoSangre = "", medicamentos = "", enfCronicas = "", alergias = "", cirugiasPre = "";

        try {
            System.out.println("::::: REGISTRO DATOS MÉDICOS DEL PACIENTE :::::");

            // ID del paciente
            System.out.print("ID del paciente: ");
            int idPaciente = Integer.parseInt(sc.nextLine().trim());

            // tipoSangre
            while (true) {
                System.out.print("Tipo de Sangre: ");
                tipoSangre = sc.nextLine().trim();
                if (!tipoSangre.isEmpty()) break;
                System.out.println("El tipo de sangre no puede estar vacío.");
            }

            // Medicamentos
            while (true) {
                System.out.print("¿Actualmente consume algún medicamento recetado por su médico? (S/N): ");
                String respuesta = sc.nextLine().trim().toUpperCase();

                if (respuesta.equals("S")) {
                    System.out.print("Indique qué medicamentos consume: ");
                    medicamentos = sc.nextLine().trim();
                    if (!medicamentos.isEmpty()) break;
                    System.out.println("La lista de medicamentos no puede estar vacía.");
                } else if (respuesta.equals("N")) {
                    medicamentos = "Ninguno";
                    break;
                } else {
                    System.out.println("Opción inválida. Escribe S para sí o N para no.");
                }
            }

            // Enfermedades Crónicas
            while (true) {
                System.out.print("¿Actualmente sufre de alguna enfermedad crónica? (S/N): ");
                String respuestaEnf = sc.nextLine().trim().toUpperCase();

                if (respuestaEnf.equals("S")) {
                    System.out.print("Indique qué enfermedad crónica padece: ");
                    enfCronicas = sc.nextLine().trim();
                    if (!enfCronicas.isEmpty()) break;
                    System.out.println("Este campo no puede estar vacío.");
                } else if (respuestaEnf.equals("N")) {
                    enfCronicas = "Ninguna";
                    break;
                } else {
                    System.out.println("Opción inválida. Escribe S para sí o N para no.");
                }
            }

            // Alergias
            while (true) {
                System.out.print("¿Actualmente padece de alguna alergia? (S/N): ");
                String respuestaAlg = sc.nextLine().trim().toUpperCase();

                if (respuestaAlg.equals("S")) {
                    System.out.print("Indique qué alergia padece: ");
                    alergias = sc.nextLine().trim();
                    if (!alergias.isEmpty()) break;
                    System.out.println("Este campo no puede estar vacío.");
                } else if (respuestaAlg.equals("N")) {
                    alergias = "Ninguna";
                    break;
                } else {
                    System.out.println("Opción inválida. Escribe S para sí o N para no.");
                }
            }

            // Cirugías Previas
            while (true) {
                System.out.print("¿Se ha realizado algún procedimiento quirúrgico? (S/N): ");
                String respuestaCir = sc.nextLine().trim().toUpperCase();

                if (respuestaCir.equals("S")) {
                    System.out.print("Indique qué cirugías se ha realizado: ");
                    cirugiasPre = sc.nextLine().trim();
                    if (!cirugiasPre.isEmpty()) break;
                    System.out.println("Este campo no puede estar vacío.");
                } else if (respuestaCir.equals("N")) {
                    cirugiasPre = "Ninguna";
                    break;
                } else {
                    System.out.println("Opción inválida. Escribe S para sí o N para no.");
                }
            }

            // Insertar en base de datos
            int idDatosMed = (int) (Math.random() * 1000000);
            String query = "INSERT INTO datosPaciente (idDatosMedicos, alergias, medicamentos, cirugiasPrevias, tipoSangre, enfermedadesCronicas, idPaciente) VALUES (?, ?, ?, ?, ?, ?, ?)";

            if (!openConnection()) {
                System.out.println("Error al conectar a la base de datos.");
                return;
            }

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idDatosMed);
            ps.setString(2, alergias);
            ps.setString(3, medicamentos);
            ps.setString(4, cirugiasPre);
            ps.setString(5, tipoSangre);
            ps.setString(6, enfCronicas);
            ps.setInt(7, idPaciente);

            int resultado = ps.executeUpdate();
            ps.close();
            closeConnection();

            if (resultado == 1) {
                System.out.println("Datos médicos guardados correctamente.");
            } else {
                System.out.println("No se pudieron guardar los datos médicos.");
            }

        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}