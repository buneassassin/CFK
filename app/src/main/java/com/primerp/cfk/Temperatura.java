package com.primerp.cfk;

public class Temperatura {
    protected double cantidad;
    protected String valorUnidad;

    public Temperatura(double cantidad, String valorUnidad) {
        this.cantidad = cantidad;
        this.valorUnidad = valorUnidad;
    }

    // Método get para obtener la cantidad
    public double getCantidad() {
        return cantidad;
    }

    // Método get para obtener el valor de la unidad
    public String getValorUnidad() {
        return valorUnidad;
    }
}


