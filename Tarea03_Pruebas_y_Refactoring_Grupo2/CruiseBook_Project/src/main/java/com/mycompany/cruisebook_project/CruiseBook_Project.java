/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cruisebook_project;

/**
 *
 * @author grupo 2
 */

import com.mycompany.cruisebook_project.chain.*;
import com.mycompany.cruisebook_project.decorator.*;
import com.mycompany.cruisebook_project.factory.*;
import com.mycompany.cruisebook_project.observer.*;
import com.mycompany.cruisebook_project.strategy.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CruiseBook_Project {

    public static void main(String[] args) {

        System.out.println("========== 1. ABSTRACT FACTORY: creacion de operadores y cabinas ==========");
        CabinaFactory factoryPremium = new FactoryOperadorPremium();
        PoliticaCancelacion politicaFlexible = new PoliticaFlexible();
        OperadorCrucero operadorPremium = new OperadorCrucero("OP-01", "Royal Ocean Lines", factoryPremium, politicaFlexible);

        CabinaFactory factoryEconomico = new FactoryOperadorEconomico();
        PoliticaCancelacion politicaEstricta = new PoliticaEstricta();
        OperadorCrucero operadorEconomico = new OperadorCrucero("OP-02", "SeaBudget Cruises", factoryEconomico, politicaEstricta);

        Crucero cruceroCaribe = new Crucero("CR-01", "Caribe", new Date(), 7, operadorPremium);
        cruceroCaribe.agregarCabina(operadorPremium.getFactory().crearSuite("SUITE-01"));
        cruceroCaribe.agregarCabina(operadorPremium.getFactory().crearCabinaBalcon("BAL-01"));

        Crucero cruceroMediterraneo = new Crucero("CR-02", "Mediterraneo", new Date(), 10, operadorEconomico);
        cruceroMediterraneo.agregarCabina(operadorEconomico.getFactory().crearCabinaInterior("INT-01"));
        cruceroMediterraneo.agregarCabina(operadorEconomico.getFactory().crearCabinaFamiliar("FAM-01"));

        List<Crucero> catalogo = new ArrayList<>();
        catalogo.add(cruceroCaribe);
        catalogo.add(cruceroMediterraneo);

        System.out.println("\n========== 2. Busqueda y reserva de cabina ==========");
        Usuario luis = new Usuario("USR-01", "Luis", "luis@example.com", "+593999999999");
        luis.buscarCruceros(catalogo, "Caribe");

        Cabina suiteDisponible = cruceroCaribe.buscarCabinasDisponibles().get(0);
        Reserva reserva = luis.reservarCabina(suiteDisponible, new Date(System.currentTimeMillis() + 86_400_000));

        System.out.println("\n========== 3. OBSERVER: suscripcion a canales de notificacion ==========");
        reserva.suscribir(new NotificadorEmail());
        reserva.suscribir(new NotificadorSMS());

        System.out.println("\n========== 4. DECORATOR: personalizacion de servicios adicionales ==========");
        ServicioReserva servicios = reserva.getServicios();
        servicios = new ExcursionTierraDecorator(servicios);
        servicios = new PaqueteBebidasDecorator(servicios);
        servicios = new TratamientoSpaDecorator(servicios);
        reserva.agregarServicio(servicios);
        System.out.println("[Main] Detalle de servicios: " + servicios.getDescripcion());
        System.out.println("[Main] Costo total con servicios: " + servicios.calcularCosto());

        System.out.println("\n========== 5. Confirmacion de pago (dispara Observer) ==========");
        reserva.confirmarPago();

        System.out.println("\n========== 6. STRATEGY: cancelacion segun politica del operador ==========");
        double reembolso = operadorPremium.getPoliticaCancelacion().calcularReembolso(reserva);
        System.out.println("[Main] Reembolso calculado segun politica de " + operadorPremium.getNombre() + ": " + reembolso);
        reserva.cancelar();

        System.out.println("\n========== 7. CHAIN OF RESPONSIBILITY: manejo de incidentes ==========");
        ManejadorIncidente atencionCliente = new AtencionCliente();
        ManejadorIncidente gerencia = new GerenciaCrucero();
        atencionCliente.setSiguiente(gerencia);

        System.out.println("--- Incidente resoluble en primer nivel ---");
        luis.reportarIncidente("Problema con la reserva de cabina", TipoIncidente.RESERVA, atencionCliente);

        System.out.println("--- Incidente que se escala a gerencia ---");
        luis.reportarIncidente("Cobro duplicado en la tarjeta", TipoIncidente.PAGO, atencionCliente);
    }
}
