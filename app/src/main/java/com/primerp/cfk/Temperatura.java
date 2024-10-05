package com.primerp.cfk;

public class Temperatura {
    protected double cantidad;
    protected String valorUnidad;

    // Constructor vacío
    public Temperatura() {}

    // Constructor con parámetros
    public Temperatura(double cantidad, String valorUnidad) {
        this.cantidad = cantidad;
        this.valorUnidad = valorUnidad;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getValorUnidad() {
        return valorUnidad;
    }

    public void setValorUnidad(String valorUnidad) {
        this.valorUnidad = valorUnidad;
    }
}
