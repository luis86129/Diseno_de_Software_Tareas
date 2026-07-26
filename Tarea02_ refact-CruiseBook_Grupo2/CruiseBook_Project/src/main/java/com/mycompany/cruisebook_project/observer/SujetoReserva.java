import java.util.ArrayList;
import java.util.List;

// Interfaz del Sujeto (Observable)
public interface SujetoReserva {
    void suscribir(CanalNotificacion observador);
    void desuscribir(CanalNotificacion observador);
    void notificarCambio();
}

// Interfaz del Observador
public interface CanalNotificacion {
    void notificar(Reserva reserva, String mensaje);
}