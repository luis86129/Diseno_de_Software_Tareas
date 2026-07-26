package com.mycompany.cruisebook_project.observer;

public class NotificadorSMS implements CanalNotificacion {
    @Override
    public void notificar(Reserva reserva, String mensaje) {
        System.out.println("[SMS] Enviando mensaje de texto: " + mensaje);
    }
}
