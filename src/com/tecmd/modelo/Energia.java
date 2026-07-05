package com.tecmd.modelo;

// HERENCIA: "Energia" ES UN "ServicioPublico"
public class Energia extends ServicioPublico {

    public Energia(String nombre, String ref, double consumo) {
        super(nombre, ref, consumo);
        this.tarifa = 536; // Requerimiento del PDF
    }

    @Override
    public double calcularPago() {
        return this.consumo * this.tarifa;
    }
}
