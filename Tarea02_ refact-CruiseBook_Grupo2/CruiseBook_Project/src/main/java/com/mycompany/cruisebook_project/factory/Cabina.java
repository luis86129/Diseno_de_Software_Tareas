package com.mycompany.cruisebook_project.factory;

public abstract class Cabina {
    private EstadoCabina estado;
    private double tarifaBase;

    public Cabina(double tarifaBase) {
        this.estado = EstadoCabina.DISPONIBLE; // Estado inicial
        this.tarifaBase = tarifaBase;
    }

    public EstadoCabina getEstado() { return estado; }
    public void setEstado(EstadoCabina estado) { this.estado = estado; }
    
    public double getTarifaBase() { return tarifaBase; }
    public void setTarifaBase(double tarifaBase) { this.tarifaBase = tarifaBase; }
}