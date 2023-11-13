package com.example.sistema_ventas.modelo.clases;

public class producto_tabla_venta extends producto{
    Integer cantidad=1;

    int total;


    public producto_tabla_venta(int id, String nombre, int precio_x_unidad, String marca) {
        super(id, nombre, precio_x_unidad, marca);

    }
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return cantidad * precio_x_unidad;
    }

}
