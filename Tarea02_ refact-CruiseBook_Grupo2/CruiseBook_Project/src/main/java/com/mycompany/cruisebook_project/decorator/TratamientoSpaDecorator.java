package com.mycompany.cruisebook_project.decorator;

public class TratamientoSpaDecorator extends ServicioAdicionalDecorator {
    
    public TratamientoSpaDecorator(IReserva reserva) { 
        super(reserva); 
    }

    @Override
    public String getDescripcion() { 
        return super.getDescripcion() + " + Tratamiento en el Spa"; 
    }

    @Override
    public double getCostoTotal() { 
        // Suma el costo del spa al total (puedes ajustar el valor si lo deseas)
        return super.getCostoTotal() + 100.0; 
    }
}