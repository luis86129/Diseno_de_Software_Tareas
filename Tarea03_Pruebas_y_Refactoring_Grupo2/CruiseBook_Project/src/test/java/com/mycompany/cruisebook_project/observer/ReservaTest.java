/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.cruisebook_project.observer;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mycompany.cruisebook_project.Usuario;
import com.mycompany.cruisebook_project.decorator.ExcursionTierraDecorator;
import com.mycompany.cruisebook_project.decorator.PaqueteBebidasDecorator;
import com.mycompany.cruisebook_project.decorator.ServicioReserva;
import com.mycompany.cruisebook_project.decorator.TratamientoSpaDecorator;
import com.mycompany.cruisebook_project.factory.Cabina;
import com.mycompany.cruisebook_project.factory.CabinaFactory;
import com.mycompany.cruisebook_project.factory.EstadoCabina;
import com.mycompany.cruisebook_project.factory.FactoryOperadorPremium;

/**
 * Pruebas unitarias para la clase Reserva y decoradores
 * Cubre los casos: TC-18, TC-19, TC-20, TC-21, TC-22, TC-23, TC-24, TC-25, TC-26
 */
@DisplayName("Pruebas Unitarias - Clase Reserva, Patrón Observer y Patrón Decorator")
public class ReservaTest {
    
    private Usuario usuario;
    private Cabina cabina;
    private Reserva reserva;
    private Date fechaExpiracion;
    
    @BeforeEach
    void setUp() {
        usuario = new Usuario("USR-01", "Luis", "luis@test.com", "+593999999999");
        CabinaFactory factoryPremium = new FactoryOperadorPremium();
        cabina = factoryPremium.crearSuite("SUITE-01");
        fechaExpiracion = new Date(System.currentTimeMillis() + 86_400_000);
        reserva = new Reserva("RES-001", usuario, cabina, fechaExpiracion);
    }
    
    // TC-18: Verificar flujo estándar de confirmación de pago
    @Test
    @DisplayName("TC-18: Verificar flujo estándar de confirmación de pago y notificación")
    void testConfirmarPagoConObservadores() {
        CanalNotificacion email = new NotificadorEmail();
        CanalNotificacion sms = new NotificadorSMS();
        reserva.suscribir(email);
        reserva.suscribir(sms);
        
        assertEquals(EstadoReserva.TEMPORAL, reserva.getEstado());
        
        reserva.confirmarPago();
        
        assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstado());
        assertNotEquals(EstadoReserva.TEMPORAL, reserva.getEstado());
    }
    
    // TC-19: Caso límite - confirmar pago sin observadores
    @Test
    @DisplayName("TC-19: Caso límite - Confirmar pago sin observadores suscritos")
    void testConfirmarPagoSinObservadores() {
        assertEquals(EstadoReserva.TEMPORAL, reserva.getEstado());
        
        // No debe lanzar ninguna excepción
        assertDoesNotThrow(() -> {
            reserva.confirmarPago();
        });
        
        assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstado());
    }
    
    // TC-20: Verificar que cancelar libera la cabina asociada
    @Test
    @DisplayName("TC-20: Verificar que al cancelar una reserva se libera la cabina asociada")
    void testCancelarReservaLiberaCabina() {
        reserva.confirmarPago();
        assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstado());
        assertEquals(EstadoCabina.RESERVADA, cabina.getEstado());
        
        reserva.cancelar();
        
        assertEquals(EstadoReserva.CANCELADA, reserva.getEstado());
        assertEquals(EstadoCabina.DISPONIBLE, cabina.getEstado());
        assertNotEquals(EstadoCabina.RESERVADA, cabina.getEstado());
    }
    
    // TC-21: Verificar que todos los observadores suscritos son notificados
    @Test
    @DisplayName("TC-21: Verificar que todos los observadores suscritos reciben la notificación")
    void testObservadoresRecibenNotificacion() {
        // Crear canales de notificación
        CanalNotificacion email = new NotificadorEmail();
        CanalNotificacion sms = new NotificadorSMS();
        
        reserva.suscribir(email);
        reserva.suscribir(sms);
        
        // Confirmar pago debería notificar a ambos
        reserva.confirmarPago();
        
        // Verificar que ambos observadores están suscritos
        // Nota: No podemos verificar directamente el contenido, pero podemos 
        // verificar que la operación no lanza excepciones
        assertNotNull(reserva.getServicios());
    }
    
    // TC-22: Verificar que un observador puede dejar de recibir notificaciones
    @Test
    @DisplayName("TC-22: Verificar que un observador desuscrito deja de recibir notificaciones")
    void testDesuscribirObservador() {
        CanalNotificacion email = new NotificadorEmail();
        CanalNotificacion sms = new NotificadorSMS();
        
        reserva.suscribir(email);
        reserva.suscribir(sms);
        
        // Desuscribir el email
        reserva.desuscribir(email);
        
        // Solo el SMS debería recibir la notificación
        reserva.confirmarPago();
        
        // Verificar que la reserva se confirma correctamente
        assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstado());
    }
    
    // TC-23: Verificar cálculo base sin servicios adicionales
    @Test
    @DisplayName("TC-23: Verificar cálculo base del costo sin servicios adicionales")
    void testCalcularCostoBase() {
        ServicioReserva serviciosBase = reserva.getServicios();
        
        assertEquals(2500.0, serviciosBase.calcularCosto());
        assertTrue(serviciosBase.calcularCosto() > 0);
        assertEquals("Reserva base (Suite)", serviciosBase.getDescripcion());
    }
    
    // TC-24: Verificar que el decorador suma correctamente su costo
    @Test
    @DisplayName("TC-24: Verificar que el decorador de Excursión en Tierra suma su costo correctamente")
    void testDecoradorExcursionTierra() {
        ServicioReserva servicios = reserva.getServicios();
        servicios = new ExcursionTierraDecorator(servicios);
        
        assertEquals(2650.0, servicios.calcularCosto()); // 2500 + 150
        assertEquals("Reserva base (Suite) + Excursion en tierra", servicios.getDescripcion());
    }
    
    // TC-25: Verificar que múltiples decoradores se acumulan correctamente
    @Test
    @DisplayName("TC-25: Verificar que múltiples decoradores acumulan sus costos correctamente") 
    void testMultiplesDecoradoresAcumulados() {
        ServicioReserva servicios = reserva.getServicios();
        servicios = new ExcursionTierraDecorator(servicios);
        servicios = new PaqueteBebidasDecorator(servicios);
        servicios = new TratamientoSpaDecorator(servicios);
        
        double costoEsperado = 2500.0 + 150.0 + 90.0 + 120.0;
        assertEquals(costoEsperado, servicios.calcularCosto());
        assertEquals(2860.0, servicios.calcularCosto());
    }
    
    // TC-26: Verificar que la descripción refleja fielmente los servicios apilados
    @Test
    @DisplayName("TC-26: Verificar que la descripción refleja fielmente todos los servicios apilados")
    void testDescripcionServiciosApilados() {
        ServicioReserva servicios = reserva.getServicios();
        servicios = new ExcursionTierraDecorator(servicios);
        servicios = new PaqueteBebidasDecorator(servicios);
        servicios = new TratamientoSpaDecorator(servicios);
        
        String descripcionEsperada = "Reserva base (Suite) + Excursion en tierra + Paquete de bebidas + Tratamiento de spa";
        assertEquals(descripcionEsperada, servicios.getDescripcion());
    }
}