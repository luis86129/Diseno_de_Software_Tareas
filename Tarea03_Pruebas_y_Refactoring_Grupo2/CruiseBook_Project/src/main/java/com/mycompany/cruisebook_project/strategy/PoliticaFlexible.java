package com.mycompany.cruisebook_project.strategy;

import com.mycompany.cruisebook_project.observer.*;

public class PoliticaFlexible implements PoliticaCancelacion {

    @Override
    public double calcularReembolso(Reserva reserva) {
        double reembolso = reserva.getCabina().getTarifaBase();
        System.out.println("[PoliticaFlexible] Reembolso del 100%: " + reembolso);
        return reembolso;
    }

    @Override
    public boolean permiteReprogramacion() {
        return true;
    }
}
