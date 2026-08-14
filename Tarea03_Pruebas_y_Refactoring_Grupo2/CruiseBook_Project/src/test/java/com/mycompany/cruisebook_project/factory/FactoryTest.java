/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
*/
package com.mycompany.cruisebook_project.factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;

/*
 * Pruebas unitaria para las fabricas
 * Cubre los casos: TC-16, TC-17
*/
public class FactoryTest {

    @Test
    @DisplayName("TC-16: Verificar que la fábrica premium crea cabinas con tarifas premium")
    void testFactoryPremiumCreaSuiteConTarifaPremium() {
        CabinaFactory factoryPremium = new FactoryOperadorPremium();
        Suite suite = factoryPremium.crearSuite("SUITE-01");
        
        assertNotNull(suite);
        assertEquals("SUITE-01", suite.getId());
        assertEquals(2500.0, suite.getTarifaBase());
        assertTrue(suite.getTarifaBase() > 2000.0);
        assertEquals("Suite", suite.descripcion());
    }

    @Test
    @DisplayName("TC-17: Verificar que la fábrica económica crea la misma familia con tarifas distintas")
    void testFactoryEconomicoCreaSuiteConTarifaEconomica() {
        CabinaFactory factoryEconomico = new FactoryOperadorEconomico();
        Suite suite = factoryEconomico.crearSuite("SUITE-02");
        
        assertNotNull(suite);
        assertEquals("SUITE-02", suite.getId());
        assertEquals(1400.0, suite.getTarifaBase());
        assertTrue(suite.getTarifaBase() < 2000.0);
        assertEquals("Suite", suite.descripcion());
    }

    @Test
    void testCompararTarifasDeAmbasFabrica() {
        CabinaFactory factoryPremium = new FactoryOperadorPremium();
        CabinaFactory factoryEconomico = new FactoryOperadorEconomico();
        
        Suite suitePremium = factoryPremium.crearSuite("SUITE-01");
        Suite suiteEconomico = factoryEconomico.crearSuite("SUITE-02");
        
        assertTrue(suitePremium.getTarifaBase() > suiteEconomico.getTarifaBase());
        assertEquals(suitePremium.descripcion(), suiteEconomico.descripcion());
        assertNotEquals(suitePremium.getTarifaBase(), suiteEconomico.getTarifaBase());
    }
}