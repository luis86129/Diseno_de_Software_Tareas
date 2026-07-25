package com.example.cruisebook.models;

class Gerencia extends PersonalCrucero {
    public void recibirEscalamiento(TicketIncidente ticket) {
        System.out.println("Gerencia recibe el ticket escalado: " + ticket);
    }
}
