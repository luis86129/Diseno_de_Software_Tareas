public class NotificadorEmail implements CanalNotificacion {
    @Override
    public void notificar(Reserva reserva, String mensaje) {
        System.out.println("[EMAIL] Enviando correo: " + mensaje);
    }
}

public class NotificadorSMS implements CanalNotificacion {
    @Override
    public void notificar(Reserva reserva, String mensaje) {
        System.out.println("[SMS] Enviando mensaje de texto: " + mensaje);
    }
}

public class NotificadorAppMensajeria implements CanalNotificacion {
    @Override
    public void notificar(Reserva reserva, String mensaje) {
        System.out.println("[APP] Notificación Push: " + mensaje);
    }
}