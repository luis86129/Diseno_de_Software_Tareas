package com.mycompany.cruisebook_project.chain;


public class GerenciaCrucero extends ManejadorIncidente {

    @Override
    public void manejar(Incidente incidente) {
        System.out.println("[GerenciaCrucero] Revisando incidente escalado " + incidente.getId()
                + " (" + incidente.getTipo() + ")");
        incidente.marcarResuelto();
        System.out.println("[GerenciaCrucero] Incidente " + incidente.getId() + " resuelto por gerencia.");
    }
}
