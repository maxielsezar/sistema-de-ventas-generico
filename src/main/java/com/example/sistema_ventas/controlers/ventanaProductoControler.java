package com.example.sistema_ventas.controlers;
import com.example.sistema_ventas.modelo.conexionBD.seleccionarBD.seleccionarBD_productoStock;
import com.example.sistema_ventas.modelo.clases.producto;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ventanaProductoControler implements Initializable {

    @FXML
    public TableView<producto> tabla_productos;
    public TableColumn<producto, Integer> columna_codigo, columna_precio, columna_stock;
    public TableColumn<producto, String>  columna_nombre, columna_marca, columna_unidad;

    ObservableList<producto> listaproducto = seleccionarBD_productoStock.getLista()  ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        columna_codigo.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
        columna_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columna_marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        columna_precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        columna_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        columna_unidad.setCellValueFactory(new PropertyValueFactory<>("unidad_medida"));

        tabla_productos.setItems(listaproducto);
    }

    public void agregar() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("agregar_producto.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("agregar");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }


}
