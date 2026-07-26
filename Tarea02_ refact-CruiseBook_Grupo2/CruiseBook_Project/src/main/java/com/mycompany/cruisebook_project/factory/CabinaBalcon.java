package com.mycompany.cruisebook_project.factory;

public class CabinaBalcon extends Cabina {
    private double metrosBalcon;

    public CabinaBalcon(double tarifaBase, double metrosBalcon) {
        super(tarifaBase);
        this.metrosBalcon = metrosBalcon;
    }

    public double getMetrosBalcon() { return metrosBalcon; }
    public void setMetrosBalcon(double metrosBalcon) { this.metrosBalcon = metrosBalcon; }
}