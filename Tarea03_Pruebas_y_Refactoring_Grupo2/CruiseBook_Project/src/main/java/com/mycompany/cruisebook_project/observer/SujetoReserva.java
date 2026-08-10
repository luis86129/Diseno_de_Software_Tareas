package com.mycompany.cruisebook_project.observer;

public interface SujetoReserva {
    void suscribir(CanalNotificacion observador);
    void desuscribir(CanalNotificacion observador);
    void notificarCambio(String mensaje);
}
