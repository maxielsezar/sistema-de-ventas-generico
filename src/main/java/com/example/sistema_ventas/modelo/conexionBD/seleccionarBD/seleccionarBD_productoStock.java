package com.example.sistema_ventas.modelo.conexionBD.seleccionarBD;

import com.example.sistema_ventas.modelo.clases.producto;
import com.example.sistema_ventas.modelo.clases.producto_tabla_stock;
import com.example.sistema_ventas.modelo.clases.producto_tabla_venta;
import com.example.sistema_ventas.modelo.conexionBD.conexionBD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class seleccionarBD_productoStock {

    static ObservableList<producto> lista = FXCollections.observableArrayList();

    static ObservableList<producto_tabla_stock> listaVenta = FXCollections.observableArrayList();

    public static ObservableList<producto> getLista() {
        seleccionarBD();
        return lista;
    }

    public static ObservableList<producto_tabla_stock> seleccionarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String ViewQuery = "SELECT id_producto,nombre,precio,marca,unidad_medida,producto.cantidad FROM producto;" ;

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(ViewQuery);

            while (queryOutput.next()) {

                int queryid_producto = queryOutput.getInt("id_producto");
                String querynombre = queryOutput.getString("nombre");
                int queryprecio = queryOutput.getInt("precio");
                String querymarca = queryOutput.getString("marca");
                String queryunidadmedida = queryOutput.getString("unidad_medida");
                double querycantidad = queryOutput.getInt("cantidad");

                listaVenta.add(new producto_tabla_stock(queryid_producto, querynombre, queryprecio, querymarca,queryunidadmedida,querycantidad));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaVenta;
    }
}
