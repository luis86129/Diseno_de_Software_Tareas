package com.example.cruisebook.interfaces;

public interface ISistemaPagos {
    boolean solicitarCobro(String datosPago);
    boolean procesarDevolucion();
}