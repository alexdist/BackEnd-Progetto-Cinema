package ticket.factory;

import cinema_Infrastructure.spettacolo.Spettacolo;
import domain.Utente;
import ticket.IGeneratoreIDBiglietto;

public class BigliettoRidottoFactory extends BigliettoFactory {
    @Override
    public IBiglietto creaBiglietto(Spettacolo spettacolo, Utente acquirente, double costo, IGeneratoreIDBiglietto generatoreID) {
        return new BigliettoRidotto(spettacolo, acquirente, costo, generatoreID);
    }
}
