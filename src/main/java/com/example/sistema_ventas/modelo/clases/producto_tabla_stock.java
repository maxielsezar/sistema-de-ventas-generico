package com.example.sistema_ventas.modelo.clases;

public class producto_tabla_stock extends producto {

    double cantidad;

    public producto_tabla_stock(int id, String nombre, int precio, String marca, String unidad_medida, Double cantidad) {
        super(id, nombre, precio, marca, unidad_medida, cantidad);
        this.cantidad = cantidad;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}
