package com.example.sistema_ventas.modelo.conexionBD.guardarBD;
import com.example.sistema_ventas.modelo.clases.empleado;
import com.example.sistema_ventas.modelo.conexionBD.conexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class guardarBD_empleado {

    empleado empleado;

    public void guardarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String InsertQuery = "INSERT into empleado (nombre, apellido, dni) values (?,?,?)";

        try {

            PreparedStatement ps = connectDB.prepareStatement(InsertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setInt(3, empleado.getDni());


            ps.executeUpdate();

            ResultSet resultSet = ps.getGeneratedKeys();

            while (resultSet.next()) {
                empleado.setId(resultSet.getInt(1));
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
