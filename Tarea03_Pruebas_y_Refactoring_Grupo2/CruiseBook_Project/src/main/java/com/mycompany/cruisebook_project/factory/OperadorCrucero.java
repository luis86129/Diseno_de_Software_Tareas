package com.mycompany.cruisebook_project.factory;

import com.mycompany.cruisebook_project.strategy.*;

public class OperadorCrucero {
    private final String id;
    private final String nombre;
    private PoliticaCancelacion politicaCancelacion;
    private final CabinaFactory factory;

    public OperadorCrucero(String id, String nombre, CabinaFactory factory, PoliticaCancelacion politicaCancelacion) {
        this.id = id;
        this.nombre = nombre;
        this.factory = factory;
        this.politicaCancelacion = politicaCancelacion;
    }

    public CabinaFactory getFactory() {
        return factory;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public PoliticaCancelacion getPoliticaCancelacion() {
        return politicaCancelacion;
    }

    public void setPoliticaCancelacion(PoliticaCancelacion politicaCancelacion) {
        this.politicaCancelacion = politicaCancelacion;
    }
}
