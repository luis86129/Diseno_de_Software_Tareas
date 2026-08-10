package com.mycompany.cruisebook_project.factory;

public class Suite extends Cabina {

    public Suite(String id, double tarifaBase) {
        super(id, tarifaBase);
    }

    @Override
    public void reservar() {
        super.reservar();
        System.out.println("[Suite] Reserva de Suite confirmada con beneficios premium.");
    }

    @Override
    public String descripcion() {
        return "Suite";
    }
}
