package com.example.javaweb;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Conexion.getConexion();
        //System.out.println("Conexión exitosa");
        MensajeDao mensajeDao = new MensajeDao();

        Mensaje msm = new Mensaje("Hola desde Main", "Main");
        int registro = mensajeDao.inserta(msm);
        System.out.println("Se inserto " + registro+" registro");

        List<Mensaje> mensajes = mensajeDao.seleccionar();

        for (Mensaje mensaje: mensajes){
            System.out.println(mensaje);
        }
    }

}
