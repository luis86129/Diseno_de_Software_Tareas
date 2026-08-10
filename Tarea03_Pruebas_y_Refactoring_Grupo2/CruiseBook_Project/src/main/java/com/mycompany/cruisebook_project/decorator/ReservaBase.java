package com.mycompany.cruisebook_project.decorator;

import com.mycompany.cruisebook_project.observer.*;

public class ReservaBase extends ServicioReserva {
    private final Reserva reserva;

    public ReservaBase(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public double calcularCosto() {
        return reserva.getCabina().getTarifaBase();
    }

    @Override
    public String getDescripcion() {
        return "Reserva base (" + reserva.getCabina().descripcion() + ")";
    }
}
