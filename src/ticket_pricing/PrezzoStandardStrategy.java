package ticket_pricing;

import cinema_Infrastructure.Spettacolo;

public class PrezzoStandardStrategy extends AbstractPrezzoStrategy {

    public PrezzoStandardStrategy() {
        super(); // Utilizza il costruttore di AbstractPrezzoStrategy che recupera i prezzi dal Singleton
    }

    @Override
    public double calcolaPrezzo(Spettacolo spettacolo, String tipoBiglietto, PrezziBiglietto prezziCorrenti) {
        return tipoBiglietto.equalsIgnoreCase("intero") ? prezziCorrenti.getPrezzoIntero() : prezziCorrenti.getPrezzoRidotto();
    }
}
