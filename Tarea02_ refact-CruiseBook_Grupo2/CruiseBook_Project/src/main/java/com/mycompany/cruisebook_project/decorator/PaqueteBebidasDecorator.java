package com.mycompany.cruisebook_project.decorator;

public class PaqueteBebidasDecorator extends ServicioDecorator {
    private double costoPaquete;

    public PaqueteBebidasDecorator(ServicioReserva servicioEnvuelto, double costoPaquete) {
        super(servicioEnvuelto);
        this.costoPaquete = costoPaquete;
    }

    @Override
    public double calcularCosto() {
        return super.calcularCosto() + costoPaquete;
    }
    
    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Paquete de Bebidas";
    }
}