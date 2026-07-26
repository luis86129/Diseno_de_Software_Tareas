package com.mycompany.cruisebook_project.strategy;

import com.mycompany.cruisebook_project.decorator.Reserva;

public class PoliticaFlexible implements PoliticaCancelacion {
    @Override
    public double calcularReembolso(Reserva reserva) {
        // Ejemplo: Devuelve el 100% de un valor hipotético
        return 100.0; 
    }

    @Override
    public boolean permiteReprogramacion() {
        return true;
    }
}
