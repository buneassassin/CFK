package com.primerp.cfk;

public class K extends Temperatura {

    public K(double cantidad) {
        super(cantidad, "Kelvin");
    }

    public double Parse(C c) {
        return c.getCantidad() + 273.15; // C to K
    }

    public double Parse(F f) {
        return (f.getCantidad() - 32) * 5/9 + 273.15; // F to K
    }

    public double Parse(K k) {
        return k.getCantidad(); // K to K (no conversion needed)
    }
}
