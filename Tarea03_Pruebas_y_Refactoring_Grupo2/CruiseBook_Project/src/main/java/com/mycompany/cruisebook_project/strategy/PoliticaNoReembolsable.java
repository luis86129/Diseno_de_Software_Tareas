package com.mycompany.cruisebook_project.strategy;


import com.mycompany.cruisebook_project.observer.*;

public class PoliticaNoReembolsable implements PoliticaCancelacion {

    @Override
    public double calcularReembolso(Reserva reserva) {
        System.out.println("[PoliticaNoReembolsable] No aplica reembolso.");
        return 0.0;
    }

    @Override
    public boolean permiteReprogramacion() {
        return false;
    }
}
