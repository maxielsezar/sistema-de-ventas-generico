package com.example.sistema_ventas.modelo.coneccionBD.seleccionarBD;

import com.example.sistema_ventas.modelo.clases.cant_stock;
import com.example.sistema_ventas.modelo.coneccionBD.conexionBD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class seleccionarBD_cant_stock {

    conexionBD connectionnow = new conexionBD();
    Connection connectDB = connectionnow.getConnection();
    ObservableList<cant_stock> lista = FXCollections.observableArrayList();

    public ObservableList seleccionarBD() {

        String ViewQuery = "SELECT id_cantidad_stock, id_producto,cantidad FROM cantidad_stock";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(ViewQuery);

            while (queryOutput.next()) {

                int queryid_cantidad = queryOutput.getInt("id_cantidad_stock");
                int queryid_producto = queryOutput.getInt("id_producto");
                int querycantidad = queryOutput.getInt("cantidad");


                lista.add(new cant_stock(queryid_cantidad,queryid_producto,querycantidad));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }


}
