package payment_strategy;

// 'IMetodoPagamentoStrategy' è l'interfaccia Strategy del pattern.
// Definisce un'azione comune, 'paga', che le varie strategie concrete dovranno implementare.
public interface IMetodoPagamentoStrategy {
    boolean paga(double importo);
}
