package payment_strategy;


import exception.PagamentoFallitoException;

import java.io.Serializable;

// Concrete Strategy 2
public class PagamentoCartaDiCreditoStrategy implements IMetodoPagamentoStrategy, Serializable {
    @Override
    public boolean paga(double importo) {
        System.out.println("Pagamento di " + importo + " € effettuato con carta di credito.");
        return true;
    }
}