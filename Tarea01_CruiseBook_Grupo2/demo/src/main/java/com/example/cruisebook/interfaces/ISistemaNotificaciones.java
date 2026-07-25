package com.example.cruisebook.interfaces;
import com.example.cruisebook.models.Enums.CanalNotificacion;

public interface ISistemaNotificaciones {
    void enviarConfirmacion(CanalNotificacion canal, String mensaje);
}