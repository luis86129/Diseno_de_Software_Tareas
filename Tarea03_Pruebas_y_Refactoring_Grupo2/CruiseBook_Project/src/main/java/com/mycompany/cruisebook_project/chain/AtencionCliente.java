package com.mycompany.cruisebook_project.chain;



public class AtencionCliente extends ManejadorIncidente {

    @Override
    public void manejar(Incidente incidente) {
        System.out.println("[AtencionCliente] Revisando incidente " + incidente.getId()
                + " (" + incidente.getTipo() + ")");

        boolean puedeResolver = incidente.getTipo() == TipoIncidente.RESERVA
                || incidente.getTipo() == TipoIncidente.SERVICIO_ABORDO;

        if (puedeResolver) {
            incidente.marcarResuelto();
            System.out.println("[AtencionCliente] Incidente " + incidente.getId() + " resuelto en primer nivel.");
        } else {
            System.out.println("[AtencionCliente] No se pudo resolver, escalando a gerencia.");
            pasarAlSiguiente(incidente);
        }
    }
}
