package com.example.sistema_ventas.modelo.conexionBD.actualizarBD;

import com.example.sistema_ventas.modelo.conexionBD.conexionBD;
import com.example.sistema_ventas.modelo.clases.producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class actualizarBD_producto {


    public static void ActualizarBD(producto producto) {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String InsertQuery = " UPDATE producto  SET nombre = ?, precio = ?, marca = ?, unidad_medida = ? WHERE id_producto = ?";

        try {

            PreparedStatement ps = connectDB.prepareStatement(InsertQuery);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getMarca());
            ps.setInt(3, producto.getPrecio());
            ps.setInt(3, producto.getId_producto());
            ps.setString(4, producto.getUnidad_medida());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
