package com.example.sistema_ventas.modelo.conexionBD.borrarBD;
import com.example.sistema_ventas.modelo.clases.compra;
import com.example.sistema_ventas.modelo.conexionBD.conexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class borrarBD_compra {

    compra compra;
    public void borrarBD() {

        conexionBD connectionnow = new conexionBD();//nueva coneccion a bace de datos
        Connection connectDB = connectionnow.getConnection();

        String borrarQuery = "DELETE from compra where id_compra = ?";

        try {

            PreparedStatement preparedStatement = connectDB.prepareStatement(borrarQuery);
            preparedStatement.setInt(1, compra.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
