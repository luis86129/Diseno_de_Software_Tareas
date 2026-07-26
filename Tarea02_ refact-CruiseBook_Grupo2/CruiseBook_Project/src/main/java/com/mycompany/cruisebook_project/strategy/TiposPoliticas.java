// Estrategia Flexible (Reembolso completo)
public class PoliticaFlexible implements PoliticaCancelacion {
    @Override
    public double calcularReembolso(Reserva reserva) {
        return 100.0; // Devuelve el 100%
    }

    @Override
    public boolean permiteReprogramacion() {
        return true;
    }
}

// Estrategia Estricta (Reembolso parcial)
public class PoliticaEstricta implements PoliticaCancelacion {
    @Override
    public double calcularReembolso(Reserva reserva) {
        return 50.0; // Devuelve el 50%
    }

    @Override
    public boolean permiteReprogramacion() {
        return false;
    }
}

// Estrategia No Reembolsable
public class PoliticaNoReembolsable implements PoliticaCancelacion {
    @Override
    public double calcularReembolso(Reserva reserva) {
        return 0.0; // Sin devolución
    }

    @Override
    public boolean permiteReprogramacion() {
        return false;
    }
}