package com.mycompany.cruisebook_project.decorator;

public class ExcursionDecorator extends ServicioAdicionalDecorator {
    
    public ExcursionDecorator(IReserva reserva) { super(reserva); }

    @Override
    public String getDescripcion() { return super.getDescripcion() + " + Excursión en tierra guiada"; }

    @Override
    public double getCostoTotal() { return super.getCostoTotal() + 200.0; }
}