/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cruisebook_project;

// Importaciones de los diferentes paquetes que creamos
import com.mycompany.cruisebook_project.factory.*;
import com.mycompany.cruisebook_project.decorator.*;
import com.mycompany.cruisebook_project.observer.*;
import com.mycompany.cruisebook_project.strategy.*;
import com.mycompany.cruisebook_project.chain.*;

/**
 *
 * @author User
 */
public class CruiseBook_Project {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("      CRUISEBOOK PROJECT - PRUEBA INTEGRAL        ");
        System.out.println("==================================================\n");

        // ----------------------------------------------------
        // 1. PRUEBA ABSTRACT FACTORY
        // ----------------------------------------------------
        System.out.println("--- 1. PATRÓN ABSTRACT FACTORY ---");
        CabinaFactory factoryPremium = new FactoryOperadorPremium();
        Suite suiteLux = factoryPremium.crearSuite();
        System.out.println("Creado: " + suiteLux.getClass().getSimpleName() + 
                           " | Tarifa: $" + suiteLux.getTarifaBase() + 
                           " | Jacuzzi: " + suiteLux.isTieneJacuzzi());

        CabinaFactory factoryEconomico = new FactoryOperadorEconomico();
        CabinaInterior cabinaInt = factoryEconomico.crearCabinaInterior();
        System.out.println("Creado: " + cabinaInt.getClass().getSimpleName() + 
                           " | Tarifa: $" + cabinaInt.getTarifaBase() + 
                           " | Ventana Virtual: " + cabinaInt.isVentanaVirtual() + "\n");

        // ----------------------------------------------------
        // 2. PRUEBA DECORATOR
        // ----------------------------------------------------
        System.out.println("--- 2. PATRÓN DECORATOR ---");
        // Creamos una reserva auxiliar para el decorador
        com.mycompany.cruisebook_project.decorator.Reserva reservaDummy = new com.mycompany.cruisebook_project.decorator.Reserva();
        ServicioReserva servicio = new ReservaBase(reservaDummy);
        
        // Añadimos extras decorando el servicio
        servicio = new ExcursionTierraDecorator(servicio, 150.0);
        servicio = new PaqueteBebidasDecorator(servicio, 60.0);
        
        System.out.println("Descripción del servicio: " + servicio.getDescripcion());
        System.out.println("Costo Total con Extras: $" + servicio.calcularCosto() + "\n");

        // ----------------------------------------------------
        // 3. PRUEBA OBSERVER
        // ----------------------------------------------------
        System.out.println("--- 3. PATRÓN OBSERVER ---");
        com.mycompany.cruisebook_project.observer.Reserva reservaObs = new com.mycompany.cruisebook_project.observer.Reserva();
        
        // Suscribimos canales de notificación
        reservaObs.suscribir(new NotificadorEmail());
        reservaObs.suscribir(new NotificadorSMS());
        reservaObs.suscribir(new NotificadorAppMensajeria());
        
        System.out.println("Cambiando estado de la reserva a CONFIRMADA...");
        reservaObs.setEstado(EstadoReserva.CONFIRMADA);
        System.out.println();

        // ----------------------------------------------------
        // 4. PRUEBA STRATEGY
        // ----------------------------------------------------
        System.out.println("--- 4. PATRÓN STRATEGY ---");
        PoliticaCancelacion politicaEstricta = new PoliticaEstricta();
        OperadorCrucero operadorStrategy = new OperadorCrucero(politicaEstricta);
        
        System.out.println("Aplicando Política Estricta:");
        operadorStrategy.aplicarPolitica(reservaObs);
        
        // Cambiamos de estrategia en tiempo de ejecución
        operadorStrategy.setPolitica(new PoliticaFlexible());
        System.out.println("\nCambiando a Política Flexible dinámicamente:");
        operadorStrategy.aplicarPolitica(reservaObs);
        System.out.println();

        // ----------------------------------------------------
        // 5. PRUEBA CHAIN OF RESPONSIBILITY
        // ----------------------------------------------------
        System.out.println("--- 5. PATRÓN CHAIN OF RESPONSIBILITY ---");
        ManejadorIncidente atencionCliente = new AtencionCliente();
        ManejadorIncidente gerencia = new GerenciaCrucero();
        
        // Armamos la cadena: Atención al Cliente -> Gerencia
        atencionCliente.setSiguiente(gerencia);
        
        Incidente incidentePago = new Incidente("INC-999", "Error en cobro de tarjeta de crédito", TipoIncidente.PAGO);
        
        System.out.println("Reportando incidente de tipo PAGO (debe escalar a Gerencia):");
        atencionCliente.manejar(incidentePago);
        
        System.out.println("\n==================================================");
        System.out.println("      ¡PRUEBAS EJECUTADAS CON ÉXITO!              ");
        System.out.println("==================================================");
    }
}
