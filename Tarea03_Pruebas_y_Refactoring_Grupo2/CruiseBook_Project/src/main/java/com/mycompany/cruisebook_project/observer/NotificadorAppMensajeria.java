package com.mycompany.cruisebook_project.observer;


import com.mycompany.cruisebook_project.utils.Auditoria;

public class NotificadorAppMensajeria implements CanalNotificacion {

    @Override
    public void notificar(Reserva reserva, String mensaje) {
        Auditoria.registrar("[App Mensajeria -> " + reserva.getUsuario().getNombre() + "] " + mensaje);
    }
}
