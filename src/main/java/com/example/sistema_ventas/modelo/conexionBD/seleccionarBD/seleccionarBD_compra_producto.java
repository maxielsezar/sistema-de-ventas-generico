package com.example.sistema_ventas.modelo.conexionBD.seleccionarBD;

import com.example.sistema_ventas.modelo.clases.compra_producto;
import com.example.sistema_ventas.modelo.conexionBD.conexionBD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class seleccionarBD_compra_producto {

    conexionBD connectionnow = new conexionBD();
    Connection connectDB = connectionnow.getConnection();
    ObservableList<compra_producto> lista = FXCollections.observableArrayList();

    public void seleccionarBD() {

        String ViewQuery = "SELECT id_compra_producto, id_compra,id_producto,cant_producto FROM compra_producto;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(ViewQuery);

            while (queryOutput.next()) {

                int queryid = queryOutput.getInt("id_compra_producto");
                int queryid_compra= queryOutput.getInt("id_compra");
                int queryid_producto = queryOutput.getInt("id_producto");
                int querycantidad= queryOutput.getInt("cant_producto");



                lista.add(new compra_producto(queryid, queryid_compra, queryid_producto,querycantidad));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



}
