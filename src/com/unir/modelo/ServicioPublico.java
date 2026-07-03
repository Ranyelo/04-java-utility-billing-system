package com.unir.modelo;

// ABSTRACCIÓN: Definimos una clase genérica que representa cualquier servicio
public abstract class ServicioPublico {

    // ENCAPSULAMIENTO: Atributos privados
    protected String nombreUsuario;
    protected String referencia;
    protected double consumo;
    protected double tarifa; // El precio unitario cambia según el servicio

    public ServicioPublico(String nombre, String ref, double consumo) {
        this.nombreUsuario = nombre;
        this.referencia = ref;
        this.consumo = consumo;
    }

    // Método abstracto: Obligamos a los hijos a definir cómo se calcula su total
    // POLIMORFISMO: Cada servicio implementará esto a su manera
    public abstract double calcularPago();

    // Getters para obtener info después
    public String getNombreUsuario() { return nombreUsuario; }
    public double getConsumo() { return consumo; }
}

