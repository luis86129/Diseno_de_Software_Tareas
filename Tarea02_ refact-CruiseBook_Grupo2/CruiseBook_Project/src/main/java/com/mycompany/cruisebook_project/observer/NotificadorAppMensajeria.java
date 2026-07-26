package com.mycompany.cruisebook_project.observer;
import com.mycompany.cruisebook_project.decorator.Reserva;

public class NotificadorAppMensajeria implements CanalNotificacion {
    @Override
    public void notificar(Reserva reserva, String mensaje) {
        System.out.println("[APP PUSH] Notificación: " + mensaje);
    }
}
