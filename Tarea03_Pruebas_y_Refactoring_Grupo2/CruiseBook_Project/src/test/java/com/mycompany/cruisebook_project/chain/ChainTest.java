package com.mycompany.cruisebook_project.chain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mycompany.cruisebook_project.chain.AtencionCliente;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Pruebas unitarias para la cadena de responsabilidad")
public class ChainTest {
    
    private ManejadorIncidente atencionCliente;
    private ManejadorIncidente gerencia;
    
    @BeforeEach
    void setUp() {
        atencionCliente = new AtencionCliente();
        gerencia = new GerenciaCrucero();
        atencionCliente.setSiguiente(gerencia);
    }
    
    @DisplayName("TC-31: Verificar cambio de estado del incidente")
    @Test
    void testMarcarIncidenteResuelto() {
        Incidente incidente = new Incidente("INC-001", "Problema de reserva", TipoIncidente.RESERVA);
        
        assertFalse(incidente.isResuelto());
        
        incidente.marcarResuelto();
        
        assertTrue(incidente.isResuelto());
    }
    
    @Test
    @DisplayName("TC-32: Verificar resolución en primer nivel para tipos manejables")
    void testAtencionClienteResuelveIncidenteReserva() {
        Incidente incidente = new Incidente("INC-001", "Problema de reserva", TipoIncidente.RESERVA);
        
        atencionCliente.manejar(incidente);
        
        assertTrue(incidente.isResuelto());
    }
    
    
    @Test
    @DisplayName("TC-33: Verificar el escalamiento correcto en la cadena")
    void testEscalamientoAGerencia() {
        Incidente incidente = new Incidente("INC-002", "Cobro duplicado", TipoIncidente.PAGO);
        
        atencionCliente.manejar(incidente);
        
        assertTrue(incidente.isResuelto());
        // El incidente fue resuelto por gerencia
    }
    
    
    @Test
    @DisplayName("TC-34: Caso límite - cadena incompleta, incidente no resuelto")
    void testCadenaIncompletaIncidenteNoResuelto() {
        ManejadorIncidente soloAtencion = new AtencionCliente();
        // No se configura siguiente
        
        Incidente incidente = new Incidente("INC-003", "Problema de pago", TipoIncidente.PAGO);
        
        soloAtencion.manejar(incidente);
        
        // Aunque el incidente no se resuelva, la lógica de AtencionCliente no lo marca como resuelto
        // En el caso de PAGO, no lo resuelve y lo pasa al siguiente, pero si no hay siguiente...
        assertFalse(incidente.isResuelto());
    }
    
    
    @Test
    @DisplayName("TC-35: Verificar que el último eslabón resuelve cualquier incidente")
    void testGerenciaResuelveCualquierIncidente() {
        // Crear incidentes de diferentes tipos
        Incidente incidenteReserva = new Incidente("INC-004", "Reserva incorrecta", TipoIncidente.RESERVA);
        Incidente incidentePago = new Incidente("INC-005", "Pago rechazado", TipoIncidente.PAGO);
        Incidente incidenteServicio = new Incidente("INC-006", "Servicio malo", TipoIncidente.SERVICIO_ABORDO);
        
        // Probar que gerencia resuelve todos
        gerencia.manejar(incidenteReserva);
        assertTrue(incidenteReserva.isResuelto());
        
        gerencia.manejar(incidentePago);
        assertTrue(incidentePago.isResuelto());
        
        gerencia.manejar(incidenteServicio);
        assertTrue(incidenteServicio.isResuelto());
    }
}

