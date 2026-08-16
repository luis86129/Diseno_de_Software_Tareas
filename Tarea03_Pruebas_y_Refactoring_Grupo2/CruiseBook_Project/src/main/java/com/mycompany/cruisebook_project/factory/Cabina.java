package com.mycompany.cruisebook_project.factory;

public abstract class Cabina {
    private final String id;
    private EstadoCabina estado;
    private final double tarifaBase;

    protected Cabina(String id, double tarifaBase) {
        this.id = id;
        this.tarifaBase = tarifaBase;
        this.estado = EstadoCabina.DISPONIBLE;
    }

    public void reservar() {
        if (estado != EstadoCabina.DISPONIBLE) {
            throw new IllegalStateException("La cabina " + id + " no esta disponible");
        }
        estado = EstadoCabina.RESERVADA;
        System.out.println("[Cabina] " + descripcion() + " (" + id + ") reservada.");
    }

    public void liberar() {
        estado = EstadoCabina.DISPONIBLE;
        System.out.println("[Cabina] " + id + " liberada, ahora disponible.");
    }

    public void ponerEnMantenimiento() {
        estado = EstadoCabina.MANTENIMIENTO;
        System.out.println("[Cabina] " + id + " puesta en mantenimiento.");
    }

    public boolean isDisponible() {
        return estado == EstadoCabina.DISPONIBLE;
    }

    public abstract String descripcion();

    public String getId() {
        return id;
    }

    public EstadoCabina getEstado() {
        return estado;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }
}
