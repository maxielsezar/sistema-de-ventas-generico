package com.example.sistema_ventas.modelo.clases;

public class compra_producto {

    int id;

    int id_compra;

    int id_producto;

    int cant_producto;

    public compra_producto(int id, int id_compra, int id_producto, int cant_producto) {
        this.id = id;
        this.id_compra = id_compra;
        this.id_producto = id_producto;
        this.cant_producto = cant_producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCant_producto() {
        return cant_producto;
    }

    public void setCant_producto(int cant_producto) {
        this.cant_producto = cant_producto;
    }
}
