package com.example.sistema_ventas.controlers;

import com.example.sistema_ventas.modelo.clases.producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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

    /*public void agregar() {

        if(marca.getText().isEmpty() || nombre.getText().isEmpty() || precioUnidad.getText().isEmpty()){

            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("error");
            alert.setHeaderText("agrege nombre, marca o precio x unidad");
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
                                Integer precio = Integer.valueOf(precioUnidad.getText());


                                Producto = new producto(0, Nombre,precio,marcaa);


                                listaDeNotebook = seleccionarDB_notebook.seleccionar();
                                Notebook.setId(listaDeNotebook.get(listaDeNotebook.size()-1).getId());
                                cerrar();
                            }
                        }
                );
            } else {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
                Image iconoo = new Image(Objects.requireNonNull(getClass().getResourceAsStream("ICONOS/icono-notebook.png")));
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(iconoo);

                alert.setTitle("Modificar");
                alert.setHeaderText("¿Desea actualizar la notebook?");
                alert.showAndWait().ifPresent(
                        response -> {
                            if (response == ButtonType.OK) {

                                String marcaa = marca.getText();
                                String modeloo = modelo.getText();

                                Notebook.setMarca(marcaa);
                                Notebook.setModelo(modeloo);

                                actualizarBD_notebook.Actualizar(Notebook);

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

    public notebook obtenerNuevo() {
        return Notebook;
    }*/

}
