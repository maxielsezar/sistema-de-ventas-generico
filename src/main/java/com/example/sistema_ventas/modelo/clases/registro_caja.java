package com.example.sistema_ventas.modelo.clases;

public class registro_caja {


    int id;

    int id_caja;//el id caja no lo vamos a usar por cuestiones de tiempo

    Double capital;


    public registro_caja(int id, int id_caja, Double capital) {
        this.id = id;
        this.id_caja = id_caja;
        this.capital = capital;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_caja() {
        return id_caja;
    }

    public void setId_caja(int id_caja) {
        this.id_caja = id_caja;
    }

    public Double getCapital() {
        return capital;
    }

    public void setCapital(Double capital) {
        this.capital = capital;
    }
}
