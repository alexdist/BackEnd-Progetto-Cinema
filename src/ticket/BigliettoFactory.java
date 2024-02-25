package ticket;

import cinema_Infrastructure.Spettacolo;
import domain.Utente;

public abstract class BigliettoFactory {
    public abstract Biglietto creaBiglietto(Spettacolo spettacolo, Utente acquirente);
}
