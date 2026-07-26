package com.mycompany.cruisebook_project.strategy;

import com.mycompany.cruisebook_project.decorator.Reserva;

public class OperadorCrucero {
    private PoliticaCancelacion politica;

    public OperadorCrucero(PoliticaCancelacion politica) {
        this.politica = politica;
    }

    public void setPolitica(PoliticaCancelacion politica) {
        this.politica = politica;
    }

    public void aplicarPolitica(Reserva reserva) {
        double montoReembolso = politica.calcularReembolso(reserva);
        boolean reprogramar = politica.permiteReprogramacion();
        
        System.out.println("Aplicando política de cancelación...");
        System.out.println("Monto a reembolsar: $" + montoReembolso);
        System.out.println("¿Permite reprogramación?: " + (reprogramar ? "Sí" : "No"));
    }
}