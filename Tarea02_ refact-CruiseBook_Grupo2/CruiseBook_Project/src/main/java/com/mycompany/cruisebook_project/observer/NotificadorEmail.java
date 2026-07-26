package com.mycompany.cruisebook_project.observer;

public class NotificadorEmail implements CanalNotificacion {
    @Override
    public void notificar(Reserva reserva, String mensaje) {
        System.out.println("[EMAIL] Enviando correo: " + mensaje);
    }
}
