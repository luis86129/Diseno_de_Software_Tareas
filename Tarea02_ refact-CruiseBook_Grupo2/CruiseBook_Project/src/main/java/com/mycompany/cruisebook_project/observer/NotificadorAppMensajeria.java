package com.mycompany.cruisebook_project.observer;

public class NotificadorAppMensajeria implements CanalNotificacion {
    @Override
    public void notificar(Reserva reserva, String mensaje) {
        System.out.println("[APP] Notificación Push: " + mensaje);
    }
}
