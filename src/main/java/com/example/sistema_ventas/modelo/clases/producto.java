package com.example.sistema_ventas.modelo.clases;

public class producto {

    int id_producto;

    String nombre;

    int precio_x_unidad;

    String marca;

    public producto(int id, String nombre, int precio_x_unidad, String marca) {
        this.id_producto = id;
        this.nombre = nombre;
        this.precio_x_unidad = precio_x_unidad;
        this.marca = marca;
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

    public int getPrecio_x_unidad() {
        return precio_x_unidad;
    }

    public void setPrecio_x_unidad(int precio_x_unidad) {
        this.precio_x_unidad = precio_x_unidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
