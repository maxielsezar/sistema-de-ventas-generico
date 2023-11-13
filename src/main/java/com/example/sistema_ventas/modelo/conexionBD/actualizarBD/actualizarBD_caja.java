package com.example.sistema_ventas.modelo.conexionBD.actualizarBD;
import com.example.sistema_ventas.modelo.clases.caja;
import com.example.sistema_ventas.modelo.conexionBD.conexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class actualizarBD_caja {

    caja caja;

    public void ActualizarBD() {

        conexionBD connectionnow = new conexionBD();//nueva coneccion a bace de datos
        Connection connectDB = connectionnow.getConnection();

        String InsertQuery = " UPDATE caja  SET fecha = ?, capital = ? WHERE id_caja = ?";

        try {

            PreparedStatement ps = connectDB.prepareStatement(InsertQuery);
            ps.setString(1, String.valueOf(caja.getFecha()));
            ps.setDouble(2, caja.getCapital_inicial());
            ps.setInt(3, caja.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
