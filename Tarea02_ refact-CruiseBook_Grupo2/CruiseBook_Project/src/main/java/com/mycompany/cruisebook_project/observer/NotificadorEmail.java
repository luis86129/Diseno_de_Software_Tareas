package com.mycompany.cruisebook_project.observer;

import com.mycompany.cruisebook_project.decorator.Reserva;

public class NotificadorEmail implements CanalNotificacion {
    @Override
    public void notificar(Reserva reserva, String mensaje) {
        System.out.println("[EMAIL] Notificación: " + mensaje);
    }
}
