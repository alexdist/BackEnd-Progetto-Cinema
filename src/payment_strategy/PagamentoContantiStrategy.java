package payment_strategy;

import exception.PagamentoFallitoException;

import java.io.Serializable;

// Concrete Strategy 1
public class PagamentoContantiStrategy implements IMetodoPagamentoStrategy, Serializable {
    @Override
    public boolean paga(double importo) {
        System.out.println("Pagamento di " + importo + " € effettuato in contanti.");
        return true;
    }
}