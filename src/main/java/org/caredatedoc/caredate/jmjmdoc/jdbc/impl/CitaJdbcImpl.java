package org.caredatedoc.caredate.jmjmdoc.jdbc.impl;

import org.caredatedoc.caredate.jmjmdoc.model.Cita;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitaJdbcImpl extends Conexion<Cita> implements CitaJdbc {

    private static CitaJdbcImpl instancia;

    public static CitaJdbcImpl getInstance() {
        if (instancia == null)
            instancia = new CitaJdbcImpl();
        return instancia;
    }

    @Override
    public boolean agendarCita(Cita cita) {
        String sql = "INSERT INTO gestionCitas (diaCita, horarioCita, motivoGeneral, notasMed, idPaciente, idClinica) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            if (!openConnection()) return false;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, cita.getDiaCita());
            ps.setTime(2, cita.getHorarioCita());
            ps.setString(3, cita.getMotivoGeneral());
            ps.setString(4, cita.getNotasMed());
            ps.setInt(5, cita.getIdPaciente());
            ps.setInt(6, cita.getIdClinica());
            int result = ps.executeUpdate();
            ps.close();
            closeConnection();
            return result == 1;
        } catch (Exception e) {
            System.out.println("Error al agendar cita: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminarCita(int idCita) {
        String sql = "DELETE FROM gestionCitas WHERE idGestionCitas = ?";
        try {
            if (!openConnection()) return false;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idCita);
            int result = ps.executeUpdate();
            ps.close();
            closeConnection();
            return result == 1;
        } catch (Exception e) {
            System.out.println("Error al eliminar cita: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Cita> obtenerCitasPorPaciente(int idPaciente) {
        List<Cita> lista = new ArrayList<>();
        String sql = "SELECT * FROM gestionCitas WHERE idPaciente = ?";
        try {
            if (!openConnection()) return null;
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cita c = new Cita();
                c.setIdGestionCitas(rs.getInt("idGestionCitas"));
                c.setDiaCita(rs.getDate("diaCita"));
                c.setHorarioCita(rs.getTime("horarioCita"));
                c.setMotivoGeneral(rs.getString("motivoGeneral"));
                c.setNotasMed(rs.getString("notasMed"));
                c.setIdPaciente(rs.getInt("idPaciente"));
                c.setIdClinica(rs.getInt("idClinica"));
                lista.add(c);
            }
            rs.close();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            System.out.println("Error al obtener citas: " + e.getMessage());
        }
        return lista;
    }
}