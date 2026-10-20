package com.perfumeria.modelo;

// Importa la clase que permite trabajar con fechas.
import java.time.LocalDate;

// Representa una formulación de perfume dentro del sistema.
public class Formula {

    // Atributos que almacenan la información de la formulación.
    private int id;
    private String nombre;
    private double cantidad;
    private LocalDate fechaElaboracion;
    private String responsable;

    // Constructor: permite crear una formulación con sus datos iniciales.
    public Formula(int id, String nombre, double cantidad,
                   LocalDate fechaElaboracion, String responsable) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fechaElaboracion = fechaElaboracion;
        this.responsable = responsable;
    }

    // Devuelve el identificador de la formulación.
    public int getId() {
        return id;
    }

    // Devuelve el nombre del perfume.
    public String getNombre() {
        return nombre;
    }

    // Devuelve la cantidad registrada.
    public double getCantidad() {
        return cantidad;
    }

    // Devuelve la fecha de elaboración.
    public LocalDate getFechaElaboracion() {
        return fechaElaboracion;
    }

    // Devuelve el nombre del responsable.
    public String getResponsable() {
        return responsable;
    }
}