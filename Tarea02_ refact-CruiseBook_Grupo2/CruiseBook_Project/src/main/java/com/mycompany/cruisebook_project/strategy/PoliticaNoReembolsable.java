package com.mycompany.cruisebook_project.strategy;

import com.mycompany.cruisebook_project.decorator.Reserva;

public class PoliticaNoReembolsable implements PoliticaCancelacion {
    @Override
    public double calcularReembolso(Reserva reserva) {
        // No hay reembolso
        return 0.0; 
    }

    @Override
    public boolean permiteReprogramacion() {
        return false;
    }
}