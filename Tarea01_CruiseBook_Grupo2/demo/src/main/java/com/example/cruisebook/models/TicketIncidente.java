package com.example.cruisebook.models;
import java.util.Date;

import com.example.cruisebook.models.Enums.*;
import com.example.cruisebook.models.Enums.CategoriaIncidente;
import com.example.cruisebook.models.Enums.EstadoTicket;

public class TicketIncidente {
    private String numeroTicket;
    private Reserva reservaAfectada;
    private String descripcion;
    private CategoriaIncidente categoria;
    private String evidenciaAdjunta;
    private Date timeStamp;
    private EstadoTicket estado;

    public void cambiarEstado(EstadoTicket nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("Ticket actualizado a estado: " + nuevoEstado);
    }
    public EstadoTicket getEstado() { return this.estado; }
}