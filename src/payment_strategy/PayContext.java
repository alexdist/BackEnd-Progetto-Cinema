package payment_strategy;

import java.io.Serializable;

// 'PayContext' è la classe Context nel pattern Strategy.
// Mantiene un riferimento a una strategia di pagamento che può variare a runtime.
public class PayContext implements Serializable {

    private IMetodoPagamentoStrategy metodoPagamentoStrategy;

    public PayContext(IMetodoPagamentoStrategy metodoPagamentoStrategy) {
        this.metodoPagamentoStrategy = metodoPagamentoStrategy;
    }

    public boolean eseguiPagamento(double importo) {
        return metodoPagamentoStrategy.paga(importo);
    }
}
