package com.primerp.cfk;

public class F extends Temperatura {

    public F(double cantidad) {
        super(cantidad, "Fahrenheit");
    }

    public double Parse(C c) {
        return (c.getCantidad() * 9/5) + 32; // C to F
    }

    public double Parse(K k) {
        return (k.getCantidad() - 273.15) * 9/5 + 32; // K to F
    }

    public double Parse(F f) {
        return f.getCantidad(); // F to F (no conversion needed)
    }
}

