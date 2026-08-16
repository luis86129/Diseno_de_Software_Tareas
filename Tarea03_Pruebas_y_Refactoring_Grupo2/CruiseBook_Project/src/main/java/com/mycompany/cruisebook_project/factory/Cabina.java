package com.mycompany.cruisebook_project.factory;

import com.mycompany.cruisebook_project.utils.Auditoria;

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
        Auditoria.registrar("[Cabina] " + descripcion() + " (" + id + ") reservada.");
    }

    public void liberar() {
        estado = EstadoCabina.DISPONIBLE;
        Auditoria.registrar("[Cabina] " + id + " liberada, ahora disponible.");
    }

    public void ponerEnMantenimiento() {
        estado = EstadoCabina.MANTENIMIENTO;
        Auditoria.registrar("[Cabina] " + id + " puesta en mantenimiento.");
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
