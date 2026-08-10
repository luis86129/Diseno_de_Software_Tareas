package com.mycompany.cruisebook_project.factory;


public class FactoryOperadorEconomico implements CabinaFactory {

    @Override
    public Suite crearSuite(String id) {
        return new Suite(id, 1400.0);
    }

    @Override
    public CabinaBalcon crearCabinaBalcon(String id) {
        return new CabinaBalcon(id, 650.0);
    }

    @Override
    public CabinaInterior crearCabinaInterior(String id) {
        return new CabinaInterior(id, 350.0);
    }

    @Override
    public CabinaFamiliar crearCabinaFamiliar(String id) {
        return new CabinaFamiliar(id, 900.0);
    }
}
