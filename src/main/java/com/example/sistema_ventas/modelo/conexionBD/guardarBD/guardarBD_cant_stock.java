package com.example.sistema_ventas.modelo.conexionBD.guardarBD;
import com.example.sistema_ventas.modelo.clases.cant_stock;
import com.example.sistema_ventas.modelo.conexionBD.conexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class guardarBD_cant_stock {

    cant_stock cant_stock;

    public void guardarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();



        String InsertQuery = "INSERT into cantidad_stock (id_producto, cantidad) values (?,?)";

        try {

            PreparedStatement ps = connectDB.prepareStatement(InsertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cant_stock.getId_producto());
            ps.setInt(2, cant_stock.getCantidad());

            ps.executeUpdate();

            ResultSet resultSet = ps.getGeneratedKeys();

            while (resultSet.next()) {
                cant_stock.setId_producto(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}
