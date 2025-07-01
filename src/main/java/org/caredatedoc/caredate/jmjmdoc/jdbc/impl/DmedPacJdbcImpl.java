package org.caredatedoc.caredate.jmjmdoc.jdbc.impl;

import org.caredatedoc.caredate.jmjmdoc.model.DatosMedPac;
import org.caredatedoc.caredate.jmjmdoc.model.Direccion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DmedPacJdbcImpl extends Conexion<DatosMedPac> implements DmedPacJdbc {

    private static DmedPacJdbcImpl dmedPacJdbc;

    private DmedPacJdbcImpl() {
        super();
    }

    public static DmedPacJdbcImpl getInstance() {
        if (dmedPacJdbc == null) {
            dmedPacJdbc = new DmedPacJdbcImpl();
        }
        return dmedPacJdbc;
    }

    @Override
    public List<DatosMedPac> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<DatosMedPac> list = null;
        DatosMedPac datosMedPac = null;
        String sql ="SELECT * FROM datosPaciente";

        try
        {
            if (!openConnection()) {
                System.out.println("ERROR");
                return null;
            } else {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);
                if (resultSet == null) {
                    return null;
                }
                list = new java.util.ArrayList<DatosMedPac>();
                while (resultSet.next()) {
                    datosMedPac = new DatosMedPac();
                    datosMedPac.setId(resultSet.getInt("ID"));
                    datosMedPac.setAlergias(resultSet.getString("ALERGIAS"));
                    datosMedPac.setMedicamentos(resultSet.getString("MEDICAMENTOS"));
                    datosMedPac.setCirugiasPre(resultSet.getString("CIRUGIASPREVIAS"));
                    datosMedPac.setTipoSangre(resultSet.getString("TIPOSANGRE"));
                    datosMedPac.setEnfCronicas(resultSet.getString("ENFERMEDADESCRONICAS"));
                    list.add(datosMedPac);
                }
                resultSet.close();
                closeConnection();
                return list;
            }
        }
        catch (SQLException e)
        {
            return null;
        }
    }


    @Override
    public boolean save(DatosMedPac datosMedPac, int idPaciente) {
        String query = "INSERT INTO datosPaciente (ALERGIAS, MEDICAMENTOS, CIRUGIASPREVIAS, TIPOSANGRE, ENFERMEDADESCRONICAS, IDPACIENTE) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try {


            try {
                if (!openConnection()) {
                    System.out.println("ERROR DE CONEXIÓN");
                    return false;
                }
                PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, datosMedPac.getAlergias());
                ps.setString(2, datosMedPac.getMedicamentos());
                ps.setString(3, datosMedPac.getCirugiasPre());
                ps.setString(4, datosMedPac.getTipoSangre());
                ps.setString(5, datosMedPac.getEnfCronicas());
                ps.setInt(6, idPaciente);


                int res = ps.executeUpdate();
                if (res > 0) {
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()) {
                        datosMedPac.setId(rs.getInt(1));
                    }
                    rs.close();
                }

                ps.close();
                closeConnection();
                return res == 1;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(DatosMedPac datosMedPac) {

        String query = "UPDATE datosPaciente SET ALERGIAS = ?, MEDICAMENTOS = ?, CIRUGIASPREVIAS = ?, TIPOSANGRE = ?, ENFERMEDADESCRONICAS = ? WHERE ID = ?";

        try {
            if (!openConnection()) return false;

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, datosMedPac.getAlergias());
            ps.setString(2, datosMedPac.getMedicamentos());
            ps.setString(3, datosMedPac.getCirugiasPre());
            ps.setString(4, datosMedPac.getTipoSangre());
            ps.setString(5, datosMedPac.getEnfCronicas());
            ps.setInt(6, datosMedPac.getId());

            int res = ps.executeUpdate();
            ps.close();
            closeConnection();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(DatosMedPac datosMedPac) {
        String query = "DELETE FROM datosPaciente WHERE ID = ?";
        try {
            if (!openConnection()) return false;

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, datosMedPac.getId());

            int res = ps.executeUpdate();
            ps.close();
            closeConnection();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public DatosMedPac findById(Integer id) {
        String sql = "SELECT * FROM datosPaciente WHERE ID = ?";
        try {
            if (!openConnection()) return null;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            DatosMedPac datosMedPac = null;
            if (rs.next()) {
                datosMedPac = new DatosMedPac();
                datosMedPac.setId(rs.getInt("ID"));
                datosMedPac.setAlergias(rs.getString("ALERGIAS"));
                datosMedPac.setMedicamentos(rs.getString("MEDICAMENTOS"));
                datosMedPac.setCirugiasPre(rs.getString("CIRUGIASPREVIAS"));
                datosMedPac.setTipoSangre(rs.getString("TIPOSANGRE"));
                datosMedPac.setEnfCronicas(rs.getString("ENFERMEDADESCRONICAS"));
            }

            rs.close();
            ps.close();
            closeConnection();
            return datosMedPac;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
