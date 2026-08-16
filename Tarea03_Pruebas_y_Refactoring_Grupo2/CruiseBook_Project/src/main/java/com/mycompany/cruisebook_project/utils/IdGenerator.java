package com.mycompany.cruisebook_project.utils;

public class IdGenerator {
    public static String generar(String prefijo) {

        return prefijo + "-" + System.currentTimeMillis();

    }
}
