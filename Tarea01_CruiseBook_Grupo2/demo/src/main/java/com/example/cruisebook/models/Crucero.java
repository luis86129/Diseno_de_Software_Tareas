package com.example.cruisebook.models;
import java.util.Date;
import java.util.List;

public class Crucero {
    private String destino;
    private Date fechaSalida;
    private int duracionDias;
    private List<String> rutas;
    private List<Cabina> cabinas;

    public List<Cabina> obtenerCabinas() { return this.cabinas; }
}