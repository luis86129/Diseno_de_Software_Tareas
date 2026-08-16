package com.mycompany.cruisebook_project.observer;

import com.mycompany.cruisebook_project.decorator.*;
import com.mycompany.cruisebook_project.factory.*;
import com.mycompany.cruisebook_project.*;
import com.mycompany.cruisebook_project.utils.Auditoria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva implements SujetoReserva {
    private final String id;
    private final Usuario usuario;
    private final Cabina cabina;
    private Date fechaExpiracion;
    private EstadoReserva estado;
    private ServicioReserva servicios;
    private final List<CanalNotificacion> observadores;

    public Reserva(String id, Usuario usuario, Cabina cabina, Date fechaExpiracion) {
        this.id = id;
        this.usuario = usuario;
        this.cabina = cabina;
        this.fechaExpiracion = fechaExpiracion;
        this.estado = EstadoReserva.TEMPORAL;
        this.servicios = new ReservaBase(this);
        this.observadores = new ArrayList<>();
        cabina.reservar();
    }

    public void confirmarPago() {
        this.estado = EstadoReserva.CONFIRMADA;
        Auditoria.registrar("[Reserva] Pago confirmado. Costo total: " + servicios.calcularCosto());
        notificarCambio("Tu reserva " + id + " fue confirmada. Detalle: " + servicios.getDescripcion());
    }

    public void cancelar() {
        this.estado = EstadoReserva.CANCELADA;
        cabina.liberar();
        Auditoria.registrar("[Reserva] Reserva " + id + " cancelada.");
        notificarCambio("Tu reserva " + id + " fue cancelada.");
    }

    public void modificar() {
        this.estado = EstadoReserva.MODIFICADA;
        Auditoria.registrar("[Reserva] Reserva " + id + " modificada.");
        notificarCambio("Tu reserva " + id + " fue modificada.");
    }

    public void agregarServicio(ServicioReserva servicioDecorado) {
        this.servicios = servicioDecorado;
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
    public void notificarCambio(String mensaje) {
        for (CanalNotificacion canal : observadores) {
            canal.notificar(this, mensaje);
        }
    }

    public String getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Cabina getCabina() {
        return cabina;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public ServicioReserva getServicios() {
        return servicios;
    }

    // Hide Delegate para solucionar Message Chains
    public double getTarifaBaseCabina() {
        return cabina.getTarifaBase();
    }

}
