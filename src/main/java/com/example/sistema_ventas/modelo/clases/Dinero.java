package com.example.sistema_ventas.modelo.clases;

public abstract class Dinero {

        protected double dinero;
        protected String description;

        public void setDinero(double dinero) {
            this.dinero = dinero;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getDinero() {
            return dinero;
        }

        public String getDescription() {
            return description;
        }
    }