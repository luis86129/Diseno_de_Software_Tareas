package com.mycompany.cruisebook_project.chain;


import com.mycompany.cruisebook_project.utils.Auditoria;

public class AtencionCliente extends ManejadorIncidente {

    @Override
    public void manejar(Incidente incidente) {
        Auditoria.registrar("[AtencionCliente] Revisando incidente " + incidente.getId()
                + " (" + incidente.getTipo() + ")");
        System.out.println();

        boolean puedeResolver = incidente.getTipo() == TipoIncidente.RESERVA
                || incidente.getTipo() == TipoIncidente.SERVICIO_ABORDO;

        if (puedeResolver) {
            incidente.marcarResuelto();
            Auditoria.registrar("[AtencionCliente] Incidente " + incidente.getId() + " resuelto en primer nivel.");
        } else {
            Auditoria.registrar("[AtencionCliente] No se pudo resolver, escalando a gerencia.");
            pasarAlSiguiente(incidente);
        }
    }
}
