package com.primerp.cfk;

public class C extends Temperatura {

    // Constructor con valor de temperatura en Celsius
    public C(Double valor) {
        this.setCantidad(valor);
        this.setValorUnidad("C");
    }

    // Constructor vacío
    public C() {}

    // Método Parse sobrecargado para convertir de Fahrenheit a Celsius
    public C Parse(F f) {
        Double valor = (f.getCantidad() - 32) * 5 / 9;
        return new C(valor);
    }

    // Método Parse sobrecargado para convertir de Kelvin a Celsius
    public C Parse(K k) {
        Double valor = k.getCantidad() - 273.15;
        return new C(valor);
    }

    // Método Parse sobrecargado para convertir entre Celsius (no hace nada en este caso)
    public C Parse(C c) {
        return c; // C to C (sin conversión)
    }
}
