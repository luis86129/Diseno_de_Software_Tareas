package com.mycompany.cruisebook_project.factory;

public class OperadorCrucero {
    private String nombre;
    private CabinaFactory factory;

    public OperadorCrucero(String nombre, CabinaFactory factory) {
        this.nombre = nombre;
        this.factory = factory;
    }

    public CabinaFactory getFactory() {
        return factory;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}