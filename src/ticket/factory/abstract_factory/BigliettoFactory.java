
package ticket.factory.abstract_factory;

import cinema_Infrastructure.spettacolo.ISpettacolo;
import domain.Utente;
import id_generator_factory.abstract_factory.GeneratoreIDFactory;
import ticket.factory.product.IBiglietto;
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