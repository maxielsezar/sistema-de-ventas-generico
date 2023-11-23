package com.example.sistema_ventas.modelo.conexionBD.seleccionarBD;

import com.example.sistema_ventas.modelo.conexionBD.conexionBD;

import java.sql.*;

public class seleccionarBD_cant_stock_id {

   static public double cantidad(int idProducto) {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String ViewQuery = "SELECT cantidad FROM cantidad_stock where producto=?";

        try {
            PreparedStatement ps = connectDB.prepareStatement(ViewQuery);
            ps.setInt(1, idProducto);
            ResultSet queryOutput = ps.executeQuery();
            queryOutput.next();
            return queryOutput.getDouble("cantidad");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
