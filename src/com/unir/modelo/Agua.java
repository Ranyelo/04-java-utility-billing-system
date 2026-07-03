package com.unir.modelo;

public class Agua extends ServicioPublico {
    public Agua(String nombre, String ref, double consumo) {
        super(nombre, ref, consumo);
        this.tarifa = 730;
    }

    @Override
    public double calcularPago() {
        return this.consumo * this.tarifa;
    }
}

