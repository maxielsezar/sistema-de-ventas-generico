package com.example.sistema_ventas.modelo.clases;

import java.time.LocalDate;
import java.util.Date;

public class caja {

    int id;

    Date fecha;

    Double capital_inicial;


    public caja(int id, Date fecha, Double capital_inicial) {
        this.id = id;
        this.fecha = fecha;
        this.capital_inicial = capital_inicial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getCapital_inicial() {
        return capital_inicial;
    }

    public void setCapital_inicial(Double capital_inicial) {
        this.capital_inicial = capital_inicial;
    }

}
