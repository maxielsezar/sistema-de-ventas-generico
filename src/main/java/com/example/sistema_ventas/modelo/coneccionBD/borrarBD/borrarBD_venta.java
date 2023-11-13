package com.example.sistema_ventas.modelo.coneccionBD.borrarBD;
import com.example.sistema_ventas.modelo.clases.venta;
import com.example.sistema_ventas.modelo.coneccionBD.conexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class borrarBD_venta {

    venta venta;

    public void borrarBD() {

        conexionBD connectionnow = new conexionBD();//nueva coneccion a bace de datos
        Connection connectDB = connectionnow.getConnection();

        String borrarQuery = "DELETE from venta where id_venta = ?";

        try {

            PreparedStatement preparedStatement = connectDB.prepareStatement(borrarQuery);
            preparedStatement.setInt(1, venta.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
