package com.mycompany.cruisebook_project.decorator;

public class ExcursionTierraDecorator extends ServicioDecorator {
    private double costoExcursion;

    public ExcursionTierraDecorator(ServicioReserva servicioEnvuelto, double costoExcursion) {
        super(servicioEnvuelto);
        this.costoExcursion = costoExcursion;
    }

    @Override
    public double calcularCosto() {
        return super.calcularCosto() + costoExcursion;
    }
    
    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Excursión en Tierra";
    }
}