package com.example.sistema_ventas.modelo.clases;

public class producto_tabla_stock extends producto {

    Integer stock;




    public producto_tabla_stock(int id, String nombre, int precio_x_unidad, String marca, Integer stock) {
        super(id, nombre, precio_x_unidad, marca);
        this.stock = stock;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
