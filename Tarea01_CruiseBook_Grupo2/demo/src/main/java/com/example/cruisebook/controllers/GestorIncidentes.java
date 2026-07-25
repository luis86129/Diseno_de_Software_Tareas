package com.example.cruisebook.controllers;
import com.example.cruisebook.models.*;
import java.util.List;

public class GestorIncidentes {
    private List<TicketIncidente> tickets;

    public TicketIncidente reportarIncidente(Reserva reserva, String descripcion, Enums.CategoriaIncidente categoria, String evidencia) {
        if (!verificarDuplicados(categoria, reserva)) {
            TicketIncidente nuevoTicket = new TicketIncidente();
            System.out.println("Registrando nuevo incidente: " + descripcion);
            // Simula notificar al equipo de atención al cliente
            return nuevoTicket;
        }
        return null;
    }

    public void escalarAGerencia(TicketIncidente ticket) {
        ticket.cambiarEstado(Enums.EstadoTicket.ESCALADO);
        System.out.println("El ticket ha sido escalado a Gerencia por falta de respuesta en 48h.");
    }

    public boolean verificarDuplicados(Enums.CategoriaIncidente categoria, Reserva reserva) {
        System.out.println("Verificando si existen tickets duplicados...");
        return false;
    }
}