package com.mycompany.cruisebook_project.strategy;

import com.mycompany.cruisebook_project.decorator.Reserva;

public interface PoliticaCancelacion {
    double calcularReembolso(Reserva reserva);
    boolean permiteReprogramacion();
}
