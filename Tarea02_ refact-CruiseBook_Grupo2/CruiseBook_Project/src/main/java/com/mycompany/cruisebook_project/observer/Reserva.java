public class Reserva implements SujetoReserva {
    private String estado;
    private List<CanalNotificacion> observadores = new ArrayList<>();

    public String getEstado() {
        return estado;
    }

    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        notificarCambio(); // Notifica automáticamente al cambiar de estado
    }

    @Override
    public void suscribir(CanalNotificacion observador) {
        observadores.add(observador);
    }

    @Override
    public void desuscribir(CanalNotificacion observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarCambio() {
        String mensaje = "El estado de su reserva ha cambiado a: " + estado;
        for (CanalNotificacion observador : observadores) {
            observador.notificar(this, mensaje);
        }
    }
}