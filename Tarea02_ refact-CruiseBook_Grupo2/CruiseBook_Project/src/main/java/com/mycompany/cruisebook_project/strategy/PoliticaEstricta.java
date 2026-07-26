package com.mycompany.cruisebook_project.strategy;

import com.mycompany.cruisebook_project.decorator.Reserva;

public class PoliticaEstricta implements PoliticaCancelacion {
    @Override
    public double calcularReembolso(Reserva reserva) {
        // Ejemplo: Devuelve solo el 50%
        return 50.0; 
    }

    @Override
    public boolean permiteReprogramacion() {
        return false;
    }
}