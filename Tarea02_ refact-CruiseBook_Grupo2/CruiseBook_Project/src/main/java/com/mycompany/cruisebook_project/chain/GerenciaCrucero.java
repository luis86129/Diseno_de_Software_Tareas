package com.mycompany.cruisebook_project.chain;

public class GerenciaCrucero extends ManejadorIncidente {
    
    @Override
    public void manejar(Incidente incidente) {
        // Gerencia se encarga de los problemas de pagos
        if (incidente.getTipo() == TipoIncidente.PAGO) {
            System.out.println("Gerencia del Crucero resolvió el incidente de pago: " + incidente.getDescripcion());
            incidente.setResuelto(true);
        } else {
            if (siguiente != null) {
                System.out.println("Gerencia escala el incidente al siguiente nivel...");
                siguiente.manejar(incidente);
            } else {
                System.out.println("Gerencia no pudo resolver el incidente.");
            }
        }
    }
}