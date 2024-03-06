//package payment_strategy;
//
//
//import exception.PagamentoFallitoException;
//
//public class PagamentoBancomatStrategy implements IPagamentoStrategy {
//    @Override
//    public void paga(double importo) throws PagamentoFallitoException {
//        // Simula una condizione di fallimento
//        if (importo > 1000) { // Esempio: limite di pagamento per bancomat
//            throw new PagamentoFallitoException("Pagamento con bancomat fallito per importo superiore al limite.");
//        }
//        System.out.println("Pagamento di " + importo + " euro con bancomat effettuato con successo.");
//    }
//}