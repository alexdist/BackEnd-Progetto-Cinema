
package ticket.factory.abstract_factory;

import cinema_Infrastructure.spettacolo.ISpettacolo;
import domain.Utente;
//import id_generator_factory.abstract_factory.GeneratoreIDFactory;
import ID_persistente.IGeneratoreIDPersistente;
import ticket.factory.product.IBiglietto;

// BigliettoFactory agisce come la classe 'Creator' astratta nel pattern Factory Method.
// Definisce il metodo factory astratto 'creaBiglietto(...)' che le sottoclassi concrete dovranno implementare.
public abstract class BigliettoFactory {
    protected IGeneratoreIDPersistente generatoreID;

    public BigliettoFactory(IGeneratoreIDPersistente generatoreID) {
        this.generatoreID = generatoreID;
    }

    // Il metodo factory astratto che deve essere implementato dalle ConcreteFactory per creare oggetti ConcreteProduct.
    public abstract IBiglietto creaBiglietto(ISpettacolo spettacolo, Utente acquirente, double costo) ;
}