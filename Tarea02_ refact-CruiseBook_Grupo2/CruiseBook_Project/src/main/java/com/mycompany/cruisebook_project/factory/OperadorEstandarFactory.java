package com.mycompany.cruisebook_project.factory;

public class OperadorEstandarFactory implements OperadorCruceroFactory {
    @Override
    public CabinaSuite crearSuite() { 
        System.out.println("Fabricando una Suite Estándar...");
        return new SuiteEstandar(); 
    }
    
    @Override
    public CabinaBalcon crearCabinaBalcon() { 
        System.out.println("Fabricando una Cabina con Balcón Estándar...");
        return new BalconEstandar(); 
    }
}