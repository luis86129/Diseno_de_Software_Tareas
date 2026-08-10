package com.mycompany.cruisebook_project.factory;


public interface CabinaFactory {
    Suite crearSuite(String id);
    CabinaBalcon crearCabinaBalcon(String id);
    CabinaInterior crearCabinaInterior(String id);
    CabinaFamiliar crearCabinaFamiliar(String id);
}
