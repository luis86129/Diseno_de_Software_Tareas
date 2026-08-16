package com.mycompany.cruisebook_project;

import com.mycompany.cruisebook_project.factory.Crucero;
import java.util.List;
import java.util.stream.Collectors;
import java.util.logging.Logger;

// Soluciona Code Smell: Divergent Change (Quita responsabilidades a Usuario)
public class GestorCruceros {
    private static final Logger logger = Logger.getLogger(GestorCruceros.class.getName());

    public List<Crucero> buscarPorDestino(List<Crucero> catalogo, String destino) {
        // Soluciona Code Smell: Loops (Reemplaza for tradicional con Streams)
        List<Crucero> resultado = catalogo.stream()
                .filter(c -> c.getDestino().equalsIgnoreCase(destino))
                .collect(Collectors.toList());
                
        logger.info("Se encontraron " + resultado.size() + " cruceros con destino a " + destino);
        return resultado;
    }
}