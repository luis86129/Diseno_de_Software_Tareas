package com.mycompany.cruisebook_project.observer;

// Interfaz del Sujeto (Observable)
public interface SujetoReserva {
    void suscribir(CanalNotificacion observador);
    void desuscribir(CanalNotificacion observador);
    void notificarCambio();
}