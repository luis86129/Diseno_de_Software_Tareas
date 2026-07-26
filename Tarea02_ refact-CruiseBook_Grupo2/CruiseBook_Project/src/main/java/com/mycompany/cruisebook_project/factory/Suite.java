package com.mycompany.cruisebook_project.factory;

public class Suite extends Cabina {
    private boolean tieneJacuzzi;

    public Suite(double tarifaBase, boolean tieneJacuzzi) {
        super(tarifaBase);
        this.tieneJacuzzi = tieneJacuzzi;
    }

    public boolean isTieneJacuzzi() { return tieneJacuzzi; }
    public void setTieneJacuzzi(boolean tieneJacuzzi) { this.tieneJacuzzi = tieneJacuzzi; }
}