package com.example.sistema_ventas.modelo.clases;

public class producto_tabla_stock extends producto {

    Integer stock;




    public producto_tabla_stock(int id, String nombre, int precio, String marca, Integer stock, String unidad_medida) {
        super(id, nombre, precio, marca, unidad_medida);
        this.stock = stock;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
