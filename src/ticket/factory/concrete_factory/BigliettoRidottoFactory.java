package ticket.factory.concrete_factory;

import cinema_Infrastructure.spettacolo.ISpettacolo;
import domain.Utente;
//import id_generator_factory.abstract_factory.GeneratoreIDFactory;
import ID_persistente.IGeneratoreIDPersistente;
import ticket.factory.abstract_factory.BigliettoFactory;
import ticket.factory.concrete_product.BigliettoRidotto;
import ticket.factory.product.IBiglietto;

// BigliettoRidottoFactory è un'altra 'ConcreteFactory' che produce 'BigliettoRidotto', un diverso 'ConcreteProduct'.
public class BigliettoRidottoFactory extends BigliettoFactory {

    public BigliettoRidottoFactory(IGeneratoreIDPersistente generatoreID) {
        super(generatoreID);
    }

    @Override
    public IBiglietto creaBiglietto(ISpettacolo spettacolo, Utente acquirente, double costo) {
        return new BigliettoRidotto(spettacolo, acquirente, costo, super.generatoreID);
    }
}