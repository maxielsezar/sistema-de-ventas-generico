package com.example.sistema_ventas.modelo.conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexionBD {
    public Connection databaseLink;
    public Connection getConnection(){
        String databaseName ="sistema_ventas";
        String databaseUser ="root";
        String databasePassword ="opce03";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser,databasePassword);
        } catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }
}
