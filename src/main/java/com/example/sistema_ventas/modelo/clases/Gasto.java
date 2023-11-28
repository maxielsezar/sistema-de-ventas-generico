package com.example.sistema_ventas.modelo.clases;

public class Gasto extends Dinero {

    public Gasto(double gasto, String description) {
        this.dinero=gasto;
        this.description=description;
    }

    @Override
    public String toString() {
        return "clases.Gasto en concepto de " + this.description
                + ". Importe total: " + this.dinero ;
    }
}
