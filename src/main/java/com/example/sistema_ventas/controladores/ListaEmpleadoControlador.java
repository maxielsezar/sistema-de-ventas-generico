package com.example.sistema_ventas.controladores;

import com.example.sistema_ventas.modelo.clases.empleado;
import com.example.sistema_ventas.modelo.conexionBD.seleccionarBD.seleccionarBD_empleado;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ListaEmpleadoControlador implements Initializable {
    @FXML private TableView<empleado> tabla;
    @FXML private TableColumn<empleado, String> t_nombre, t_apellido;
    @FXML private TableColumn<empleado, Integer> t_dni, t_telefono;
    ObservableList<empleado> datos;
    private seleccionarBD_empleado ode;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        t_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        t_apellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        t_telefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        t_dni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        tabla.setItems(datos);
    }


}
