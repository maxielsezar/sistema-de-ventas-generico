package com.example.sistema_ventas;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Aplicacion {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
