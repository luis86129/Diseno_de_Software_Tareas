package com.mycompany.cruisebook_project.decorator;

public class TratamientoSpaDecorator extends ServicioDecorator {
    private static final double COSTO_SPA = 120.0;

    public TratamientoSpaDecorator(ServicioReserva servicioEnvuelto) {
        super(servicioEnvuelto);
    }

    @Override
    public double calcularCosto() {
        return super.calcularCosto() + COSTO_SPA;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Tratamiento de spa";
    }
}
