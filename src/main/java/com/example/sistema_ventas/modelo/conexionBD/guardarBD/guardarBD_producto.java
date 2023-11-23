package com.example.sistema_ventas.modelo.conexionBD.guardarBD;
import com.example.sistema_ventas.modelo.clases.producto;
import com.example.sistema_ventas.modelo.conexionBD.conexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class guardarBD_producto {

    public static void guardarBD(producto producto) {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String InsertQuery = "INSERT into producto (nombre, precio, marca, unidad_medida, cantidad) values (?,?,?,?,?)";

        try {

            PreparedStatement ps = connectDB.prepareStatement(InsertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getPrecio());
            ps.setString(3, producto.getMarca());
            ps.setString(4, producto.getUnidad_medida());
            ps.setDouble(5, producto.getCantidad());

            ps.executeUpdate();

            ResultSet resultSet = ps.getGeneratedKeys();

            while (resultSet.next()) {
                producto.setId_producto(resultSet.getInt(1));
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
