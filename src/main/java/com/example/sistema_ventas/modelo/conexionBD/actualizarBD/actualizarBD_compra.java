package com.example.sistema_ventas.modelo.conexionBD.actualizarBD;

import com.example.sistema_ventas.modelo.clases.compra;
import com.example.sistema_ventas.modelo.conexionBD.conexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class actualizarBD_compra {

    compra compra;

    public void ActualizarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String InsertQuery = " UPDATE compra  SET fecha = ?, proveedor = ?, total_compra = ? WHERE id_compra = ?";

        try {

            PreparedStatement ps = connectDB.prepareStatement(InsertQuery);
            ps.setString(1, String.valueOf(compra.getFecha()));
            ps.setString(2, compra.getProveedor());
            ps.setDouble(3, compra.getTotal_compra());
            ps.setInt(3, compra.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
