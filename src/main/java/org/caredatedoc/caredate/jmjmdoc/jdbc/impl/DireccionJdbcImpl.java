package org.caredatedoc.caredate.jmjmdoc.jdbc.impl;

import org.caredatedoc.caredate.jmjmdoc.model.Direccion;

import java.sql.*;

/**
 * JDBC para guardar dirección y vincularla con un paciente.
 */
public class DireccionJdbcImpl extends Conexion<Direccion> {

    private static DireccionJdbcImpl direccionJdbc;

    private DireccionJdbcImpl() {
        super();
    }

    public static DireccionJdbcImpl getInstance() {
        if (direccionJdbc == null) {
            direccionJdbc = new DireccionJdbcImpl();
        }
        return direccionJdbc;
    }

    public boolean save(Direccion direccion) {
        PreparedStatement preparedStatement;
        String query = "INSERT INTO direccion (ALCALDIA, COLONIA, CALLE, NUMERO, CP) VALUES (?, ?, ?, ?, ?)";

        try {
            if (!openConnection()) {
                System.out.println("❌ Error de conexión al guardar dirección.");
                return false;
            }

            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, direccion.getAlcaldiaP());
            preparedStatement.setString(2, direccion.getColoniaP());
            preparedStatement.setString(3, direccion.getCalleP());
            preparedStatement.setInt(4, direccion.getNumeroP());
            preparedStatement.setInt(5, direccion.getCpP());

            int res = preparedStatement.executeUpdate();

            if (res > 0) {
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    direccion.setId(rs.getInt(1));
                }
                rs.close();
            }

            preparedStatement.close();
            closeConnection();
            return res == 1;

        } catch (SQLException e) {
            System.err.println("❌ Error al guardar dirección: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean guardarRelacionPacienteDireccion(int idPaciente, int idDireccion) {
        PreparedStatement stmt;
        String query = "INSERT INTO relDirPac (idRelDirPac, idDireccion, idPaciente) VALUES (?, ?, ?)";

        try {
            if (!openConnection()) {
                System.out.println("❌ No se pudo abrir la conexión para relDirPac");
                return false;
            }

            int idRelDirPac = (int) (Math.random() * 1000000); // ❗ Mejor si lo haces AUTO_INCREMENT

            stmt = connection.prepareStatement(query);
            stmt.setInt(1, idRelDirPac);
            stmt.setInt(2, idDireccion);
            stmt.setInt(3, idPaciente);

            int filas = stmt.executeUpdate();
            stmt.close();
            closeConnection();

            return filas == 1;

        } catch (SQLException e) {
            System.err.println("❌ Error al insertar relación dirección-paciente: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}