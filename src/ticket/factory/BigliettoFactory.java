
package ticket.factory;

import cinema_Infrastructure.spettacolo.Spettacolo;
import domain.Utente;
import ticket.IGeneratoreIDBiglietto;

public abstract class BigliettoFactory {
    public abstract IBiglietto creaBiglietto(Spettacolo spettacolo, Utente acquirente, double costo, IGeneratoreIDBiglietto generatoreID);
}
