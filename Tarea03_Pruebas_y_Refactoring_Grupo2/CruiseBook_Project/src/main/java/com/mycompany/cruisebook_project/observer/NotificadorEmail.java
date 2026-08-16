package com.mycompany.cruisebook_project.observer;


import com.mycompany.cruisebook_project.utils.Auditoria;

public class NotificadorEmail implements CanalNotificacion {

    @Override
    public void notificar(Reserva reserva, String mensaje) {
        Auditoria.registrar("[Email -> " + reserva.getUsuario().getEmail() + "] " + mensaje);
    }
}
