package com.example.sistema_ventas.modelo.conexionBD.actualizarBD;

import com.example.sistema_ventas.modelo.conexionBD.conexionBD;
import com.example.sistema_ventas.modelo.clases.empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class actualizarBD_empleado {


    empleado empleado;
    public void ActualizarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String InsertQuery = " UPDATE empleado  SET nombre = ?, apellido = ?, dni = ? WHERE id_empleado = ?";

        try {

            PreparedStatement ps = connectDB.prepareStatement(InsertQuery);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setInt(3, empleado.getDni());
            ps.setInt(3, empleado.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
