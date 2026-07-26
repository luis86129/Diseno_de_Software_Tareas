package com.mycompany.cruisebook_project.decorator;

public class TratamientoSpaDecorator extends ServicioDecorator {
    private double costoSpa;

    public TratamientoSpaDecorator(ServicioReserva servicioEnvuelto, double costoSpa) {
        super(servicioEnvuelto);
        this.costoSpa = costoSpa;
    }

    @Override
    public double calcularCosto() {
        return super.calcularCosto() + costoSpa;
    }
    
    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Tratamiento Spa";
    }
}