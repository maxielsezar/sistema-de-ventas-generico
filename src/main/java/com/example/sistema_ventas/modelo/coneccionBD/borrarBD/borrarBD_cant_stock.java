package com.example.sistema_ventas.modelo.coneccionBD.borrarBD;
import com.example.sistema_ventas.modelo.clases.cant_stock;
import com.example.sistema_ventas.modelo.coneccionBD.conexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class borrarBD_cant_stock {

    cant_stock cant_stock;

    public void borrarBD() {

        conexionBD connectionnow = new conexionBD();//nueva coneccion a bace de datos
        Connection connectDB = connectionnow.getConnection();

        String borrarQuery = "DELETE from cantidad_stock where id_cantidad_stock = ?";

        try {


            PreparedStatement preparedStatement = connectDB.prepareStatement(borrarQuery);
            preparedStatement.setInt(1, cant_stock.getId_producto());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
