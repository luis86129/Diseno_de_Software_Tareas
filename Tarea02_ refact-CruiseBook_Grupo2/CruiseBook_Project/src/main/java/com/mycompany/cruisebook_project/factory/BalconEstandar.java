package com.mycompany.cruisebook_project.factory;

import com.mycompany.cruisebook_project.models.Enums.EstadoCabina;

public class BalconEstandar implements CabinaBalcon {
    private EstadoCabina estado = EstadoCabina.DISPONIBLE;

    @Override
    public String getCaracteristicas() { 
        return "Cabina con Balcón estándar"; 
    }
    
    @Override
    public double getPrecioBase() { 
        return 800.0; 
    }

    @Override
    public double getMetrosCuadradosBalcon() {
        return 5.0;
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
