package com.mycompany.cruisebook_project.chain;


import com.mycompany.cruisebook_project.utils.Auditoria;

public class GerenciaCrucero extends ManejadorIncidente {

    @Override
    public void manejar(Incidente incidente) {
        Auditoria.registrar("[GerenciaCrucero] Revisando incidente escalado " + incidente.getId()
                + " (" + incidente.getTipo() + ")");
        incidente.marcarResuelto();
        Auditoria.registrar("[GerenciaCrucero] Incidente " + incidente.getId() + " resuelto por gerencia.");
    }
}
