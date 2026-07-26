package com.mycompany.cruisebook_project.models;

import com.mycompany.cruisebook_project.models.Enums.CanalNotificacion;

public class Usuario {
    private String nombre;
    private CanalNotificacion canalPreferido;
    private boolean autenticado;

    public Usuario(String nombre, CanalNotificacion canalPreferido) {
        this.nombre = nombre;
        this.canalPreferido = canalPreferido;
        this.autenticado = true;
    }

    public CanalNotificacion obtenerCanalPreferido() { return this.canalPreferido; }
    public boolean isAutenticado() { return this.autenticado; }
    public String getNombre() { return this.nombre; }
}
