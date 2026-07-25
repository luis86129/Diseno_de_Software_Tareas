package com.example.cruisebook.controllers;
import com.example.cruisebook.models.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class BuscadorCruceros {
    public List<Crucero> buscarCruceros(String destino, Date fecha, int duracion, Enums.TipoCabina tipo) {
        System.out.println("Consultando catálogo para el destino: " + destino);
        // Lógica mínima: Retorna una lista vacía simulando resultados
        return new ArrayList<>(); 
    }
}