package ticket_pricing.strategy;

import ticket_pricing.strategy.IPrezzoStrategy;

public class Context {

    private IPrezzoStrategy strategy;

    public Context(IPrezzoStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(IPrezzoStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.execute();
    }

}
