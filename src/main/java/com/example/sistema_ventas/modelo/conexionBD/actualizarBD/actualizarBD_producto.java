package com.example.sistema_ventas.modelo.conexionBD.actualizarBD;

import com.example.sistema_ventas.modelo.conexionBD.conexionBD;
import com.example.sistema_ventas.modelo.clases.producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class actualizarBD_producto {

    producto producto;

    public void ActualizarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String InsertQuery = " UPDATE producto  SET nombre = ?, precio_x_unidad = ?, marca = ? WHERE id_producto = ?";

        try {

            PreparedStatement ps = connectDB.prepareStatement(InsertQuery);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getMarca());
            ps.setInt(3, producto.getPrecio_x_unidad());
            ps.setInt(3, producto.getId_producto());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
