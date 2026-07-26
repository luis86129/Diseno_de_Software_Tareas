package com.mycompany.cruisebook_project.models;

import java.util.Date;

import com.mycompany.cruisebook_project.models.Enums.CategoriaIncidente;
import com.mycompany.cruisebook_project.models.Enums.EstadoTicket;

public class TicketIncidente {
    private String descripcion;
    private CategoriaIncidente categoria;
    private EstadoTicket estado;
    private Date timeStamp;

    public TicketIncidente(String descripcion, CategoriaIncidente categoria) {
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.timeStamp = new Date();
        this.estado = EstadoTicket.ABIERTO;
    }

    public void cambiarEstado(EstadoTicket nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("Ticket actualizado a estado: " + nuevoEstado);
    }

    public EstadoTicket getEstado() { return this.estado; }
    public String getDescripcion() { return this.descripcion; }
    public CategoriaIncidente getCategoria() { return this.categoria; }
    public Date getTimeStamp() { return this.timeStamp; }
}