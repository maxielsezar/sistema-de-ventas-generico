package com.example.sistema_ventas.modelo.clases;

public class TiposDePago {

    String efectivo;

    String pagoVirtual;

    String tarjeta ;

    public TiposDePago(String efectivo, String pagoVirtual, String tarjeta) {
        this.efectivo = efectivo;
        this.pagoVirtual = pagoVirtual;
        this.tarjeta = tarjeta;
    }

    public String getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(String efectivo) {
        this.efectivo = efectivo;
    }

    public String getPagoVirtual() {
        return pagoVirtual;
    }

    public void setPagoVirtual(String pagoVirtual) {
        this.pagoVirtual = pagoVirtual;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }
}
