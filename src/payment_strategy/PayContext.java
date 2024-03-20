package payment_strategy;

import java.io.Serializable;

public class PayContext implements Serializable {

    private IMetodoPagamentoStrategy metodoPagamentoStrategy;

    public PayContext(IMetodoPagamentoStrategy metodoPagamentoStrategy) {
        this.metodoPagamentoStrategy = metodoPagamentoStrategy;
    }

    public boolean eseguiPagamento(double importo) {
        return metodoPagamentoStrategy.paga(importo);
    }
}
