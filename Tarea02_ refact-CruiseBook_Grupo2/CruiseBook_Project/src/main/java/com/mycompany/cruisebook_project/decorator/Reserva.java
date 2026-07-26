package com.mycompany.cruisebook_project.decorator;

public class Reserva {
    private ServicioReserva servicios;

    public ServicioReserva getServicios() {
        return servicios;
    }

    public void setServicios(ServicioReserva servicios) {
        this.servicios = servicios;
    }
}