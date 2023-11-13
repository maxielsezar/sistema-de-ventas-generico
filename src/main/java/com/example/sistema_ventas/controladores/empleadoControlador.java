package com.example.sistema_ventas.controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class empleadoControlador implements Initializable {
    public Button venta;
    public Button caja;
    public Button producto;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    @FXML
    public void VentanaVenta() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ventana-venta.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("ventana venta");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
        public void VentanaCaja() {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("caja-view.fxml"));

                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("ventana caja");
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);

                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
    @FXML
    public void VentanaProducto() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("productos-ventas-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("ventana producto");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
