
package ticket.factory;

import cinema_Infrastructure.spettacolo.ISpettacolo;
import cinema_Infrastructure.spettacolo.Spettacolo;
import domain.Utente;
import id_generator_factory.abstract_factory.GeneratoreIDFactory;
//import ticket.IGeneratoreIDBiglietto;

//public abstract class BigliettoFactory {
//    public abstract IBiglietto creaBiglietto(ISpettacolo spettacolo, Utente acquirente, double costo, IGeneratoreIDBiglietto generatoreID);
//}

public abstract class BigliettoFactory {
    protected GeneratoreIDFactory generatoreIDFactory;

    public BigliettoFactory(GeneratoreIDFactory generatoreIDFactory) {
        this.generatoreIDFactory = generatoreIDFactory;
    }

    public abstract IBiglietto creaBiglietto(ISpettacolo spettacolo, Utente acquirente, double costo);
}