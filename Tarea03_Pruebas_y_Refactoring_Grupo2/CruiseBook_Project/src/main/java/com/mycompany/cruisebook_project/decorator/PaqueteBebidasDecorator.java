package com.mycompany.cruisebook_project.decorator;

public class PaqueteBebidasDecorator extends ServicioDecorator {
    private static final double COSTO_PAQUETE = 90.0;

    public PaqueteBebidasDecorator(ServicioReserva servicioEnvuelto) {
        super(servicioEnvuelto);
    }

    @Override
    public double calcularCosto() {
        return super.calcularCosto() + COSTO_PAQUETE;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Paquete de bebidas";
    }
}
