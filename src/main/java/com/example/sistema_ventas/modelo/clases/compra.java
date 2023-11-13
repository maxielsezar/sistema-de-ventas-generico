package com.example.sistema_ventas.modelo.clases;

import java.time.LocalDate;
import java.util.Date;

public class compra {

    int id;

    Date fecha;

    String proveedor;

    Double total_compra;

    public compra(int id, Date fecha, String proveedor, Double total_compra) {
        this.id = id;
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.total_compra = total_compra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Double getTotal_compra() {
        return total_compra;
    }

    public void setTotal_compra(Double total_compra) {
        this.total_compra = total_compra;
    }
}
