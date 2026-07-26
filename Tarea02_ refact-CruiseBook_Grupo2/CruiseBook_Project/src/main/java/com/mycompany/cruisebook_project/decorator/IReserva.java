package com.mycompany.cruisebook_project.decorator;

import com.mycompany.cruisebook_project.models.Usuario;
import com.mycompany.cruisebook_project.models.Cabina;

public interface IReserva {
    String getDescripcion();
    double getCostoTotal();
    Cabina getCabinaAsociada();
    Usuario getUsuario();
    void setConfirmada(boolean confirmada);
    boolean isConfirmada();
}