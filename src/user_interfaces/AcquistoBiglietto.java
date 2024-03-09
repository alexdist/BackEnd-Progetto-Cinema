package user_interfaces;
import payment_strategy.IMetodoPagamentoStrategy;

import ticket.factory.IBiglietto;

public interface AcquistoBiglietto {
    public void acquistaBiglietto(IBiglietto biglietto);
}
