package com.example.cruisebook.controllers;
import com.example.cruisebook.models.*;
import com.example.cruisebook.interfaces.*;

public class GestorPago {
    private ISistemaPagos sistemaPagos;
    private ISistemaNotificaciones sistemaNotificaciones;

    public GestorPago(ISistemaPagos pagos, ISistemaNotificaciones notificaciones) {
        this.sistemaPagos = pagos;
        this.sistemaNotificaciones = notificaciones;
    }

    public void realizarPago(String datosPago, Reserva reserva) {
        if (validarDatosLocales(datosPago)) {
            boolean exito = sistemaPagos.solicitarCobro(datosPago);
            if (exito) {
                reserva.setConfirmada(true);
                reserva.getCabinaAsociada().cambiarEstado(Enums.EstadoCabina.OCUPADA);
                sistemaNotificaciones.enviarConfirmacion(reserva.getUsuario().obtenerCanalPreferido(), "Pago confirmado exitosamente.");
            }
        }
    }

    public boolean validarDatosLocales(String datosPago) {
        return datosPago != null && !datosPago.isEmpty();
    }
}