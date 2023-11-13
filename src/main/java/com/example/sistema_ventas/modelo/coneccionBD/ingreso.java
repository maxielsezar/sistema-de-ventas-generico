package com.example.sistema_ventas.modelo.coneccionBD;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ingreso {
    private StringProperty usuario;
    private StringProperty contraseña;
    public PreparedStatement instruccion;
    public ResultSet resultado;

    public ingreso(String usuario, String contraseña) {
        this.usuario = new SimpleStringProperty(usuario);
        this.contraseña = new SimpleStringProperty(contraseña);
    }

    public ingreso() {
        throw new UnsupportedOperationException("Not supported yet.");
    }



    //Metodos atributo: usuario
    public String getUsuario() {
        return usuario.get();
    }
    public void setUsuario(String usuario) {
        this.usuario = new SimpleStringProperty(usuario);
    }
    public StringProperty UsuarioProperty() {
        return usuario;
    }
    //Metodos atributo: contraseña
    public String getContraseña() {
        return contraseña.get();
    }
    public void setContraseña(String contraseña) {
        this.contraseña = new SimpleStringProperty(contraseña);
    }
    public StringProperty ContraseñaProperty() {
        return contraseña;
    }

    public int ingresarUs(Connection connection) {

        try {
            String sql = "SELECT * FROM usuarios WHERE usuario = ? and contraseña = ?";

            instruccion = connection.prepareStatement(sql);
            instruccion.setString(1, usuario.get());
            instruccion.setString(2, contraseña.get());
            resultado = instruccion.executeQuery();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
