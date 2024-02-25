package ticket;

import cinema_Infrastructure.Spettacolo;
import domain.Utente;

public class BigliettoRidottoFactory extends BigliettoFactory {
    @Override
    public Biglietto creaBiglietto(Spettacolo spettacolo, Utente acquirente) {
        return new BigliettoRidotto(spettacolo, acquirente);
    }
}

