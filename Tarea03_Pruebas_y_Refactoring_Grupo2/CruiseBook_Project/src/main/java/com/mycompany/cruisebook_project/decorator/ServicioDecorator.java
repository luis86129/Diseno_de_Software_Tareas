package com.mycompany.cruisebook_project.decorator;

public abstract class ServicioDecorator extends ServicioReserva {
    protected ServicioReserva servicioEnvuelto;

    protected ServicioDecorator(ServicioReserva servicioEnvuelto) {
        this.servicioEnvuelto = servicioEnvuelto;
    }

    @Override
    public double calcularCosto() {
        return servicioEnvuelto.calcularCosto();
    }

    @Override
    public String getDescripcion() {
        return servicioEnvuelto.getDescripcion();
    }
}
