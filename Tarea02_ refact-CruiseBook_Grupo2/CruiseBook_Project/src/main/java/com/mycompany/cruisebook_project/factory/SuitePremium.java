package com.mycompany.cruisebook_project.factory;

import com.mycompany.cruisebook_project.models.Enums.EstadoCabina;

public class SuitePremium implements CabinaSuite {
    private EstadoCabina estado = EstadoCabina.DISPONIBLE; // Toda cabina nace disponible

    @Override
    public String getCaracteristicas() { 
        return "Suite de Lujo con Jacuzzi y Mayordomo"; 
    }
    
    @Override
    public double getPrecioBase() { 
        return 2000.0; 
    }

    @Override
    public boolean tieneJacuzzi() { 
        return true; 
    }

    @Override
    public EstadoCabina getEstado() { 
        return this.estado; 
    }

    @Override
    public void cambiarEstado(EstadoCabina nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("Suite Premium cambió de estado a: " + nuevoEstado);
    }
}
