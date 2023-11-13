package com.example.sistema_ventas.modelo.coneccionBD.seleccionarBD;

import com.example.sistema_ventas.modelo.coneccionBD.conexionBD;

import java.sql.*;

public class seleccionarBD_cant_stock_id {



   static public int cantidad(int idProducto) {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String ViewQuery = "SELECT cantidad FROM cantidad_stock where id_producto=?";

        try {

            PreparedStatement ps = connectDB.prepareStatement(ViewQuery);
            ps.setInt(1, idProducto);
            ResultSet queryOutput = ps.executeQuery();
            queryOutput.next();
            return queryOutput.getInt("cantidad");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
