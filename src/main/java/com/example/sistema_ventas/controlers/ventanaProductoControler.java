package com.example.sistema_ventas.controlers;
import com.example.sistema_ventas.aplicacion;
import com.example.sistema_ventas.modelo.clases.producto_tabla_stock;
import com.example.sistema_ventas.modelo.conexionBD.seleccionarBD.seleccionarBD_producto;
import com.example.sistema_ventas.modelo.conexionBD.seleccionarBD.seleccionarBD_productoStock;
import com.example.sistema_ventas.modelo.clases.producto;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
    public TableView<producto_tabla_stock> tabla_productos;
    public TableColumn<producto_tabla_stock, Integer> columna_codigo, columna_precio;
    public TableColumn<producto_tabla_stock, Double> columna_stock;
    public TableColumn<producto_tabla_stock, String>  columna_nombre, columna_marca, columna_unidad;
    public Button nuevo_producto;
    public Button modificar_producto;
    public Button borrar_producto;


    ObservableList<producto_tabla_stock> listaproductoStock = seleccionarBD_productoStock.seleccionarBD();

    ObservableList<producto> listaproducto = seleccionarBD_producto.seleccionarBD();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        columna_codigo.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
        columna_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columna_marca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        columna_precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        columna_unidad.setCellValueFactory(new PropertyValueFactory<>("unidad_medida"));
        columna_stock.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        tabla_productos.setItems(listaproductoStock);
    }

    public void agregarProducto() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(aplicacion.class.getResource("agregar_producto.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("agregar");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);

        AgregarProductoControler controlador = fxmlLoader.getController();

        stage.showAndWait();

        if (controlador.obtenerNuevo() != null) {
            listaproducto.add(controlador.obtenerNuevo());
        }

        tabla_productos.setItems(listaproductoStock);
        tabla_productos.refresh();
    }

    public void actualizar () throws IOException {

        producto productoActual =  tabla_productos.getSelectionModel().getSelectedItem();

        if (productoActual == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("error");
            alert.setHeaderText("seleccione un producto");
            alert.show();

        } else {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(aplicacion.class.getResource("agregar_producto.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Actualizar");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);

            AgregarProductoControler controlador = fxmlLoader.getController();
            controlador.parametros(productoActual);

            stage.showAndWait();

            tabla_productos.refresh();
        }
    }
}
