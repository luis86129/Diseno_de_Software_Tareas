package com.mycompany.cruisebook_project.factory;

import com.mycompany.cruisebook_project.utils.Auditoria;

public class Suite extends Cabina {

    public Suite(String id, double tarifaBase) {
        super(id, tarifaBase);
    }

    @Override
    public void reservar() {
        super.reservar();
        Auditoria.registrar("[Suite] Reserva de Suite confirmada con beneficios premium.");
    }

    @Override
    public String descripcion() {
        return "Suite";
    }
}
