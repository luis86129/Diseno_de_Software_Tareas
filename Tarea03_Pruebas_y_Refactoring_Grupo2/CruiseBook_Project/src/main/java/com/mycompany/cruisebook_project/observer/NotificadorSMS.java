package com.mycompany.cruisebook_project.observer;


import com.mycompany.cruisebook_project.utils.Auditoria;

public class NotificadorSMS implements CanalNotificacion {

    @Override
    public void notificar(Reserva reserva, String mensaje) {
        Auditoria.registrar("[SMS -> " + reserva.getUsuario().getTelefono() + "] " + mensaje);
    }
}
