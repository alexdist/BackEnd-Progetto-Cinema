package payment_strategy;


import exception.PagamentoFallitoException;

import java.io.Serializable;

// Concrete Strategy 3
// 'PagamentoBancomatStrategy' è una ConcreteStrategy nel pattern Strategy.
// Implementa l'operazione di pagamento tramite bancomat.
public class PagamentoBancomatStrategy implements IMetodoPagamentoStrategy, Serializable {
    @Override
    public boolean paga(double importo) {
        System.out.println("Pagamento di " + importo + " € effettuato con bancomat.");
        return true;
    }
}