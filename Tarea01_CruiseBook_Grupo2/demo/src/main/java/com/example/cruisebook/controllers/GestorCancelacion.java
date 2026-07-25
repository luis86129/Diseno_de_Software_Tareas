package com.example.cruisebook.controllers;
import com.example.cruisebook.models.*;
import com.example.cruisebook.interfaces.*;

public class GestorCancelacion {
    private ISistemaPagos sistemaPagos;
    private ISistemaNotificaciones sistemaNotificaciones;

    public double evaluarPoliticaCancelacion(Reserva reserva) {
        System.out.println("Evaluando políticas de cancelación para la reserva...");
        return 100.0; // Simula devolver el 100%
    }

    public void procesarReembolsoAutomatico(Reserva reserva) {
        boolean devuelto = sistemaPagos.procesarDevolucion();
        if (devuelto) {
            reserva.getCabinaAsociada().cambiarEstado(Enums.EstadoCabina.DISPONIBLE);
            sistemaNotificaciones.enviarConfirmacion(reserva.getUsuario().obtenerCanalPreferido(), "Reembolso procesado.");
        }
    }
}