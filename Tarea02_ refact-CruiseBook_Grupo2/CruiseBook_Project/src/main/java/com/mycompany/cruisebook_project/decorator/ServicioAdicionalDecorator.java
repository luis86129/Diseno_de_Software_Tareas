package com.mycompany.cruisebook_project.decorator;

import com.mycompany.cruisebook_project.models.Usuario;
import com.mycompany.cruisebook_project.models.Cabina;

public abstract class ServicioAdicionalDecorator implements IReserva {
    protected IReserva reservaWrapper;

    public ServicioAdicionalDecorator(IReserva reserva) {
        this.reservaWrapper = reserva;
    }

    @Override
    public String getDescripcion() { return reservaWrapper.getDescripcion(); }

    @Override
    public double getCostoTotal() { return reservaWrapper.getCostoTotal(); }

    @Override
    public Cabina getCabinaAsociada() { return reservaWrapper.getCabinaAsociada(); }
    
    @Override
    public Usuario getUsuario() { return reservaWrapper.getUsuario(); }
    
    @Override
    public void setConfirmada(boolean confirmada) { reservaWrapper.setConfirmada(confirmada); }
    
    @Override
    public boolean isConfirmada() { return reservaWrapper.isConfirmada(); }
}