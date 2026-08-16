package com.mycompany.cruisebook_project.strategy;


import com.mycompany.cruisebook_project.observer.*;
import com.mycompany.cruisebook_project.utils.Auditoria;

public class PoliticaNoReembolsable implements PoliticaCancelacion {

    @Override
    public double calcularReembolso(Reserva reserva) {
        Auditoria.registrar("[PoliticaNoReembolsable] No aplica reembolso.");
        return 0.0;
    }

    @Override
    public boolean permiteReprogramacion() {
        return false;
    }
}
