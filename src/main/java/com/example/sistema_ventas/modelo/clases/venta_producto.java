package com.example.sistema_ventas.modelo.clases;

public class venta_producto {

    int id;

    int id_venta;

    int id_producto;

    int cant_venta;

    int total;

    public venta_producto(int id_venta, int id_producto, int cant_venta, int total) {

        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.cant_venta = cant_venta;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCant_venta() {
        return cant_venta;
    }

    public void setCant_venta(int cant_venta) {
        this.cant_venta = cant_venta;
    }
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
