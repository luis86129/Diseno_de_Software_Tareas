package com.mycompany.cruisebook_project.factory;

public class FactoryOperadorPremium implements CabinaFactory {
    @Override
    public Suite crearSuite() {
        return new Suite(3000.0, true); 
    }

    @Override
    public CabinaBalcon crearCabinaBalcon() {
        return new CabinaBalcon(1500.0, 20.5); 
    }

    @Override
    public CabinaInterior crearCabinaInterior() {
        return new CabinaInterior(800.0, true); 
    }

    @Override
    public CabinaFamiliar crearCabinaFamiliar() {
        return new CabinaFamiliar(2200.0, 6); 
    }
}