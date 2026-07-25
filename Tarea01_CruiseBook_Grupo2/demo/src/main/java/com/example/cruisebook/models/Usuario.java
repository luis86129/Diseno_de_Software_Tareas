package com.example.cruisebook.models;
import com.example.cruisebook.models.Enums.CanalNotificacion;

public class Usuario {
    private CanalNotificacion canalPreferido;
    private boolean autenticado;

    public CanalNotificacion obtenerCanalPreferido() { return this.canalPreferido; }
    public boolean isAutenticado() { return this.autenticado; }
}