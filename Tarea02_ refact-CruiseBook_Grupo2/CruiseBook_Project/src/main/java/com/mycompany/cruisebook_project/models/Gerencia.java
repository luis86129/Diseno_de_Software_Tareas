package com.mycompany.cruisebook_project.models;

import com.mycompany.cruisebook_project.models.Enums.EstadoTicket;

public class Gerencia extends PersonalCrucero {
    @Override
    public void procesarIncidente(TicketIncidente ticket) {
        System.out.println("Gerencia recibe el ticket escalado: " + ticket.getDescripcion());
        ticket.cambiarEstado(EstadoTicket.RESUELTO); 
    }
}
