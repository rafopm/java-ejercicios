package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        //Connection co= DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
    listarRegistros();
    //insertarRegistros(4, "Hola desde Java 3", "Katty");
       // editarRegistros("Hola desde Java", "Mechita", 4);
        eliminarRegistros(4);
        listarRegistros();
    }

    static void listarRegistros() throws SQLException {
        Connection conectar = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mensajes_db?serverTimezone=UTC",
                "root",
                "123456"
        );
        System.out.println("Conexion exitosa");

        String sql = "select * from mensajes";

        PreparedStatement ps = conectar.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            int id = rs.getInt("id_mensaje");
            String mensaje = rs.getString("mensaje");
            String autor = rs.getString("autor");
            String fecha = rs.getString("fecha");

            System.out.printf("%d %s %s %s\n", id, mensaje, autor, fecha);
        }

        rs.close();
        ps.close();
        conectar.close();
    }
    static void insertarRegistros( int id_mensaje , String mensaje, String autor ) throws SQLException {
        Connection conectar = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mensajes_db?serverTimezone=UTC",
                "root",
                "123456"
        );
        System.out.println("Conexion exitosa");

        String sql = "INSERT INTO mensajes(id_mensaje, mensaje, autor, fecha) VALUES(?, ?,?, CURRENT_DATE())";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setInt(1, id_mensaje);
        ps.setString(2, mensaje);
        ps.setString(3, autor);
        ps.executeUpdate();

        ps.close();
        conectar.close();
    }
    static void editarRegistros(String mensaje, String autor, int id_mensaje) throws SQLException {
        Connection conectar = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mensajes_db?serverTimezone=UTC",
                "root",
                "123456"
        );
        //System.out.println("Conexion exitosa");

        String sql = "UPDATE mensajes SET mensaje=?, autor= ? WHERE id_mensaje=?";
        PreparedStatement ps = conectar.prepareStatement(sql);

        ps.setString(1, mensaje);
        ps.setString(2, autor);
        ps.setInt(3, id_mensaje);
        ps.executeUpdate();

        ps.close();
        conectar.close();
    }

    static void eliminarRegistros(int id_mensaje) throws SQLException {
        Connection conectar = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mensajes_db?serverTimezone=UTC",
                "root",
                "123456"
        );
        //System.out.println("Conexion exitosa");

        String sql = "DELETE FROM mensajes WHERE id_mensaje=?";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setInt(1, id_mensaje);
        ps.executeUpdate();

        ps.close();
        conectar.close();
    }
}