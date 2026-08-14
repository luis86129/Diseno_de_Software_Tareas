/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.cruisebook_project;

import com.mycompany.cruisebook_project.chain.*;
import com.mycompany.cruisebook_project.factory.*;
import com.mycompany.cruisebook_project.strategy.*;
import com.mycompany.cruisebook_project.observer.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Pruebas unitarias para la clase Usuario
 * Casos: TC-01, TC-02, TC-03, TC-04, TC-05, TC-06
 */
public class UsuarioTest {
    
    private Usuario usuario;
    private List<Crucero> catalogo;
    private Cabina cabina;
    private Crucero cruceroCaribe;
    private Crucero cruceroMediterraneo;
    
    @BeforeEach
    void setUp() {
        usuario = new Usuario("USR-01", "Luis", "luis@test.com", "+593999999999");
        
        // Configurar operadores y cruceros
        CabinaFactory factoryPremium = new FactoryOperadorPremium();
        PoliticaCancelacion politicaFlexible = new PoliticaFlexible();
        OperadorCrucero operadorPremium = new OperadorCrucero("OP-01", "Royal Ocean Lines", 
                                                              factoryPremium, politicaFlexible);
        
        cruceroCaribe = new Crucero("CR-01", "Caribe", new Date(), 7, operadorPremium);
        cruceroCaribe.agregarCabina(factoryPremium.crearSuite("SUITE-01"));
        cruceroCaribe.agregarCabina(factoryPremium.crearCabinaBalcon("BAL-01"));
        
        CabinaFactory factoryEconomico = new FactoryOperadorEconomico();
        PoliticaCancelacion politicaEstricta = new PoliticaEstricta();
        OperadorCrucero operadorEconomico = new OperadorCrucero("OP-02", "SeaBudget Cruises", 
                                                               factoryEconomico, politicaEstricta);
        
        cruceroMediterraneo = new Crucero("CR-02", "Mediterraneo", new Date(), 10, operadorEconomico);
        cruceroMediterraneo.agregarCabina(factoryEconomico.crearCabinaInterior("INT-01"));
        cruceroMediterraneo.agregarCabina(factoryEconomico.crearCabinaFamiliar("FAM-01"));
        
        catalogo = new ArrayList<>();
        catalogo.add(cruceroCaribe);
        catalogo.add(cruceroMediterraneo);
        
        cabina = cruceroCaribe.getCabinas().get(0);
    }
    

    @Test
    @DisplayName("TC-01: Verificar filtro por destino funciona correctamente")
    void testBuscarCrucerosPorDestino() {
        List<Crucero> resultado = usuario.buscarCruceros(catalogo, "Caribe");
        
        // Assertions: assertEquals, assertNotNull, assertFalse
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Caribe", resultado.get(0).getDestino());
        assertFalse(resultado.isEmpty());
    }

    @Test
    @DisplayName("TC-02: Caso límite - destino inexistente")
    void testBuscarCrucerosDestinoInexistente() {
        List<Crucero> resultado = usuario.buscarCruceros(catalogo, "Antártida");
        
        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
        assertEquals(0, resultado.size());
    }

    @Test
    @DisplayName("TC-03: Validar búsqueda sin distinción de mayúsculas/minúsculas")
    void testBuscarCrucerosInsensibleMayusculas() {
        List<Crucero> resultado = usuario.buscarCruceros(catalogo, "caribe");
        
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Caribe", resultado.get(0).getDestino());
        assertNotEquals("caribe", resultado.get(0).getDestino()); // Verifica que el destino original mantiene mayúscula
    }

    @Test
    @DisplayName("TC-04: Verificar creación correcta de reserva sobre cabina disponible")
    void testReservarCabinaDisponible() throws Exception {
        Date fechaExpiracion = new Date(System.currentTimeMillis() + 86_400_000);
        Reserva reserva = usuario.reservarCabina(cabina, fechaExpiracion);
        
        assertNotNull(reserva);
        assertEquals(EstadoReserva.TEMPORAL, reserva.getEstado());
        assertEquals(usuario, reserva.getUsuario());
        assertEquals(cabina, reserva.getCabina());
    }

    @Test
    @DisplayName("TC-05: No se debe poder reservar una cabina no disponible")
    void testReservarCabinaNoDisponible() {
        // Primero reservamos la cabina
        Date fechaExpiracion = new Date(System.currentTimeMillis() + 86_400_000);
        cabina.reservar();
        
        // Intentamos reservarla nuevamente - debe lanzar excepción
        assertThrows(IllegalStateException.class, () -> {
            usuario.reservarCabina(cabina, fechaExpiracion);
        });
    }

    @Test
    @DisplayName("TC-06: Verificar que el incidente se registra y se procesa por la cadena")
    void testReportarIncidente() {
        ManejadorIncidente atencionCliente = new AtencionCliente();
        ManejadorIncidente gerencia = new GerenciaCrucero();
        atencionCliente.setSiguiente(gerencia);
        
        Incidente incidente = usuario.reportarIncidente(
            "Problema con la reserva de cabina", 
            TipoIncidente.RESERVA, 
            atencionCliente
        );
        
        assertNotNull(incidente);
        assertTrue(incidente.isResuelto());
        assertEquals(1, usuario.getIncidentes().size());
        assertEquals("Problema con la reserva de cabina", incidente.getDescripcion());
    }
}