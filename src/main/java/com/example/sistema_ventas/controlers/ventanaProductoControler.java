package com.example.sistema_ventas.controlers;
import com.example.sistema_ventas.modelo.coneccionBD.seleccionarBD.seleccionarBD_productoStock;
import com.example.sistema_ventas.modelo.clases.cant_stock;
import com.example.sistema_ventas.modelo.clases.producto;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ventanaProductoControler implements Initializable {

    @FXML
    public TableView<producto> tabla_productos;
    public TableColumn<producto, Integer> columna_codigo;
    public TableColumn<producto, String> columna_nombre;
    public TableColumn<producto, String> columna_marca;
    public TableColumn<producto, Integer> columna_precio_unidad;
    public TableColumn<producto, Integer> columna_stock;

    ObservableList<producto> listaproducto = seleccionarBD_productoStock.getLista()  ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        columna_codigo.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
        columna_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columna_marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        columna_precio_unidad.setCellValueFactory(new PropertyValueFactory<>("precio_x_unidad"));
        columna_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tabla_productos.setItems(listaproducto);

    }
}
