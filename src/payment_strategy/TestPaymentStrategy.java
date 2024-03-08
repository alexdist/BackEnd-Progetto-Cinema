package payment_strategy;

public class TestPaymentStrategy {

    public static void main(String[] args) {
        // Crea un contesto di pagamento utilizzando la strategia di pagamento con bancomat
        PayContext pagamentoConBancomat = new PayContext(new PagamentoBancomatStrategy());
        System.out.println("Tentativo di pagamento con bancomat:");
        pagamentoConBancomat.eseguiPagamento(100.0);

        // Crea un contesto di pagamento utilizzando la strategia di pagamento in contanti
        PayContext pagamentoInContanti = new PayContext(new PagamentoContantiStrategy());
        System.out.println("\nTentativo di pagamento in contanti:");
        pagamentoInContanti.eseguiPagamento(50.0);

        // Crea un contesto di pagamento utilizzando la strategia di pagamento con carta di credito
        PayContext pagamentoConCartaDiCredito = new PayContext(new PagamentoCartaDiCreditoStrategy());
        System.out.println("\nTentativo di pagamento con carta di credito:");
        pagamentoConCartaDiCredito.eseguiPagamento(150.0);
    }
}
