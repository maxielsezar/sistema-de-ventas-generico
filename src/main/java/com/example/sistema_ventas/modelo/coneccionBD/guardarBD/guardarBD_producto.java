package com.example.sistema_ventas.modelo.coneccionBD.guardarBD;
import com.example.sistema_ventas.modelo.clases.producto;
import com.example.sistema_ventas.modelo.coneccionBD.conexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class guardarBD_producto {

    producto producto;

    public void guardarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String InsertQuery = "INSERT into producto (nombre, precio_x_unidad, marca) values (?,?,?)";

        try {

            PreparedStatement ps = connectDB.prepareStatement(InsertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getPrecio_x_unidad());
            ps.setString(3, producto.getMarca());

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
