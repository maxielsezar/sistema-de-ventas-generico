package com.example.sistema_ventas.modelo.conexionBD.seleccionarBD;

import com.example.sistema_ventas.modelo.conexionBD.conexionBD;

import java.sql.*;

public class seleccionarBD_registro_caja {



     static public double seleccionarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String ViewQuery = "SELECT capital from registro_caja where fecha = (SELECT max(fecha) FROM sistema_ventas.registro_caja);" ;

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(ViewQuery);

           queryOutput.next();
            return queryOutput.getDouble(1);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }






}
