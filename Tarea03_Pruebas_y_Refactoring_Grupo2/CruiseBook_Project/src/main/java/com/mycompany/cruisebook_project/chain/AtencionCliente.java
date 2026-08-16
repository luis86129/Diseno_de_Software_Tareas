package com.mycompany.cruisebook_project.chain;

import java.util.EnumSet;

public class AtencionCliente extends ManejadorIncidente {

    private final EnumSet<TipoIncidente> tiposManejables = EnumSet.of(TipoIncidente.RESERVA, TipoIncidente.SERVICIO_ABORDO);

    public boolean puedeResolver(Incidente incidente) {
        return tiposManejables.contains(incidente.getTipo());
    }

    @Override
    public void manejar(Incidente incidente) {
        System.out.println("[AtencionCliente] Revisando incidente " + incidente.getId()
                + " (" + incidente.getTipo() + ")");

        if (puedeResolver(incidente)) {
            incidente.marcarResuelto(); // Se llama al metodo original
            System.out.println("[AtencionCliente] Incidente " + incidente.getId() + " resuelto en primer nivel.");
        } else {
            System.out.println("[AtencionCliente] No se pudo resolver, escalando a gerencia.");
            pasarAlSiguiente(incidente);
        }
    }
}