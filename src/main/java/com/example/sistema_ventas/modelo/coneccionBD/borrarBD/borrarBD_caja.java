package com.example.sistema_ventas.modelo.coneccionBD.borrarBD;
import com.example.sistema_ventas.modelo.clases.caja;
import com.example.sistema_ventas.modelo.coneccionBD.conexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class borrarBD_caja {

    caja caja;

    public void borrarBD() {

        conexionBD connectionnow = new conexionBD();//nueva coneccion a bace de datos
        Connection connectDB = connectionnow.getConnection();

        String borrarQuery = "DELETE from caja where id_caja = ?";

        try {

            PreparedStatement preparedStatement = connectDB.prepareStatement(borrarQuery);
            preparedStatement.setInt(1, caja.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
