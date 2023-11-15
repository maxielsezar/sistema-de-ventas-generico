package com.example.sistema_ventas.controlers;

import com.example.sistema_ventas.modelo.clases.producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

public class AgregarProductoControler {

    @FXML
    public TextField nombre,marca,precioUnidad;

    int id = 0;

    ObservableList<producto> listaDeProducto = FXCollections.observableArrayList();

    public void guardar(){




    }

}
