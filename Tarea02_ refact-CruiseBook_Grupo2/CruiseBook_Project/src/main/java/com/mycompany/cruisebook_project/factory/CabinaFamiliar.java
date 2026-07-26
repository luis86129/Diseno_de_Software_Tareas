package com.mycompany.cruisebook_project.factory;

public class CabinaFamiliar extends Cabina {
    private int capacidadMaxima;

    public CabinaFamiliar(double tarifaBase, int capacidadMaxima) {
        super(tarifaBase);
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getCapacidadMaxima() { return capacidadMaxima; }
    public void setCapacidadMaxima(int capacidadMaxima) { this.capacidadMaxima = capacidadMaxima; }
}