package com.example.sistema_ventas.modelo.conexionBD.seleccionarBD;

import com.example.sistema_ventas.modelo.clases.producto;
import com.example.sistema_ventas.modelo.clases.producto_tabla_venta;
import com.example.sistema_ventas.modelo.conexionBD.conexionBD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class seleccionarBD_producto {

    static ObservableList<producto_tabla_venta> listaVenta = FXCollections.observableArrayList();

    public static ObservableList<producto_tabla_venta> getListaVenta() {
        seleccionarBD();
        return listaVenta;
    }

    public static void setListaVenta(ObservableList<producto_tabla_venta> listaVenta) {
        seleccionarBD_producto.listaVenta = listaVenta;
    }



    public static ObservableList<producto> seleccionarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();
        ObservableList<producto> lista = FXCollections.observableArrayList();
        String ViewQuery = "SELECT id_producto,nombre,precio,marca,unidad_medida,cantidad FROM producto" ;

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(ViewQuery);

            while (queryOutput.next()) {

                int queryid_producto = queryOutput.getInt("id_producto");
                String querynombre = queryOutput.getString("nombre");
                int queryprecio = queryOutput.getInt("precio");
                String querymarca = queryOutput.getString("marca");
                String queryunidad_medida = queryOutput.getString("unidad_medida");

                Double querycantidad = queryOutput.getDouble("cantidad");

                lista.add(new producto(queryid_producto, querynombre, queryprecio, querymarca,queryunidad_medida, querycantidad));
                listaVenta.add(new producto_tabla_venta(queryid_producto, querynombre, queryprecio, querymarca,queryunidad_medida, querycantidad));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
