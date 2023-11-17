package com.example.sistema_ventas.modelo.conexionBD.actualizarBD;

import com.example.sistema_ventas.modelo.conexionBD.conexionBD;
import com.example.sistema_ventas.modelo.clases.venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class actualizarBD_venta {

    venta venta;

    public void ActualizarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String InsertQuery = " UPDATE venta  SET id_empleado = ?, id_caja = ?, tipo_pago = ?,  precio_total = ? WHERE id_venta = ?";

        try {

            PreparedStatement ps = connectDB.prepareStatement(InsertQuery);
            ps.setInt(1, venta.getId_empleado());
            ps.setInt(2, venta.getId_caja());
            ps.setString(3, venta.getTipo_pago());
            ps.setDouble(4, venta.getPrecio_total());
            ps.setInt(5, venta.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
