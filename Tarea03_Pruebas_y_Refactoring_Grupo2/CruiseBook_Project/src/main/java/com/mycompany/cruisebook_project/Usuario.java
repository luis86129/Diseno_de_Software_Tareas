package com.mycompany.cruisebook_project;

import com.mycompany.cruisebook_project.chain.*;
import com.mycompany.cruisebook_project.factory.*;
import com.mycompany.cruisebook_project.observer.*;
import com.mycompany.cruisebook_project.utils.Auditoria;
import com.mycompany.cruisebook_project.utils.IdGenerator;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {
    private final String id;
    private final String nombre;
    private final String email;
    private final String telefono;
    private final List<Reserva> reservas;
    private final List<Incidente> incidentes;

    public Usuario(String id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.reservas = new ArrayList<>();
        this.incidentes = new ArrayList<>();
    }

    public List<Crucero> buscarCruceros(List<Crucero> catalogo, String destino) {
        List<Crucero> resultado = new ArrayList<>();
        for (Crucero c : catalogo) {
            if (c.getDestino().equalsIgnoreCase(destino)) {
                resultado.add(c);
            }
        }
        Auditoria.registrar("[Usuario] " + nombre + " encontro " + resultado.size()
                + " cruceros con destino a " + destino);
        return resultado;
    }

    public Reserva reservarCabina(Cabina cabina, Date fechaExpiracion) {
        Reserva reserva = new Reserva(IdGenerator.generar("RES"), this, cabina, fechaExpiracion);
        reservas.add(reserva);
        Auditoria.registrar("[Usuario] " + nombre + " genero la reserva " + reserva.getId());
        return reserva;
    }

    public Incidente reportarIncidente(String descripcion, TipoIncidente tipo, ManejadorIncidente manejador) {
        Incidente incidente = new Incidente(IdGenerator.generar("INC"), descripcion, tipo);
        incidentes.add(incidente);
        Auditoria.registrar("[Usuario] " + nombre + " reporto un incidente: " + descripcion);
        manejador.manejar(incidente);
        return incidente;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public List<Incidente> getIncidentes() {
        return incidentes;
    }
}
