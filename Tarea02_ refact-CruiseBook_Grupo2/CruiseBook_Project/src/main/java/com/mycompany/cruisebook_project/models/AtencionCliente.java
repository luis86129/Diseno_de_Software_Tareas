package com.mycompany.cruisebook_project.models;

import com.mycompany.cruisebook_project.models.Enums.EstadoTicket;

public class AtencionCliente extends PersonalCrucero {
    @Override
    public void procesarIncidente(TicketIncidente ticket) {
        System.out.println("Atención al Cliente revisando ticket: " + ticket.getDescripcion());
        
        if (sucesor != null) {
            System.out.println("Problema complejo. Escalando a gerencia...");
            ticket.cambiarEstado(EstadoTicket.ESCALADO);
            sucesor.procesarIncidente(ticket);
        } else {
            ticket.cambiarEstado(EstadoTicket.RESUELTO);
        }
    }
}