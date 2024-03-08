package payment_strategy;

import exception.PagamentoFallitoException;

// Concrete Strategy 1
public class PagamentoContantiStrategy implements IMetodoPagamentoStrategy {
    @Override
    public boolean paga(double importo) {
        System.out.println("Pagamento di " + importo + " € effettuato in contanti.");
        return true;
    }
}