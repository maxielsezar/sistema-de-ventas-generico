package com.example.sistema_ventas.modelo.clases;

import java.time.LocalDate;
import java.util.Date;

public class venta {

    int id;
    int id_empleado;

    int id_caja;

    String tipo_pago;


    double precio_total;

    public venta(int id, int id_empleado, int id_caja, String tipo_pago, double precio_total) {
        this.id = id;
        this.id_empleado = id_empleado;
        this.id_caja = id_caja;
        this.tipo_pago = tipo_pago;
        this.precio_total = precio_total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_caja() {
        return id_caja;
    }

    public void setId_caja(int id_caja) {
        this.id_caja = id_caja;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }


    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }
}
