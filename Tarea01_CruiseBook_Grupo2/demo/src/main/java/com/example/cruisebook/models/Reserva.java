package com.example.cruisebook.models;
import java.util.List;

public class Reserva {
    private Cabina cabinaAsociada;
    private Usuario usuario;
    private List<String> serviciosAdicionales;
    private double tarifaTotal;
    private int limiteRetencionMinutos = 15;
    private boolean confirmada;

    public void agregarServicioAdicional(String servicio) {
        this.serviciosAdicionales.add(servicio);
        System.out.println("Servicio agregado: " + servicio);
    }
    public Cabina getCabinaAsociada() { return this.cabinaAsociada; }
    public void setConfirmada(boolean confirmada) { this.confirmada = confirmada; }
    public Usuario getUsuario() { return this.usuario; }
}