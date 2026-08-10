package com.mycompany.cruisebook_project.factory;

public class CabinaInterior extends Cabina {

    public CabinaInterior(String id, double tarifaBase) {
        super(id, tarifaBase);
    }

    @Override
    public void reservar() {
        super.reservar();
        System.out.println("[CabinaInterior] Reserva de cabina interior confirmada.");
    }

    @Override
    public String descripcion() {
        return "Cabina Interior";
    }
}
