package payment_strategy;


import exception.PagamentoFallitoException;

// Concrete Strategy 2
public class PagamentoCartaDiCreditoStrategy implements IMetodoPagamentoStrategy {
    @Override
    public boolean paga(double importo) {
        System.out.println("Pagamento di " + importo + " € effettuato con carta di credito.");
        return true;
    }
}