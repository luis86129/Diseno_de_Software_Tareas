package com.mycompany.cruisebook_project.chain;


import com.mycompany.cruisebook_project.utils.Auditoria;

public abstract class ManejadorIncidente {
    protected ManejadorIncidente siguiente;

    public void setSiguiente(ManejadorIncidente siguiente) {
        this.siguiente = siguiente;
    }

    public abstract void manejar(Incidente incidente);

    protected void pasarAlSiguiente(Incidente incidente) {
        if (siguiente != null) {
            siguiente.manejar(incidente);
        } else {
            Auditoria.registrar("[ManejadorIncidente] Incidente " + incidente.getId()
                    + " no pudo ser resuelto por ningun nivel de la cadena.");
        }
    }
}
