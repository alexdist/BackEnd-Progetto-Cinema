package payment_strategy;

public class PayContext {

    private IMetodoPagamentoStrategy metodoPagamentoStrategy;

    public PayContext(IMetodoPagamentoStrategy metodoPagamentoStrategy) {
        this.metodoPagamentoStrategy = metodoPagamentoStrategy;
    }

    public boolean eseguiPagamento(double importo) {
        return metodoPagamentoStrategy.paga(importo);
    }
}
