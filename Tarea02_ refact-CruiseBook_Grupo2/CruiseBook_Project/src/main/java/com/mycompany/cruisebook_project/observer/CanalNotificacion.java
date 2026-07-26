package com.mycompany.cruisebook_project.observer;

import com.mycompany.cruisebook_project.decorator.Reserva;

public interface CanalNotificacion {
    void notificar(Reserva reserva, String mensaje);
}
