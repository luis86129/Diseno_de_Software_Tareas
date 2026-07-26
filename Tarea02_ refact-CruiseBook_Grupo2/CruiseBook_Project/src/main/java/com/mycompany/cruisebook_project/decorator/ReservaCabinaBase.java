package com.mycompany.cruisebook_project.decorator;

import com.mycompany.cruisebook_project.models.Usuario;
import com.mycompany.cruisebook_project.models.Cabina;

public class ReservaCabinaBase implements IReserva {
    private Usuario usuario;
    private Cabina cabinaAsociada; 
    private boolean confirmada;

    public ReservaCabinaBase(Usuario usuario, Cabina cabinaAsociada) {
        this.usuario = usuario;
        this.cabinaAsociada = cabinaAsociada;
        this.confirmada = false;
    }

    @Override
    public String getDescripcion() { return "Reserva para " + usuario.getNombre() + " | " + cabinaAsociada.getCaracteristicas(); }

    @Override
    public double getCostoTotal() { return cabinaAsociada.getPrecioBase(); }

    @Override
    public Cabina getCabinaAsociada() { return cabinaAsociada; }
    
    @Override
    public Usuario getUsuario() { return usuario; }
    
    @Override
    public void setConfirmada(boolean confirmada) { this.confirmada = confirmada; }
    
    @Override
    public boolean isConfirmada() { return confirmada; }
}