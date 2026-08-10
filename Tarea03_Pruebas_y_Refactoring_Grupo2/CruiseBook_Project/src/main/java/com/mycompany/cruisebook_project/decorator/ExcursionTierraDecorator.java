package com.mycompany.cruisebook_project.decorator;

public class ExcursionTierraDecorator extends ServicioDecorator {
    private static final double COSTO_EXCURSION = 150.0;

    public ExcursionTierraDecorator(ServicioReserva servicioEnvuelto) {
        super(servicioEnvuelto);
    }

    @Override
    public double calcularCosto() {
        return super.calcularCosto() + COSTO_EXCURSION;
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Excursion en tierra";
    }
}
