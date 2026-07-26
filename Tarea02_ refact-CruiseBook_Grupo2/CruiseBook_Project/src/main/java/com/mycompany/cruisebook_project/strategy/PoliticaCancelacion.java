public interface PoliticaCancelacion {
    double calcularReembolso(Reserva reserva);
    boolean permiteReprogramacion();
}