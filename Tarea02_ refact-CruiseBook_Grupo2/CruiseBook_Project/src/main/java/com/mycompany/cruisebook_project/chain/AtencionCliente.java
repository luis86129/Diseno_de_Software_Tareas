package com.mycompany.cruisebook_project.chain;

import com.mycompany.cruisebook_project.models.Enums.EstadoTicket;
import com.mycompany.cruisebook_project.models.TicketIncidente;

public class AtencionCliente extends PersonalCrucero {
    @Override
    public void procesarIncidente(TicketIncidente ticket) {
        System.out.println("Atención al Cliente revisando ticket: " + ticket.getDescripcion());
        
        // Atención al cliente resuelve cosas básicas de la reserva o servicio a bordo
        switch(ticket.getCategoria()) {
            case RESERVA:
            case SERVICIO_A_BORDO:
                System.out.println(" -> Acción: Atención al Cliente resolvió el problema.");
                ticket.cambiarEstado(EstadoTicket.RESUELTO);
                break;
            default:
                if (sucesor != null) {
                    System.out.println(" -> Problema fuera de nuestro alcance (Requiere Gerencia). Escalando...");
                    ticket.cambiarEstado(EstadoTicket.ESCALADO);
                    sucesor.procesarIncidente(ticket);
                } else {
                    System.out.println(" -> No hay nivel superior para escalar.");
                }
                break;
        }
    }
}