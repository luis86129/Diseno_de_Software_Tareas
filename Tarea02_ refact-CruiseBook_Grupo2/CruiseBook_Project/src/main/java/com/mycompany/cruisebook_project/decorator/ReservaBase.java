package com.mycompany.cruisebook_project.decorator;

public class ReservaBase extends ServicioReserva {
    private Reserva reserva;

    public ReservaBase(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public double calcularCosto() {
        // Retorna el costo base de la reserva
        return 1000.0; 
    }

    @Override
    public String getDescripcion() {
        return "Reserva Base de Crucero";
    }
}