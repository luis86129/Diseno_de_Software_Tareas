package com.mycompany.cruisebook_project;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.mycompany.cruisebook_project.factory.Crucero;

// Soluciona Code Smell: Divergent Change (Quita responsabilidades a Usuario)
public class GestorCruceros {

    public List<Crucero> buscarPorDestino(List<Crucero> catalogo, String destino) {
        // Soluciona Code Smell: Loops (Reemplaza for tradicional con Streams)
        return catalogo.stream()
                .filter(c -> c.getDestino().equalsIgnoreCase(destino))
                .collect(Collectors.toList());
    }
}