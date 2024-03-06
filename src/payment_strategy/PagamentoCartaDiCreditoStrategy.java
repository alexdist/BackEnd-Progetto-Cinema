//package payment_strategy;
//
//
//import exception.PagamentoFallitoException;
//
//public class PagamentoCartaDiCreditoStrategy implements IPagamentoStrategy {
//    @Override
//    public void paga(double importo) throws PagamentoFallitoException {
//        // Simula una condizione di fallimento
//        if (importo <= 0) {
//            throw new PagamentoFallitoException("Pagamento con carta di credito fallito: importo non valido.");
//        }
//        System.out.println("Pagamento di " + importo + " euro con carta di credito effettuato con successo.");
//    }
//}