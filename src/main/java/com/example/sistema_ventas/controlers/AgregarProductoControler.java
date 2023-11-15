package com.example.sistema_ventas.controlers;

import com.example.sistema_ventas.modelo.clases.producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AgregarProductoControler {

    @FXML
    public TextField nombre,marca,precioUnidad;
    public Button agregar;


    int id = 0;

    producto Producto;

    ObservableList<producto> listaDeProducto = FXCollections.observableArrayList();

    public  void parametros (producto productoActual){

        Producto = productoActual;
        nombre.setText(productoActual.getNombre());
        marca.setText(productoActual.getMarca());
        precioUnidad.setText(String.valueOf(productoActual.getPrecio_x_unidad()));
        agregar.setText("actualizar");
        this.id = productoActual.getId_producto();
    }

    public void guardar(){




    }

}
