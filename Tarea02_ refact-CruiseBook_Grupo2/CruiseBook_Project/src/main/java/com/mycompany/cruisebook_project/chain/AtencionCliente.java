package com.mycompany.cruisebook_project.chain;

public class AtencionCliente extends ManejadorIncidente {
    
    @Override
    public void manejar(Incidente incidente) {
        // Atención al Cliente resuelve problemas de reservas y servicio a bordo
        if (incidente.getTipo() == TipoIncidente.RESERVA || incidente.getTipo() == TipoIncidente.SERVICIO_ABORDO) {
            System.out.println("Atención al Cliente resolvió el incidente: " + incidente.getDescripcion());
            incidente.setResuelto(true);
        } else {
            // Si no puede resolverlo, lo pasa al siguiente en la cadena
            if (siguiente != null) {
                System.out.println("Atención al Cliente no puede resolver este problema. Escalando...");
                siguiente.manejar(incidente);
            } else {
                System.out.println("No hay más niveles para escalar. El incidente no pudo ser resuelto.");
            }
        }
    }
}