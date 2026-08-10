package com.mycompany.cruisebook_project.strategy;


import com.mycompany.cruisebook_project.observer.*;

public interface PoliticaCancelacion {
    double calcularReembolso(Reserva reserva);
    boolean permiteReprogramacion();
}
