package com.mycompany.cruisebook_project.factory;

public class OperadorPremiumFactory implements OperadorCruceroFactory {
    @Override
    public CabinaSuite crearSuite() { 
        System.out.println("Fabricando una Suite Premium...");
        return new SuitePremium(); 
    }
    
    @Override
    public CabinaBalcon crearCabinaBalcon() { 
        System.out.println("Fabricando una Cabina con Balcón Premium...");
        return new BalconPremium(); 
    }
}
