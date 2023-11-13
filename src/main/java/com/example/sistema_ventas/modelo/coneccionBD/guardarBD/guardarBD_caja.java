package com.example.sistema_ventas.modelo.coneccionBD.guardarBD;
import com.example.sistema_ventas.modelo.clases.caja;
import com.example.sistema_ventas.modelo.coneccionBD.conexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class guardarBD_caja {

    caja caja;

    public void guardarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String InsertQuery = "INSERT into caja (fecha, capital) values (?,?)";

        try {

            PreparedStatement ps = connectDB.prepareStatement(InsertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, String.valueOf(caja.getFecha()));
            ps.setDouble(2, caja.getCapital_inicial());



            ps.executeUpdate();

            ResultSet resultSet = ps.getGeneratedKeys();

            while (resultSet.next()) {
                caja.setId(resultSet.getInt(1));
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
