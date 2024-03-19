package ticket_pricing.strategy;

import ticket_pricing.IPrezziBiglietto;
import ticket_pricing.PrezziBiglietto;
import ticket_pricing.strategy.IPrezzoStrategy;

public class PrezzoWeekEndStrategy implements IPrezzoStrategy {

    private IPrezziBiglietto prezziBiglietto;
    private double aumentoPercentuale;

    public PrezzoWeekEndStrategy(IPrezziBiglietto prezziBiglietto, double aumentoPercentuale) {
        this.prezziBiglietto = prezziBiglietto;
        this.aumentoPercentuale = aumentoPercentuale;
    }

    public PrezzoWeekEndStrategy(IPrezziBiglietto prezziBiglietto) {
        this.prezziBiglietto = prezziBiglietto;
        this.aumentoPercentuale = prezziBiglietto.getSovrapprezzo();
    }

    @Override
    public void execute() {
        // Applica un aumento percentuale ai prezzi per il weekend
        double nuovoPrezzoIntero = prezziBiglietto.getPrezzoIntero() * (1 + aumentoPercentuale);
        double nuovoPrezzoRidotto = prezziBiglietto.getPrezzoRidotto() * (1 + aumentoPercentuale);

        prezziBiglietto.setPrezzoIntero(nuovoPrezzoIntero);
        prezziBiglietto.setPrezzoRidotto(nuovoPrezzoRidotto);
    }
}
