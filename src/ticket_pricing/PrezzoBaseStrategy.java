package ticket_pricing;

public class PrezzoBaseStrategy implements IPrezzoStrategy {

    private IPrezziBiglietto prezziBiglietto;

    public PrezzoBaseStrategy(IPrezziBiglietto prezziBiglietto) {
        this.prezziBiglietto = prezziBiglietto;
    }

    @Override
    public void execute() {
        // Qui potresti impostare i prezzi base, oppure lasciarli come sono se i prezzi base sono già impostati
        // Esempio:
         prezziBiglietto.setPrezzoIntero(prezziBiglietto.getPrezzoIntero());
         prezziBiglietto.setPrezzoRidotto(prezziBiglietto.getPrezzoRidotto());
    }
}
