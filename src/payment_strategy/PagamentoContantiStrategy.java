package payment_strategy;

//public class PagamentoContantiStrategy implements IPagamentoStrategy {
//    @Override
//    public void paga(double importo) {
//        System.out.println("Pagamento di " + importo + " euro in contanti effettuato con successo.");
//    }
//}


import exception.PagamentoFallitoException;

public class PagamentoContantiStrategy implements IPagamentoStrategy {
    @Override
    public void paga(double importo) throws PagamentoFallitoException {
        // Simula una condizione di fallimento
        if (importo > 500) { // Esempio: limite di sicurezza per pagamenti in contanti
            throw new PagamentoFallitoException("Pagamento in contanti fallito per importo eccessivo.");
        }
        System.out.println("Pagamento di " + importo + " euro in contanti effettuato con successo.");
    }
}