package com.mycompany.cruisebook_project.strategy;

import com.mycompany.cruisebook_project.observer.*;
import com.mycompany.cruisebook_project.utils.Auditoria;

public class PoliticaEstricta implements PoliticaCancelacion {

    private static final double PORCENTAJE_REEMBOLSO = 0.5;

    @Override
    public double calcularReembolso(Reserva reserva) {
        double reembolso = reserva.getCabina().getTarifaBase() * PORCENTAJE_REEMBOLSO;
        Auditoria.registrar("[PoliticaEstricta] Reembolso del 50%: " + reembolso);
        return reembolso;
    }

    @Override
    public boolean permiteReprogramacion() {
        return false;
    }
}
