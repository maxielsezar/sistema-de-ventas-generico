package com.example.sistema_ventas.modelo.conexionBD.seleccionarBD;

import com.example.sistema_ventas.modelo.clases.empleado;
import com.example.sistema_ventas.modelo.conexionBD.conexionBD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class seleccionarBD_empleado {


    static ObservableList<empleado> lista = FXCollections.observableArrayList();


    public static ObservableList<empleado> getLista() {
        seleccionarBD();
        return lista;
    }

    public void setLista(ObservableList<empleado> lista) {
        this.lista = lista;
    }

    public static void seleccionarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String ViewQuery = "SELECT id_empleado,nombre,apellido,dni FROM empleado " ;

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(ViewQuery);

            while (queryOutput.next()) {

                int queryid_empleado = queryOutput.getInt("id_empleado");
                String querynombre = queryOutput.getString("nombre");
                String queryapellido = queryOutput.getString("apellido");
                int querydni = queryOutput.getInt("dni");

                lista.add(new empleado(queryid_empleado, querynombre, queryapellido, querydni));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
