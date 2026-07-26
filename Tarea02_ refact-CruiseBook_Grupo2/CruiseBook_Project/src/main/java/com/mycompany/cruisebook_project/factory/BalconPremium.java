package com.mycompany.cruisebook_project.factory;

import com.mycompany.cruisebook_project.models.Enums.EstadoCabina;

public class BalconPremium implements CabinaBalcon {
    private EstadoCabina estado = EstadoCabina.DISPONIBLE;

    @Override
    public String getCaracteristicas() { 
        return "Cabina con Balcón amplio y minibar premium"; 
    }
    
    @Override
    public double getPrecioBase() { 
        return 1200.0; 
    }

    @Override
    public double getMetrosCuadradosBalcon() {
        return 15.5;
    }

    @Override
    public EstadoCabina getEstado() { 
        return this.estado; 
    }

    @Override
    public void cambiarEstado(EstadoCabina nuevoEstado) {
        this.estado = nuevoEstado;
    }
}
