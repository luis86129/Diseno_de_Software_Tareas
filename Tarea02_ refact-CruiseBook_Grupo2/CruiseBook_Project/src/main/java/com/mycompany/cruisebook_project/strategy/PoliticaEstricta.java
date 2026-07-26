package com.mycompany.cruisebook_project.strategy;

import com.mycompany.cruisebook_project.observer.Reserva;

public class PoliticaEstricta implements PoliticaCancelacion {

    @Override
    public double calcularReembolso(Reserva reserva) {
        return 50.0; // Devuelve el 50%
    }

    @Override
    public boolean permiteReprogramacion() {
        return false;
    }
}
