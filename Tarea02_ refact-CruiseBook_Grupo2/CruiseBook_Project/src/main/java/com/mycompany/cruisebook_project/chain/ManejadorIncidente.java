package com.mycompany.cruisebook_project.chain;

public abstract class ManejadorIncidente {
    protected ManejadorIncidente siguiente;

    public void setSiguiente(ManejadorIncidente m) {
        this.siguiente = m;
    }

    public abstract void manejar(Incidente incidente);
}