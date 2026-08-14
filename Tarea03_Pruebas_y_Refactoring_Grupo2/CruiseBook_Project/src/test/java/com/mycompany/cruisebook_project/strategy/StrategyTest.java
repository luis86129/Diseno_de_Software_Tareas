/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cruisebook_project.strategy;

import com.mycompany.cruisebook_project.factory.*;
import com.mycompany.cruisebook_project.observer.*;
import com.mycompany.cruisebook_project.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

/**
 * Pruebas unitarias para las estrategias de política de cancelación
 * Cubre los casos: TC-27, TC-28, TC-29, TC-30
 */
public class StrategyTest {
    
    private Usuario usuario;
    private Cabina cabina;
    private Reserva reserva;
    
    @BeforeEach
    void setUp() {
        usuario = new Usuario("USR-01", "Luis", "luis@test.com", "+593999999999");
        CabinaFactory factoryPremium = new FactoryOperadorPremium();
        cabina = factoryPremium.crearSuite("SUITE-01");
        Date fechaExpiracion = new Date(System.currentTimeMillis() + 86_400_000);
        reserva = new Reserva("RES-001", usuario, cabina, fechaExpiracion);
        reserva.confirmarPago();
    }

    @Test
    @DisplayName("TC-27: Verificar reembolso completo en política flexible")
    void testPoliticaFlexibleReembolsoCompleto() {
        PoliticaCancelacion politica = new PoliticaFlexible();
        double reembolso = politica.calcularReembolso(reserva);
        
        assertEquals(2500.0, reembolso);
        assertTrue(politica.permiteReprogramacion());
    }

    @Test
    @DisplayName("TC-28: Verificar reembolso del 50% en política estricta")
    void testPoliticaEstrictaReembolso50() {
        PoliticaCancelacion politica = new PoliticaEstricta();
        double reembolso = politica.calcularReembolso(reserva);
        
        assertEquals(1250.0, reembolso);
        assertFalse(politica.permiteReprogramacion());
    }

    @Test
    @DisplayName("TC-29: Caso límite - no se aplica ningún reembolso en política no reembolsable")
    void testPoliticaNoReembolsableReembolsoCero() {
        PoliticaCancelacion politica = new PoliticaNoReembolsable();
        double reembolso = politica.calcularReembolso(reserva);
        
        assertEquals(0.0, reembolso);
        assertFalse(politica.permiteReprogramacion());
    }

    @Test
    @DisplayName("TTC-30: Verificar coherencia entre política restrictiva y reprogramación denegada")
    void testPoliticaNoReembolsableNoPermiteReprogramacion() {
        PoliticaCancelacion politica = new PoliticaNoReembolsable();
        
        assertFalse(politica.permiteReprogramacion());
        
        // Comparar con políticas más flexibles
        PoliticaCancelacion politicaFlexible = new PoliticaFlexible();
        assertTrue(politicaFlexible.permiteReprogramacion());
        
        PoliticaCancelacion politicaEstricta = new PoliticaEstricta();
        assertFalse(politicaEstricta.permiteReprogramacion());
    }
}

