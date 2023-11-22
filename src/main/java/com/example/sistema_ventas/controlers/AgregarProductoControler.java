package com.example.sistema_ventas.controlers;

import com.example.sistema_ventas.modelo.clases.producto;
import com.example.sistema_ventas.modelo.conexionBD.guardarBD.guardarBD_producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.example.sistema_ventas.modelo.conexionBD.seleccionarBD.seleccionarBD_producto;
import com.example.sistema_ventas.modelo.conexionBD.actualizarBD.actualizarBD_producto;
import javafx.stage.Stage;

public class AgregarProductoControler {

    @FXML
    public TextField nombre,marca, precio,unidad_medida;
    public Button agregar;


    int id = 0;

    producto Producto;

    ObservableList<producto> listaDeProducto = FXCollections.observableArrayList();

    public  void parametros (producto productoActual){

        Producto = productoActual;
        nombre.setText(productoActual.getNombre());
        marca.setText(productoActual.getMarca());
        precio.setText(String.valueOf(productoActual.getPrecio()));
        unidad_medida.setText(productoActual.getUnidad_medida());
        agregar.setText("actualizar");
        this.id = productoActual.getId_producto();
    }

    public void agregar() {

        if(marca.getText().isEmpty() || nombre.getText().isEmpty() || precio.getText().isEmpty() || unidad_medida.getText().isEmpty()){

            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("error");
            alert.setHeaderText("agrege nombre, marca, precio o unidad de medida");
            alert.showAndWait();

        }else {

            if (id == 0) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

                alert.setTitle("Guardar");
                alert.setHeaderText("¿Desea guardar el producto?");
                alert.showAndWait().ifPresent(
                        response -> {
                            if (response == ButtonType.OK) {

                                String marcaa = marca.getText();
                                String Nombre = nombre.getText();
                                Integer Precio = Integer.valueOf(precio.getText());
                                String unidadMedida = unidad_medida.getText();

                                Producto = new producto(0, Nombre,Precio,marcaa,unidadMedida);

                                guardarBD_producto.guardarBD(Producto);

                                listaDeProducto = seleccionarBD_producto.seleccionarBD();
                                Producto.setId_producto(listaDeProducto.get(listaDeProducto.size()-1).getId_producto());
                                cerrar();
                            }
                        }
                );
            } else {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

                alert.setTitle("Modificar");
                alert.setHeaderText("¿Desea actualizar el producto?");
                alert.showAndWait().ifPresent(
                        response -> {
                            if (response == ButtonType.OK) {



                                String marcaa = marca.getText();
                                String Nombre = nombre.getText();
                                Integer Precio = Integer.valueOf(precio.getText());
                                String unidadMedida = unidad_medida.getText();

                                Producto.setMarca(marcaa);
                                Producto.setNombre(Nombre);
                                Producto.setPrecio(Precio);
                                Producto.setUnidad_medida(unidadMedida);

                                actualizarBD_producto.ActualizarBD(Producto);

                                cerrar();
                            }
                        }
                );
            }
        }
    }

    public void cerrar() {

        Stage stage = (Stage) marca.getScene().getWindow();
        stage.close();

    }

    public producto obtenerNuevo() {
        return Producto;
    }

}
