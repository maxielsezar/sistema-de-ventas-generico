package com.example.sistema_ventas.modelo.clases;

public class cant_stock  {

    int id;
    int id_producto;
    int cantidad;

    public cant_stock(int id, int id_producto, int cantidad) {
        this.id = id;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
