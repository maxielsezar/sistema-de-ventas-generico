package com.example.sistema_ventas.modelo.clases;

public class Ingreso extends Dinero {

        public Ingreso(double ingreso, String description) {
            this.dinero=ingreso;
            this.description=description;
        }

        @Override
        public String toString() {
            return "clases.Ingreso a su favor en concepto de " + this.description
                    + ". Importe total: " + this.dinero ;
        }
    }

