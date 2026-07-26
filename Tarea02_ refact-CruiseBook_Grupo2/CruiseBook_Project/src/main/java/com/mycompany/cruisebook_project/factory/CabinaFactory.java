package com.mycompany.cruisebook_project.factory;

public interface CabinaFactory {
    Suite crearSuite();
    CabinaBalcon crearCabinaBalcon();
    CabinaInterior crearCabinaInterior();
    CabinaFamiliar crearCabinaFamiliar();
}