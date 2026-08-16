package com.mycompany.cruisebook_project.factory;

import com.mycompany.cruisebook_project.utils.Auditoria;

public class CabinaInterior extends Cabina {

    public CabinaInterior(String id, double tarifaBase) {
        super(id, tarifaBase);
    }

    @Override
    public void reservar() {
        super.reservar();
        Auditoria.registrar("[CabinaInterior] Reserva de cabina interior confirmada.");
    }

    @Override
    public String descripcion() {
        return "Cabina Interior";
    }
}
