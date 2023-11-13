package com.example.sistema_ventas.modelo.conexionBD.guardarBD;
import com.example.sistema_ventas.modelo.clases.venta;
import com.example.sistema_ventas.modelo.conexionBD.conexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class guardarBD_venta {

    venta venta;

    public com.example.sistema_ventas.modelo.clases.venta getVenta() {
        return venta;
    }

    public void setVenta(com.example.sistema_ventas.modelo.clases.venta venta) {
        this.venta = venta;
    }

    public guardarBD_venta(com.example.sistema_ventas.modelo.clases.venta venta) {
        this.venta = venta;
    }

    public void guardarBD() {

        conexionBD connectionnow = new conexionBD();
        Connection connectDB = connectionnow.getConnection();

        String InsertQuery = "INSERT into venta (id_empleado, id_caja, tipo_pago, precio_total) values (?,?,?,?)";

        try {

            PreparedStatement ps = connectDB.prepareStatement(InsertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, venta.getId_empleado());
            ps.setInt(2, venta.getId_caja());
            ps.setString(3, venta.getTipo_pago());
            ps.setDouble(4, venta.getPrecio_total());

            ps.executeUpdate();

            ResultSet resultSet = ps.getGeneratedKeys();

            while (resultSet.next()) {
                venta.setId(resultSet.getInt(1));
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
