package com.example.cruisebook.models;

class AtencionCliente extends PersonalCrucero {
    public void responderTicket(TicketIncidente ticket) {
        System.out.println("Atención al cliente responde al ticket: " + ticket);
    }
}