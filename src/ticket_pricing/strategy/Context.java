package ticket_pricing.strategy;

import ticket_pricing.strategy.IPrezzoStrategy;

// Context class che utilizza il pattern Strategy per gestire diverse strategie di prezzo.
public class Context {

    // Riferimento a un oggetto strategy di tipo IPrezzoStrategy.
    private IPrezzoStrategy strategy;

    // Costruttore che inizializza il contesto con una specifica strategia.
    public Context(IPrezzoStrategy strategy) {
        this.strategy = strategy;
    }

    // Metodo per cambiare la strategia a runtime.
    public void setStrategy(IPrezzoStrategy strategy) {
        this.strategy = strategy;
    }

    // Metodo che esegue l'algoritmo della strategia corrente.
    public void executeStrategy() {
        strategy.execute();
    }

}
