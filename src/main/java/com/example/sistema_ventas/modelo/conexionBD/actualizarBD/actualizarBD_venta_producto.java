package com.example.sistema_ventas.modelo.conexionBD.actualizarBD;

import com.example.sistema_ventas.modelo.conexionBD.conexionBD;
import com.example.sistema_ventas.modelo.clases.venta_producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class actualizarBD_venta_producto {

    venta_producto venta_producto;

    public void ActualizarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String InsertQuery = " UPDATE venta_producto  SET id_venta = ?, id_producto = ?, cant_venta = ? WHERE id_venta_producto = ?";

        try {

            PreparedStatement ps = connectDB.prepareStatement(InsertQuery);
            ps.setInt(1, venta_producto.getId_venta());
            ps.setInt(2, venta_producto.getId_producto());
            ps.setInt(3, venta_producto.getCant_venta());
            ps.setInt(4, venta_producto.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
