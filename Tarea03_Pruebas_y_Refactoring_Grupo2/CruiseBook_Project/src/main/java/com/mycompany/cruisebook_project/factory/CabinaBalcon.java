package com.mycompany.cruisebook_project.factory;

import com.mycompany.cruisebook_project.utils.Auditoria;

public class CabinaBalcon extends Cabina {

    public CabinaBalcon(String id, double tarifaBase) {
        super(id, tarifaBase);
    }

    @Override
    public void reservar() {
        super.reservar();
        Auditoria.registrar("[CabinaBalcon] Reserva de cabina con balcon confirmada.");
    }

    @Override
    public String descripcion() {
        return "Cabina con Balcon";
    }
}
