package payment_strategy;


import exception.PagamentoFallitoException;

// Concrete Strategy 3
public class PagamentoBancomatStrategy implements IMetodoPagamentoStrategy {
    @Override
    public boolean paga(double importo) {
        System.out.println("Pagamento di " + importo + " € effettuato con bancomat.");
        return true;
    }
}