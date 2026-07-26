package com.mycompany.cruisebook_project.observer;

import java.util.ArrayList;
import java.util.List;

public class Reserva implements SujetoReserva {
    private EstadoReserva estado;
    private List<CanalNotificacion> observadores;

    public Reserva() {
        this.estado = EstadoReserva.PENDIENTE; // Estado por defecto
        this.observadores = new ArrayList<>();
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
        notificarCambio(); // Notifica automáticamente al cambiar de estado
    }

    @Override
    public void suscribir(CanalNotificacion observador) {
        observadores.add(observador);
    }

    @Override
    public void desuscribir(CanalNotificacion observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarCambio() {
        String mensaje = "El estado de su reserva ha cambiado a: " + estado;
        for (CanalNotificacion observador : observadores) {
            observador.notificar(this, mensaje);
        }
    }
}