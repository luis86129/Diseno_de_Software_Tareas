package com.mycompany.cruisebook_project.factory;

public class CabinaFamiliar extends Cabina {

    public CabinaFamiliar(String id, double tarifaBase) {
        super(id, tarifaBase);
    }

    @Override
    public void reservar() {
        super.reservar();
        System.out.println("[CabinaFamiliar] Reserva de cabina familiar confirmada.");
    }

    @Override
    public String descripcion() {
        return "Cabina Familiar";
    }
}
