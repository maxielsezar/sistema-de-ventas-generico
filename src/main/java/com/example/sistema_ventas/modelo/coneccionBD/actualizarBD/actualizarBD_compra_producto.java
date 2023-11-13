package com.example.sistema_ventas.modelo.coneccionBD.actualizarBD;

import com.example.sistema_ventas.modelo.coneccionBD.conexionBD;
import com.example.sistema_ventas.modelo.clases.compra_producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class actualizarBD_compra_producto {

    compra_producto compra_producto;

    public void ActualizarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String InsertQuery = " UPDATE compra_producto  SET id_compra = ?, id_producto = ?, cant_producto = ? WHERE id_compra_producto = ?";

        try {

            PreparedStatement ps = connectDB.prepareStatement(InsertQuery);
            ps.setInt(1, compra_producto.getId_compra());
            ps.setInt(2, compra_producto.getId_producto());
            ps.setInt(3, compra_producto.getCant_producto());
            ps.setInt(3, compra_producto.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
