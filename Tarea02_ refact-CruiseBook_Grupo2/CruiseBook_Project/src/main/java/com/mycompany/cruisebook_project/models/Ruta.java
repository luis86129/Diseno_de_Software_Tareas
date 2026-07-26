package com.mycompany.cruisebook_project.models;

import java.util.Date;

public class Ruta {
    private String origen;
    private String destino;
    private Date fechaSalida;
    private int duracionDias;

    public Ruta(String origen, String destino, Date fechaSalida, int duracionDias) {
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.duracionDias = duracionDias;
    }

    public String getDestino() { return destino; }
    public Date getFechaSalida() { return fechaSalida; }
    public int getDuracionDias() { return duracionDias; }
    public String getOrigen() { return origen; }
}