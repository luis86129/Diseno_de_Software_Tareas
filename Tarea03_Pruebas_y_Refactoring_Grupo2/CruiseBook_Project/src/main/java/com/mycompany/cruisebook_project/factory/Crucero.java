package com.mycompany.cruisebook_project.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Crucero {
    private final String id;
    private final String destino;
    private final Date fechaSalida;
    private final int duracionDias;
    private final OperadorCrucero operador;
    private final List<Cabina> cabinas;

    public Crucero(String id, String destino, Date fechaSalida, int duracionDias, OperadorCrucero operador) {
        this.id = id;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.duracionDias = duracionDias;
        this.operador = operador;
        this.cabinas = new ArrayList<>();
    }

    public void agregarCabina(Cabina cabina) {
        cabinas.add(cabina);
    }

    public List<Cabina> buscarCabinasDisponibles() {
        return cabinas.stream()               // Para corregir Feature Envy
                .filter(Cabina::isDisponible) // Ahora se usa el método isDisponible() de la clase Cabina
                .collect(Collectors.toList()); 
    }

    public String getId() {
        return id;
    }

    public String getDestino() {
        return destino;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public int getDuracionDias() {
        return duracionDias;
    }

    public OperadorCrucero getOperador() {
        return operador;
    }

    public List<Cabina> getCabinas() {
        return cabinas;
    }
}
