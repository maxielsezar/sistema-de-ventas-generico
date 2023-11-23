package com.example.sistema_ventas.modelo.clases;

public class producto {

    int id_producto;

    String nombre;

    int precio;

    String marca;

    String unidad_medida;

    Double cantidad;

    public producto(int id, String nombre, int precio, String marca, String unidad_medida, Double cantidad) {
        this.id_producto = id;
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.unidad_medida = unidad_medida;
        this.cantidad = cantidad;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }
}
