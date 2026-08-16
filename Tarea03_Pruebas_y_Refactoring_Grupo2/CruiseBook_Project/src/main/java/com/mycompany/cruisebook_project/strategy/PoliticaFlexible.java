package com.mycompany.cruisebook_project.strategy;

import com.mycompany.cruisebook_project.observer.*;
import com.mycompany.cruisebook_project.utils.Auditoria;

public class PoliticaFlexible implements PoliticaCancelacion {

    @Override
    public double calcularReembolso(Reserva reserva) {
        double reembolso = reserva.getCabina().getTarifaBase();
        Auditoria.registrar("[PoliticaFlexible] Reembolso del 100%: " + reembolso);
        return reembolso;
    }

    @Override
    public boolean permiteReprogramacion() {
        return true;
    }
}
