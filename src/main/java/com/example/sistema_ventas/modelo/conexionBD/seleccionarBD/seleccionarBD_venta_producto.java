package com.example.sistema_ventas.modelo.conexionBD.seleccionarBD;

import com.example.sistema_ventas.modelo.clases.venta_producto;
import com.example.sistema_ventas.modelo.conexionBD.conexionBD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public  class seleccionarBD_venta_producto {

    conexionBD connectionnow = new conexionBD();
    Connection connectDB = connectionnow.getConnection();
    ObservableList<venta_producto> lista = FXCollections.observableArrayList();

    public  void seleccionarBD() {

        String ViewQuery = "SELECT id_venta_producto,id_venta,id_producto,cant_venta FROM venta_producto";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(ViewQuery);

            while (queryOutput.next()) {

                int queryid_venta_producto = queryOutput.getInt("id_venta_producto");
                int queryid_venta= queryOutput.getInt("id_venta");
                Double queryid_producto = queryOutput.getDouble("id_producto");
                int querycant_venta= queryOutput.getInt("cant_venta");

                lista.add(new venta_producto(queryid_venta_producto, queryid_venta, queryid_producto,querycant_venta));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
