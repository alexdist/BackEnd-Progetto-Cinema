package user_interfaces;
import payment_strategy.IPagamentoStrategy;
import ticket.Biglietto;

public interface AcquistoBiglietto {
    void acquistaBiglietto(Biglietto biglietto, IPagamentoStrategy metodoPagamento);
}
