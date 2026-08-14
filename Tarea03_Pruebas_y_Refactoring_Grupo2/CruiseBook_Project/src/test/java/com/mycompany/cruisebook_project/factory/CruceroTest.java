/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
*/
package com.mycompany.cruisebook_project.factory;

import com.mycompany.cruisebook_project.strategy.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

/*
 * Pruebas unitarias para la clase Crucero
 * Cubre los casos: TC-07, TC-08, TC-09
*/

public class CruceroTest {
    private Crucero crucero;
    private CabinaFactory factoryPremium;
    private CabinaFactory factoryEconomico;

    @BeforeEach
    void setUp() {
        PoliticaCancelacion politicaFlexible = new PoliticaFlexible();
        OperadorCrucero operadorPremium = new OperadorCrucero("OP-01", "Royal Ocean Lines", new FactoryOperadorPremium(), politicaFlexible);
        
        crucero = new Crucero("CR-01", "Caribe", new Date(), 7, operadorPremium);
        
        factoryPremium = new FactoryOperadorPremium();
        factoryEconomico = new FactoryOperadorEconomico();
    }

    @Test
    @DisplayName("TC-07: Validar el filtrado correcto por estado DISPONIBLE")
    void testBuscarCabinasDisponibles() {
        // Agregar cabinas disponibles
        crucero.agregarCabina(factoryPremium.crearSuite("SUITE-01"));
        crucero.agregarCabina(factoryPremium.crearCabinaBalcon("BAL-01"));
        
        // Reservar una cabina para que no esté disponible
        Cabina cabinaReservada = crucero.getCabinas().get(0);
        cabinaReservada.reservar();
        
        List<Cabina> disponibles = crucero.buscarCabinasDisponibles();
        
        assertNotNull(disponibles);
        assertEquals(1, disponibles.size());
        assertTrue(disponibles.stream().allMatch(c -> c.getEstado() == EstadoCabina.DISPONIBLE));
        assertEquals("BAL-01", disponibles.get(0).getId());
    }

    @Test
    @DisplayName("TC-08: Caso límite - crucero sin cabinas")
    void testBuscarCabinasDisponiblesSinCabinas() {
        List<Cabina> disponibles = crucero.buscarCabinasDisponibles();
        
        assertNotNull(disponibles);
        assertTrue(disponibles.isEmpty());
        assertEquals(0, disponibles.size());
    }

    @Test
    @DisplayName("TC-09: Verificar que la cabina se agrega correctamente a la lista interna")
    void testAgregarCabina() {
        assertEquals(0, crucero.getCabinas().size());
        
        Cabina suite = factoryPremium.crearSuite("SUITE-01");
        crucero.agregarCabina(suite);
        
        assertEquals(1, crucero.getCabinas().size());
        assertTrue(crucero.getCabinas().contains(suite));
        assertEquals("SUITE-01", crucero.getCabinas().get(0).getId());
    }
}