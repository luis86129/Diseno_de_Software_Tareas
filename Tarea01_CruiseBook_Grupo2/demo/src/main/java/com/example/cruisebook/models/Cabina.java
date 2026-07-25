package com.example.cruisebook.models;
import com.example.cruisebook.models.Enums.*;
import com.example.cruisebook.models.Enums.EstadoCabina;
import com.example.cruisebook.models.Enums.TipoCabina;

public class Cabina {
    private TipoCabina tipo;
    private EstadoCabina estado;
    private double tarifaDetallada;

    public void cambiarEstado(EstadoCabina nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("El estado de la cabina cambió a: " + nuevoEstado);
    }
}
