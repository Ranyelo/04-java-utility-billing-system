package com.unir.modelo;

public class Gas extends ServicioPublico {
    public Gas(String nombre, String ref, double consumo) {
        super(nombre, ref, consumo);
        this.tarifa = 710;
    }

    @Override
    public double calcularPago() {
        return this.consumo * this.tarifa;
    }
}