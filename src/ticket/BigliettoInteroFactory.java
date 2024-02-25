package ticket;

import cinema_Infrastructure.Spettacolo;
import domain.Utente;

public class BigliettoInteroFactory extends BigliettoFactory {
    @Override
    public Biglietto creaBiglietto(Spettacolo spettacolo, Utente acquirente) {
        return new BigliettoIntero(spettacolo, acquirente);
    }
}

