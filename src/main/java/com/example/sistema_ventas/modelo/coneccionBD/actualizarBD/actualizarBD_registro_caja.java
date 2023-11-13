package com.example.sistema_ventas.modelo.coneccionBD.actualizarBD;

import com.example.sistema_ventas.modelo.clases.registro_caja;
import com.example.sistema_ventas.modelo.coneccionBD.conexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class actualizarBD_registro_caja {

    registro_caja registroCaja;

    public void ActualizarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String InsertQuery = " UPDATE registro_caja  SET  capital = ? WHERE idregistro_caja = ?";

        try {

            PreparedStatement ps = connectDB.prepareStatement(InsertQuery);
            ps.setDouble(1, registroCaja.getCapital());
            ps.setInt(2, registroCaja.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }



}
