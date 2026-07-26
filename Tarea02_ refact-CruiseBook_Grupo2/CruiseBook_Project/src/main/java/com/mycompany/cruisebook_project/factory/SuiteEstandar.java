package com.mycompany.cruisebook_project.factory;

import com.mycompany.cruisebook_project.models.Enums.EstadoCabina;

public class SuiteEstandar implements CabinaSuite {
    private EstadoCabina estado = EstadoCabina.DISPONIBLE;

    @Override
    public String getCaracteristicas() { 
        return "Suite Familiar con vista panorámica (Sin jacuzzi)"; 
    }
    
    @Override
    public double getPrecioBase() { 
        return 1000.0; 
    }

    @Override
    public boolean tieneJacuzzi() { 
        return false; 
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