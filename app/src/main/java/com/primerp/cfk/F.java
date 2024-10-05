package com.primerp.cfk;

public class F extends Temperatura {

    // Constructor con valor de temperatura en Fahrenheit
    public F(Double valor) {
        this.setCantidad(valor);
        this.setValorUnidad("F");
    }

    // Constructor vacío
    public F() {}

    // Método Parse sobrecargado para convertir de Celsius a Fahrenheit
    public F Parse(C c) {
        Double valor = (c.getCantidad() * 9 / 5) + 32;
        return new F(valor);
    }

    // Método Parse sobrecargado para convertir de Kelvin a Fahrenheit
    public F Parse(K k) {
        Double valor = (k.getCantidad() - 273.15) * 9 / 5 + 32;
        return new F(valor);
    }

    // Método Parse sobrecargado para convertir entre Fahrenheit (no hace nada en este caso)
    public F Parse(F f) {
        return f; // F to F (sin conversión)
    }
}
