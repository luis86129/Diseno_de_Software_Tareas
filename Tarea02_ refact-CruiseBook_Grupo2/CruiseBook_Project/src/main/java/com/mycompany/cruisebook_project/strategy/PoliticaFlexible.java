package com.mycompany.cruisebook_project.strategy;

import com.mycompany.cruisebook_project.observer.Reserva;

public class PoliticaFlexible implements PoliticaCancelacion {

    @Override
    public double calcularReembolso(Reserva reserva) {
        return 100.0; // Devuelve el 100%
    }

    @Override
    public boolean permiteReprogramacion() {
        return true;
    }
}
