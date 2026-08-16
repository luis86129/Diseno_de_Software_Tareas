package com.mycompany.cruisebook_project.factory;

import com.mycompany.cruisebook_project.utils.Auditoria;

public class CabinaFamiliar extends Cabina {

    public CabinaFamiliar(String id, double tarifaBase) {
        super(id, tarifaBase);
    }

    @Override
    public void reservar() {
        super.reservar();
        Auditoria.registrar("[CabinaFamiliar] Reserva de cabina familiar confirmada.");
    }

    @Override
    public String descripcion() {
        return "Cabina Familiar";
    }
}
