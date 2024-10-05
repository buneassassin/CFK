package com.primerp.cfk;

public class K extends Temperatura {

    // Constructor con valor de temperatura en Kelvin
    public K(Double valor) {
        this.setCantidad(valor);
        this.setValorUnidad("K");
    }

    // Constructor vacío
    public K() {}

    // Método Parse sobrecargado para convertir de Celsius a Kelvin
    public K Parse(C c) {
        Double valor = c.getCantidad() + 273.15;
        return new K(valor);
    }

    // Método Parse sobrecargado para convertir de Fahrenheit a Kelvin
    public K Parse(F f) {
        Double valor = (f.getCantidad() - 32) * 5 / 9 + 273.15;
        return new K(valor);
    }

    // Método Parse sobrecargado para convertir entre Kelvin (no hace nada en este caso)
    public K Parse(K k) {
        return k; // K to K (sin conversión)
    }
}
