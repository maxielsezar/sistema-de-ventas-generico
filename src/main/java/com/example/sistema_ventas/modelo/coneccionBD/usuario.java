package com.example.sistema_ventas.modelo.coneccionBD;

import java.sql.*;

public class usuario {

    public static int validarUsuario(String usuario, String pass) {
        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String usuarioQuery = "SELECT count(nombre) as cantidad FROM sistema_ventas.empleado where nombre_usuario = ? and contraseña = ?;";

        try {
            PreparedStatement ps = connectDB.prepareStatement(usuarioQuery);
            ps.setString(1, usuario);
            ps.setString(2, pass);

            ResultSet queryOutput = ps.executeQuery();
            queryOutput.next();
            return queryOutput.getInt("cantidad");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
