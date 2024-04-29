package payment_strategy;


import exception.PagamentoFallitoException;

import java.io.Serializable;

// Concrete Strategy 2
// 'PagamentoCartaDiCreditoStrategy' è un'altra ConcreteStrategy.
// Implementa l'operazione di pagamento utilizzando una carta di credito.
public class PagamentoCartaDiCreditoStrategy implements IMetodoPagamentoStrategy, Serializable {
    @Override
    public boolean paga(double importo) {
        System.out.println("Pagamento di " + importo + " € effettuato con carta di credito.");
        return true;
    }
}