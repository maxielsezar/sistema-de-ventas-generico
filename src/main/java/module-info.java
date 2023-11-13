module com.example.sistema_ventas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.sistema_ventas to javafx.fxml;
    exports com.example.sistema_ventas;
    opens com.example.sistema_ventas.controladores to javafx.fxml;
    exports com.example.sistema_ventas.controladores;
    opens com.example.sistema_ventas.modelo.clases to javafx.fxml;
    exports com.example.sistema_ventas.modelo.clases;
    opens com.example.sistema_ventas.modelo.conexionBD to javafx.fxml;
    exports com.example.sistema_ventas.modelo.conexionBD;
}