package com.mycompany.cruisebook_project.decorator;

public class PaqueteBebidasDecorator extends ServicioAdicionalDecorator {
    
    public PaqueteBebidasDecorator(IReserva reserva) { super(reserva); }

    @Override
    public String getDescripcion() { return super.getDescripcion() + " + Paquete de Bebidas Premium"; }

    @Override
    public double getCostoTotal() { return super.getCostoTotal() + 150.0; }
}