package com.example.sistema_ventas.modelo.conexionBD.seleccionarBD;

import com.example.sistema_ventas.modelo.clases.compra;
import com.example.sistema_ventas.modelo.conexionBD.conexionBD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class seleccionarBD_compra {

    conexionBD connectionnow = new conexionBD();
    Connection connectDB = connectionnow.getConnection();
    ObservableList<compra> lista = FXCollections.observableArrayList();

    public void seleccionarBD() {

        String ViewQuery = "SELECT id_compra, fecha, proveedor, total_compra FROM compra " ;

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(ViewQuery);

            while (queryOutput.next()) {

                int queryid_compra = queryOutput.getInt("id_compra");
                Date queryfecha = queryOutput.getDate("fecha");
                String queryproveedor = queryOutput.getString("proveedor");
                Double querytotal = queryOutput.getDouble("total_compra");

                lista.add(new compra(queryid_compra, queryfecha, queryproveedor, querytotal));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
