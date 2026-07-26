package com.mycompany.cruisebook_project.strategy;

import com.mycompany.cruisebook_project.observer.Reserva;

public class PoliticaNoReembolsable implements PoliticaCancelacion {

    @Override
    public double calcularReembolso(Reserva reserva) {
        return 0.0; // Sin devolución
    }

    @Override
    public boolean permiteReprogramacion() {
        return false;
    }
}
