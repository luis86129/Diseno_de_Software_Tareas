package com.mycompany.cruisebook_project.chain;

import com.mycompany.cruisebook_project.models.Enums.EstadoTicket;
import com.mycompany.cruisebook_project.models.TicketIncidente;

public class Gerencia extends PersonalCrucero {
    @Override
    public void procesarIncidente(TicketIncidente ticket) {
        System.out.println("Gerencia recibe el ticket escalado: " + ticket.getDescripcion());
        
        // Gerencia tiene autoridad para resolver problemas de dinero (PAGOS)
        switch(ticket.getCategoria()) {
            case PAGO:
                System.out.println(" -> Acción: Gerencia aprobó el ajuste de facturación y resolvió el problema.");
                ticket.cambiarEstado(EstadoTicket.RESUELTO);
                break;
            default:
                if (sucesor != null) {
                    System.out.println(" -> Problema crítico. Escalando a nivel superior...");
                    sucesor.procesarIncidente(ticket);
                } else {
                    System.out.println(" -> Acción: Gerencia resolvió el problema de manera excepcional.");
                    ticket.cambiarEstado(EstadoTicket.RESUELTO);
                }
                break;
        }
    }
}