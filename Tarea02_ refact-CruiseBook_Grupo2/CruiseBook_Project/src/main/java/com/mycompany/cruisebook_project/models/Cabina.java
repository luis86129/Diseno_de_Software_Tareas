package com.mycompany.cruisebook_project.models;

import com.mycompany.cruisebook_project.models.Enums.EstadoCabina;

public interface Cabina {
    String getCaracteristicas();
    double getPrecioBase();
    EstadoCabina getEstado();
    void cambiarEstado(EstadoCabina nuevoEstado);
}
