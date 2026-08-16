package com.mycompany.cruisebook_project.chain;


import com.mycompany.cruisebook_project.utils.Auditoria;
import java.util.EnumSet;

public class AtencionCliente extends ManejadorIncidente {

    private final EnumSet<TipoIncidente> tiposManejables = EnumSet.of(TipoIncidente.RESERVA, TipoIncidente.SERVICIO_ABORDO);

    public boolean puedeResolver(Incidente incidente) {
        return tiposManejables.contains(incidente.getTipo());
    }

    @Override
    public void manejar(Incidente incidente) {
        Auditoria.registrar("[AtencionCliente] Revisando incidente " + incidente.getId()
                + " (" + incidente.getTipo() + ")");

        if (puedeResolver(incidente)) {
            incidente.marcarResuelto(); // Se llama al metodo original
            Auditoria.registrar("[AtencionCliente] Incidente " + incidente.getId() + " resuelto en primer nivel.");
        } else {
            Auditoria.registrar("[AtencionCliente] No se pudo resolver, escalando a gerencia.");
            pasarAlSiguiente(incidente);
        }
    }
}