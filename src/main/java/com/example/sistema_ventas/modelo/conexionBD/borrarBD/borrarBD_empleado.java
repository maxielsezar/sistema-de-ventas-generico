package com.example.sistema_ventas.modelo.conexionBD.borrarBD;
import com.example.sistema_ventas.modelo.clases.empleado;
import com.example.sistema_ventas.modelo.conexionBD.conexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class borrarBD_empleado {

    empleado empleado;

    public void borrarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String borrarQuery = "DELETE from empleado where id_empleado = ?";

        try {

            PreparedStatement preparedStatement = connectDB.prepareStatement(borrarQuery);
            preparedStatement.setInt(1, empleado.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
