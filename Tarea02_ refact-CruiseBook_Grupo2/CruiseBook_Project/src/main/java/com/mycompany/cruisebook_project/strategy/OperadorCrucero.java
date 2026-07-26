package com.mycompany.cruisebook_project.strategy;

import com.mycompany.cruisebook_project.observer.Reserva;

public class OperadorCrucero {
    private PoliticaCancelacion politica;

    // Inyección de la estrategia
    public OperadorCrucero(PoliticaCancelacion politica) {
        this.politica = politica;
    }

    public void setPolitica(PoliticaCancelacion nuevaPolitica) {
        this.politica = nuevaPolitica;
    }

    public void aplicarPolitica(Reserva reserva) {
        double porcentaje = politica.calcularReembolso(reserva);
        boolean reprogramar = politica.permiteReprogramacion();
        System.out.println("Porcentaje a reembolsar: " + porcentaje + "%");
        System.out.println("¿Permite reprogramación?: " + reprogramar);
    }
}