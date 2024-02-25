package payment_strategy;



//public interface IPagamentoStrategy {
//    void paga(double importo);
//}

import exception.PagamentoFallitoException;

public interface IPagamentoStrategy {
    void paga(double importo) throws PagamentoFallitoException;
}