package com.mycompany.cruisebook_project.models;

import java.util.List;

public class Crucero {
    private String nombre;
    private List<Ruta> rutas;
    private List<Cabina> cabinas; 
    private List<PersonalCrucero> tripulacion; 

    public Crucero(String nombre, List<Ruta> rutas, List<Cabina> cabinas, List<PersonalCrucero> tripulacion) {
        this.nombre = nombre;
        this.rutas = rutas;
        this.cabinas = cabinas;
        this.tripulacion = tripulacion;
    }

    public String getNombre() { return nombre; }
    public List<Ruta> getRutas() { return rutas; }
    public List<Cabina> getCabinas() { return cabinas; }
    public List<PersonalCrucero> getTripulacion() { return tripulacion; }
}