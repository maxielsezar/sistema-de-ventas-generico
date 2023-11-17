package com.example.sistema_ventas.modelo.conexionBD.seleccionarBD;

import com.example.sistema_ventas.modelo.clases.caja;
import com.example.sistema_ventas.modelo.conexionBD.conexionBD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class seleccionarBD_caja {



    static ObservableList<caja> lista = FXCollections.observableArrayList();

    public static ObservableList<caja> getLista() {
        seleccionarBD();
        return lista;
    }

    public void setLista(ObservableList<caja> lista) {
        this.lista = lista;
    }

    public static void seleccionarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String ViewQuery = "SELECT id_caja, fecha, capital FROM caja " ;

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(ViewQuery);

            while (queryOutput.next()) {

                int queryid_caja = queryOutput.getInt("id_caja");
                Date queryfecha = queryOutput.getDate("fecha");
                Double queryinicial = queryOutput.getDouble("capital");

                lista.add(new caja(queryid_caja, queryfecha, queryinicial));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
