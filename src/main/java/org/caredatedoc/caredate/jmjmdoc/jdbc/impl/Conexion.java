package org.caredatedoc.caredate.jmjmdoc.jdbc.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Conexion<T> {

    public static String user = "root";
    public static String password = "n0m3l0";
    public static String db = "pro_cd";
    public static String server = "localhost";  // O "localhost"
    protected Connection connection;

    public Conexion() {}

    public boolean testDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private boolean loadConnection() {
        String url = "jdbc:mysql://" + server + ":3306/" + db + "?useSSL=false&serverTimezone=UTC";
        try {
            System.out.println(url);
            if (!testDriver()) return false;
            connection = DriverManager.getConnection(url, user, password);
            return connection != null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean openConnection() {
        try {
            if (connection != null && !connection.isClosed()) return true;
            return loadConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}