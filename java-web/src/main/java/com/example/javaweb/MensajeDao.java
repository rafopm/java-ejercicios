package com.example.javaweb;

import static com.example.javaweb.Conexion.*;

import java.sql.*;
import java.util.*;

public class MensajeDao {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Mensaje mensaje;

    public List<Mensaje> seleccionar() throws ClassNotFoundException {
        String sql = "SELECT * FROM mensajes";
        List<Mensaje> mensajes = new ArrayList<>();

        try {
            this.conn = getConexion();
            this.ps = this.conn.prepareStatement(sql);
            this.rs = this.ps.executeQuery();

            while (this.rs.next()) {
                int id = this.rs.getInt("id_mensaje");
                String msm = this.rs.getString("mensaje");
                String autor = this.rs.getString("autor");
                String fechar = this.rs.getString("fecha");

                this.mensaje = new Mensaje(id, msm, autor, fechar);
                mensajes.add(this.mensaje);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                cerrar(this.rs);
                cerrar(this.ps);
                cerrar(this.conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return mensajes;
    }

    public int inserta(Mensaje mensaje) throws ClassNotFoundException {
        String sql = "INSERT INTO mensajes(mensaje, autor, fecha) VALUES( ?,?, CURRENT_TIME())";
        int registros = 0;
        try {
            this.conn = getConexion();
            this.ps = this.conn.prepareStatement(sql);

            this.ps.setString(1, mensaje.getMensaje());
            this.ps.setString(2, mensaje.getAutor());
            registros = this.ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                cerrar(this.ps);
                cerrar(this.conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int editar(Mensaje mensaje) throws ClassNotFoundException {
        String sql = "UPDATE mensajes SET mensaje=?, autor= ? WHERE id_mensaje=?";
        int registros = 0;
        try {
            this.conn = getConexion();
            this.ps = this.conn.prepareStatement(sql);

            this.ps.setString(1, mensaje.getMensaje());
            this.ps.setString(2, mensaje.getAutor());
            this.ps.setInt(3, mensaje.getId());
            registros = this.ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                cerrar(this.ps);
                cerrar(this.conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int eliminar(Mensaje mensaje) throws ClassNotFoundException {
        String sql = "DELETE FROM mensajes WHERE id_mensaje=?";
        int registros = 0;
        try {
            this.conn = getConexion();
            this.ps = this.conn.prepareStatement(sql);

            this.ps.setInt(1, mensaje.getId());
            registros = this.ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                cerrar(this.ps);
                cerrar(this.conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
