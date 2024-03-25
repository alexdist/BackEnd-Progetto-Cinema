
package ticket.factory.abstract_factory;

import cinema_Infrastructure.spettacolo.ISpettacolo;
import domain.Utente;
import id_generator_factory.abstract_factory.GeneratoreIDFactory;
import prova_id_PERSISTENTE.IGeneratoreIDPersistente;
import ticket.factory.product.IBiglietto;

import java.io.IOException;
//import ticket.IGeneratoreIDBiglietto;

//public abstract class BigliettoFactory {
//    public abstract IBiglietto creaBiglietto(ISpettacolo spettacolo, Utente acquirente, double costo, IGeneratoreIDBiglietto generatoreID);
//}

public abstract class BigliettoFactory {
    protected IGeneratoreIDPersistente generatoreID;

    public BigliettoFactory(IGeneratoreIDPersistente generatoreID) {
        this.generatoreID = generatoreID;
    }

    public abstract IBiglietto creaBiglietto(ISpettacolo spettacolo, Utente acquirente, double costo) ;
}