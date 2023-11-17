package com.example.sistema_ventas.modelo.conexionBD.guardarBD;
import com.example.sistema_ventas.modelo.clases.venta_producto;
import com.example.sistema_ventas.modelo.conexionBD.conexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class guardarBD_venta_producto {

    venta_producto venta_producto;
    public guardarBD_venta_producto(venta_producto venta_producto) {
        this.venta_producto = venta_producto;
    }



    public void guardarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String InsertQuery = "INSERT into venta_producto (id_venta, id_producto, cant_venta) values (?,?,?)";

        try {

            PreparedStatement ps = connectDB.prepareStatement(InsertQuery);
            ps.setInt(1, venta_producto.getId_venta());
            ps.setInt(2, venta_producto.getId_producto());
            ps.setDouble(3, venta_producto.getCant_venta());


            ps.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
