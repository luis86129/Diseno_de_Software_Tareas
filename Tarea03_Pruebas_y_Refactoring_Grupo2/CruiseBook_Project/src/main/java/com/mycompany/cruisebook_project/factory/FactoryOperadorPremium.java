package com.mycompany.cruisebook_project.factory;


public class FactoryOperadorPremium implements CabinaFactory {

    @Override
    public Suite crearSuite(String id) {
        return new Suite(id, 2500.0);
    }

    @Override
    public CabinaBalcon crearCabinaBalcon(String id) {
        return new CabinaBalcon(id, 1200.0);
    }

    @Override
    public CabinaInterior crearCabinaInterior(String id) {
        return new CabinaInterior(id, 700.0);
    }

    @Override
    public CabinaFamiliar crearCabinaFamiliar(String id) {
        return new CabinaFamiliar(id, 1800.0);
    }
}
