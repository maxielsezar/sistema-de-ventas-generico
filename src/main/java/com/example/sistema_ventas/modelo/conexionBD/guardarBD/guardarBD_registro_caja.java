package com.example.sistema_ventas.modelo.conexionBD.guardarBD;

import com.example.sistema_ventas.modelo.clases.registro_caja;
import com.example.sistema_ventas.modelo.conexionBD.conexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class guardarBD_registro_caja {

    registro_caja registroCaja;

    public guardarBD_registro_caja(registro_caja registro) {
        this.registroCaja=registro;
    }

    public void guardarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String InsertQuery = "INSERT into registro_caja (idregistro_caja, caja, capital) values (?,?,?)";

        try {

            PreparedStatement ps = connectDB.prepareStatement(InsertQuery);
            ps.setInt(1, registroCaja.getId());
            ps.setInt(2, registroCaja.getId_caja());
            ps.setDouble(3, registroCaja.getCapital());
            ps.execute();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



}
