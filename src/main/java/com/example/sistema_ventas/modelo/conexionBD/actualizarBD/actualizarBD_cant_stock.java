package com.example.sistema_ventas.modelo.conexionBD.actualizarBD;

import com.example.sistema_ventas.modelo.conexionBD.conexionBD;
import com.example.sistema_ventas.modelo.clases.cant_stock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class actualizarBD_cant_stock {

    cant_stock cant_stock;

    public actualizarBD_cant_stock(com.example.sistema_ventas.modelo.clases.cant_stock cant_stock) {
        this.cant_stock = cant_stock;
    }

    public com.example.sistema_ventas.modelo.clases.cant_stock getCant_stock() {
        return cant_stock;
    }

    public void setCant_stock(com.example.sistema_ventas.modelo.clases.cant_stock cant_stock) {
        this.cant_stock = cant_stock;
    }

    public void ActualizarBD() {

        conexionBD connectionnow = new conexionBD();//nueva coneccion a bace de datos
        Connection connectDB = connectionnow.getConnection();

        String InsertQuery = " UPDATE cantidad_stock  SET cantidad = ? WHERE id_producto = ?";

        try {

            PreparedStatement ps = connectDB.prepareStatement(InsertQuery);
            ps.setDouble(1, cant_stock.getCantidad());
            ps.setInt(2, cant_stock.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
