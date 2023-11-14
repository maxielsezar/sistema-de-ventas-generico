package com.example.sistema_ventas.controlers;

import com.example.sistema_ventas.modelo.coneccionBD.usuario;
import com.example.sistema_ventas.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VentanaInicioController implements Initializable {

    public TextField txtUsuario;
    public PasswordField txtContraseña;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    public void btnIngresar(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(HelloApplication.class.getResource("inicio-administrador-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("ventana administrador");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);

            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void btnEmpleado(){
        try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(HelloApplication.class.getResource("inicio-empleado-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("ventana empleado");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        } catch (IOException e) {
        throw new RuntimeException(e);
        }
    }




}