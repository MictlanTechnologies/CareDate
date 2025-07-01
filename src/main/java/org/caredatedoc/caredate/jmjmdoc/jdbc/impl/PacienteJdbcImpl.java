package org.caredatedoc.caredate.jmjmdoc.jdbc.impl;

import org.caredatedoc.caredate.jmjmdoc.model.Paciente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PacienteJdbcImpl extends Conexion<Paciente> implements PacienteJdbc {
    private static PacienteJdbcImpl pacienteJdbc;

    private PacienteJdbcImpl() {
        super();
    }

    public static PacienteJdbcImpl getInstance() {
        if (pacienteJdbc == null) {
            pacienteJdbc = new PacienteJdbcImpl();
        }
        return pacienteJdbc;
    }

    @Override
    public List<Paciente> findAll() {
        Statement statement;
        ResultSet resultSet;
        List<Paciente> list = null;
        Paciente paciente;
        String sql = "SELECT * FROM paciente";

        try {
            if (!openConnection()) {
                System.out.println("ERROR");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet == null) return null;

            list = new java.util.ArrayList<>();

            while (resultSet.next()) {
                paciente = new Paciente();
                paciente.setId(resultSet.getInt("IDPACIENTE"));
                paciente.setNombre(resultSet.getString("NOMBRE"));
                paciente.setaPaterno(resultSet.getString("APATERNO"));
                paciente.setaMaterno(resultSet.getString("AMATERNO"));
                paciente.setCurp(resultSet.getString("CURP"));
                paciente.setFechaNac(resultSet.getString("FECHANAC"));
                paciente.setSexo(resultSet.getString("SEXO").charAt(0));
                paciente.setEmail(resultSet.getString("EMAILPACIENTE"));

                list.add(paciente);
            }

            resultSet.close();
            closeConnection();
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(Paciente paciente) {
        PreparedStatement preparedStatement;
        String query = "INSERT INTO paciente (NOMBRE, APATERNO, AMATERNO, CURP, FECHANAC, SEXO, EMAILPACIENTE) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }

            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaLocal = LocalDate.parse(paciente.getFechaNac(), formatter);
            java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaLocal);

            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getaPaterno());
            preparedStatement.setString(3, paciente.getaMaterno());
            preparedStatement.setString(4, paciente.getCurp());
            preparedStatement.setDate(5, fechaSQL);
            preparedStatement.setString(6, String.valueOf(paciente.getSexo()));
            preparedStatement.setString(7, paciente.getEmail());

            int res = preparedStatement.executeUpdate();

            if (res > 0) {
                ResultSet keys = preparedStatement.getGeneratedKeys();
                if (keys.next()) {
                    paciente.setId(keys.getInt(1));
                }
                keys.close();
            }

            preparedStatement.close();
            closeConnection();

            return res == 1;

        } catch (Exception e) {
            System.err.println("Error al guardar el paciente en la base de datos: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Paciente findById(Integer id) {
        Statement statement;
        ResultSet resultSet;
        Paciente paciente = null;
        String sql = String.format("SELECT * FROM paciente WHERE IDPACIENTE = %d", id);

        try {
            if (!openConnection()) return null;

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                paciente = new Paciente();
                paciente.setId(resultSet.getInt("IDPACIENTE"));
                paciente.setNombre(resultSet.getString("NOMBRE"));
                paciente.setaPaterno(resultSet.getString("APATERNO"));
                paciente.setaMaterno(resultSet.getString("AMATERNO"));
                paciente.setCurp(resultSet.getString("CURP"));
                paciente.setFechaNac(resultSet.getString("FECHANAC"));
                paciente.setSexo(resultSet.getString("SEXO").charAt(0));
                paciente.setEmail(resultSet.getString("EMAILPACIENTE"));
            }

            resultSet.close();
            closeConnection();
            return paciente;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}