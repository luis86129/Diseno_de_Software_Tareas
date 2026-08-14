/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
*/

package com.mycompany.cruisebook_project.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/* Puebas unitarias para las clases de Cabina (Suite incluido) 
   Estas pruebas cubren los casos: TC-12, TC-13, TC-14, TC-15
*/

public class CabinaTest {

    private Suite suite;
    private CabinaBalcon cabinaBalcon;

    @BeforeEach
    void setUp() {
        CabinaFactory factoryPremium = new FactoryOperadorPremium();
        suite = factoryPremium.crearSuite("Suite-01");
        cabinaBalcon = factoryPremium.crearCabinaBalcon("BAL-01");
    }

    @Test
    @DisplayName("TC-12: Verificar transición de estado válida (DISPONIBLE -> RESERVADA)")
    void testReservarCabinaDisponible() {
        assertEquals(EstadoCabina.DISPONIBLE, suite.getEstado());
        
        suite.reservar();
        
        assertEquals(EstadoCabina.RESERVADA, suite.getEstado());
        assertNotEquals(EstadoCabina.DISPONIBLE, suite.getEstado());
    }

    @Test
    @DisplayName("TC-13: No permitir reservar dos veces la misma cabina")
    void testReservarCabinaYaReservada() {
        suite.reservar(); // Primera reserva exitosa
        assertEquals(EstadoCabina.RESERVADA, suite.getEstado());
        
        // Segunda reserva debe lanzar excepción
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            suite.reservar();
        });
        
        assertTrue(exception.getMessage().contains("no esta disponible"));
    }

    @Test
    @DisplayName("TC-14: Verificar que la cancelación libera correctamente la cabina")
    void testLiberarCabina() {
        suite.reservar();
        assertEquals(EstadoCabina.RESERVADA, suite.getEstado());
        
        suite.liberar();
        
        assertEquals(EstadoCabina.DISPONIBLE, suite.getEstado());
        assertNotEquals(EstadoCabina.RESERVADA, suite.getEstado());
    }

    @Test
    @DisplayName("TC-15: Verificar que una cabina puede marcarse fuera de servicio")
    void testPonerEnMantenimiento() {
        assertEquals(EstadoCabina.DISPONIBLE, suite.getEstado());
        
        suite.ponerEnMantenimiento();
        
        assertEquals(EstadoCabina.MANTENIMIENTO, suite.getEstado());
        assertNotEquals(EstadoCabina.DISPONIBLE, suite.getEstado());
        
        // Verificar desde cualquier estado
        suite.ponerEnMantenimiento(); // Ya está en mantenimiento
        assertEquals(EstadoCabina.MANTENIMIENTO, suite.getEstado());
    }
}