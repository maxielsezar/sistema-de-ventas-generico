package com.example.sistema_ventas.modelo.conexionBD.seleccionarBD;

import com.example.sistema_ventas.modelo.clases.venta;
import com.example.sistema_ventas.modelo.conexionBD.conexionBD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class seleccionarBD_venta {

    conexionBD connectionnow = new conexionBD();
    Connection connectDB = connectionnow.getConnection();
    ObservableList<venta> lista = FXCollections.observableArrayList();

    public  ObservableList<venta> getLista() {
        seleccionarBD();
        return lista;
    }

    public void setLista(ObservableList<venta> lista) {
        this.lista = lista;
    }

    public void seleccionarBD() {

        String ViewQuery = "SELECT id_venta,id_empleado,id_caja,tipo_pago,fecha,precio_total FROM venta;";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(ViewQuery);

            while (queryOutput.next()) {

                int queryid = queryOutput.getInt("id_venta");
                int queryid_empleado= queryOutput.getInt("id_empleado");
                int queryid_caja = queryOutput.getInt("id_caja");
                String querytipoPago= queryOutput.getString("tipo_pago");
                Date queryfecha = queryOutput.getDate("fecha");
                Double queryPrecio= queryOutput.getDouble("precio_total");

                lista.add(new venta(queryid, queryid_empleado, queryid_caja,querytipoPago,queryPrecio));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
