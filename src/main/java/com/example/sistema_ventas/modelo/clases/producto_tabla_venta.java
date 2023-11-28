package com.example.sistema_ventas.modelo.clases;

public class producto_tabla_venta extends producto{

    int total;

    public producto_tabla_venta(int id, String nombre, int precio, String marca, String unidad_medida, Double cantidad) {
        super(id, nombre, precio, marca, unidad_medida, cantidad);
    }


    public double getTotal() {
        return cantidad * precio;
    }

}
