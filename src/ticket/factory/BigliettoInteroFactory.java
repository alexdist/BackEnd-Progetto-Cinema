package ticket.factory;

import cinema_Infrastructure.spettacolo.Spettacolo;
import domain.Utente;
import ticket.IGeneratoreIDBiglietto;

public class BigliettoInteroFactory extends BigliettoFactory {
    @Override
    public IBiglietto creaBiglietto(Spettacolo spettacolo, Utente acquirente, double costo, IGeneratoreIDBiglietto generatoreID) {
        return new BigliettoIntero(spettacolo, acquirente, costo, generatoreID);
    }
}

