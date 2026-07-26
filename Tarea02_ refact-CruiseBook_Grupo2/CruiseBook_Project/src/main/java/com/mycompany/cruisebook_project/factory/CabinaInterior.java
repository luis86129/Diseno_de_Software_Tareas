package com.mycompany.cruisebook_project.factory;

public class CabinaInterior extends Cabina {
    private boolean ventanaVirtual;

    public CabinaInterior(double tarifaBase, boolean ventanaVirtual) {
        super(tarifaBase);
        this.ventanaVirtual = ventanaVirtual;
    }

    public boolean isVentanaVirtual() { return ventanaVirtual; }
    public void setVentanaVirtual(boolean ventanaVirtual) { this.ventanaVirtual = ventanaVirtual; }
}