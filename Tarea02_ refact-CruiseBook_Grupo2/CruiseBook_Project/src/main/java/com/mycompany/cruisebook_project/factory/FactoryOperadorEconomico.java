package com.mycompany.cruisebook_project.factory;

public class FactoryOperadorEconomico implements CabinaFactory {
    @Override
    public Suite crearSuite() {
        return new Suite(1200.0, false); 
    }

    @Override
    public CabinaBalcon crearCabinaBalcon() {
        return new CabinaBalcon(750.0, 5.0); 
    }

    @Override
    public CabinaInterior crearCabinaInterior() {
        return new CabinaInterior(400.0, false); 
    }

    @Override
    public CabinaFamiliar crearCabinaFamiliar() {
        return new CabinaFamiliar(1000.0, 4); 
    }
}