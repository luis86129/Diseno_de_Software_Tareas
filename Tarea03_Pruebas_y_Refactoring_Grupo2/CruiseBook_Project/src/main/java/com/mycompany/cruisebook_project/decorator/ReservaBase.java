package com.mycompany.cruisebook_project.decorator;

import com.mycompany.cruisebook_project.observer.*;

public class ReservaBase extends ServicioReserva {
    private final Reserva reserva;

    public ReservaBase(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public double calcularCosto() {
        // Usa el Hide Delegate que creamos en Reserva
        return reserva.getTarifaBaseCabina();
    }

    @Override
    public String getDescripcion() {
        return "Reserva base (" + reserva.getCabina().descripcion() + ")";
    }
}
