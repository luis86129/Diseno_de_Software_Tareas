package com.mycompany.cruisebook_project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.mycompany.cruisebook_project.chain.Incidente;
import com.mycompany.cruisebook_project.chain.ManejadorIncidente;
import com.mycompany.cruisebook_project.chain.TipoIncidente;
import com.mycompany.cruisebook_project.factory.Cabina;
import com.mycompany.cruisebook_project.factory.Crucero;
import com.mycompany.cruisebook_project.observer.Reserva;
import com.mycompany.cruisebook_project.utils.IdGenerator;

public class Usuario {
    private static final Logger logger = Logger.getLogger(Usuario.class.getName()); // Shotgun Surgery
    private final String id;
    private final DatosContacto contacto; // Long Parameter List
    private final List<Reserva> reservas;
    private final List<Incidente> incidentes;

    // Constructor refactorizado
    public Usuario(String id, DatosContacto contacto) {
        this.id = id;
        this.contacto = contacto;
        this.reservas = new ArrayList<>();
        this.incidentes = new ArrayList<>();
    }

    // NOTA: buscarCruceros() se movió a GestorCruceros (Divergent Change)

    public Reserva reservarCabina(Cabina cabina, Date fechaExpiracion) {
        cabina.reservar(); // Inappropriate Intimacy: Movido aquí desde el constructor de Reserva
        Reserva reserva = new Reserva(IdGenerator.generar("RES"), this, cabina, fechaExpiracion);
        reservas.add(reserva);
        logger.info(String.format("Usuario %s genero la reserva %s", getNombre(), reserva.getId()));
        return reserva;
    }

    public Incidente reportarIncidente(String descripcion, TipoIncidente tipo, ManejadorIncidente manejador) {
        Incidente incidente = new Incidente(IdGenerator.generar("INC"), descripcion, tipo);
        incidentes.add(incidente);
        logger.info(String.format("Usuario %s reporto un incidente: %s", getNombre(), descripcion));
        manejador.manejar(incidente);
        return incidente;
    }

    public String getId() { return id; }
    public String getNombre() { return contacto.nombre(); }
    public String getEmail() { return contacto.email(); }
    public String getTelefono() { return contacto.telefono(); }
    public List<Reserva> getReservas() { return reservas; }
    public List<Incidente> getIncidentes() { return incidentes; }
}
