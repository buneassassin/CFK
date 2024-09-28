package com.primerp.cfk;

public class C extends Temperatura {

    public C(double cantidad) {
        super(cantidad, "Celsius");
    }

    // Método Parse sobrecargado para convertir de Fahrenheit a Celsius
    public double Parse(F f) {
        return (f.getCantidad() - 32) * 5/9; // F to C
    }

    // Método Parse sobrecargado para convertir de Kelvin a Celsius
    public double Parse(K k) {
        return k.getCantidad() - 273.15; // K to C
    }

    // Método Parse sobrecargado para convertir entre Celsius (no hace nada en este caso)
    public double Parse(C c) {
        return c.getCantidad(); // C to C (no conversion needed)
    }
}

