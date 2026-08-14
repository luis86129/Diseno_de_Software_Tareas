/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

package com.mycompany.cruisebook_project.factory;

import com.mycompany.cruisebook_project.strategy.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * Pruebas unitarias para la clase OperadorCrucero
 * Cubre los casos: TC-10, TC-11
*/

public class OperadorCruceroTest {
    
    private OperadorCrucero operadorPremium;
    private OperadorCrucero operadorEconomico;
    private PoliticaCancelacion politicaFlexible;
    private PoliticaCancelacion politicaEstricta;
    
    @BeforeEach
    void setUp() {
        politicaFlexible = new PoliticaFlexible();
        politicaEstricta = new PoliticaEstricta();
        
        operadorPremium = new OperadorCrucero(
            "OP-01", 
            "Royal Ocean Lines", 
            new FactoryOperadorPremium(), 
            politicaFlexible
        );
        
        operadorEconomico = new OperadorCrucero(
            "OP-02", 
            "SeaBudget Cruises", 
            new FactoryOperadorEconomico(), 
            politicaEstricta
        );
    }

    @Test
    @DisplayName("TC-10: Confirmar que el operador delega en la fábrica correcta (Abstract Factory)")
    void testGetFactoryRetornaInstanciaCorrecta() {
        // Verificar que el operador premium retorna FactoryOperadorPremium
        CabinaFactory factoryPremium = operadorPremium.getFactory();
        assertNotNull(factoryPremium);
        assertTrue(factoryPremium instanceof FactoryOperadorPremium);
        assertTrue(factoryPremium instanceof CabinaFactory);
        
        // Verificar que el operador económico retorna FactoryOperadorEconomico
        CabinaFactory factoryEconomico = operadorEconomico.getFactory();
        assertNotNull(factoryEconomico);
        assertTrue(factoryEconomico instanceof FactoryOperadorEconomico);
        assertTrue(factoryEconomico instanceof CabinaFactory);
        
        // Verificar que las fábricas son diferentes
        assertNotEquals(factoryPremium.getClass(), factoryEconomico.getClass());
    }

    @Test
    @DisplayName("TC-11: Verificar que la política puede reconfigurarse en tiempo de ejecución (Strategy)")
    void testSetPoliticaCancelacionCambiaPolitica() {
        // Verificar política inicial
        PoliticaCancelacion politicaInicial = operadorPremium.getPoliticaCancelacion();
        assertNotNull(politicaInicial);
        assertTrue(politicaInicial instanceof PoliticaFlexible);
        assertTrue(politicaInicial.permiteReprogramacion());
        
        // Cambiar a política estricta
        operadorPremium.setPoliticaCancelacion(politicaEstricta);
        
        // Verificar que la política cambió
        PoliticaCancelacion politicaNueva = operadorPremium.getPoliticaCancelacion();
        assertNotNull(politicaNueva);
        assertTrue(politicaNueva instanceof PoliticaEstricta);
        assertFalse(politicaNueva.permiteReprogramacion());
        
        // Verificar que no es la misma instancia que antes
        assertNotSame(politicaInicial, politicaNueva);
        assertNotEquals(politicaInicial.getClass(), politicaNueva.getClass());
    }
}