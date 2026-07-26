package com.mycompany.cruisebook_project.chain;

public class Usuario {
    
    // Método indicado en el diagrama para reportar el incidente
    public void reportarIncidente(Incidente incidente) {
        System.out.println("Usuario ha reportado un nuevo incidente: [" + incidente.getId() + "] " + incidente.getDescripcion());
    }
}