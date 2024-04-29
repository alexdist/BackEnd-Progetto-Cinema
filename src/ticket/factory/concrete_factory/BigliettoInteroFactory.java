package ticket.factory.concrete_factory;

import cinema_Infrastructure.spettacolo.ISpettacolo;
import domain.Utente;
//import id_generator_factory.abstract_factory.GeneratoreIDFactory;
import ID_persistente.IGeneratoreIDPersistente;
import ticket.factory.abstract_factory.BigliettoFactory;
import ticket.factory.concrete_product.BigliettoIntero;
import ticket.factory.product.IBiglietto;

// BigliettoInteroFactory è una 'ConcreteFactory'. Estende BigliettoFactory e implementa il metodo factory
// per produrre un oggetto 'BigliettoIntero', che è un 'ConcreteProduct'.
public class BigliettoInteroFactory extends BigliettoFactory {

    public BigliettoInteroFactory(IGeneratoreIDPersistente generatoreID) {
        super(generatoreID);
    }

    @Override
    public IBiglietto creaBiglietto(ISpettacolo spettacolo, Utente acquirente, double costo) {
        return new BigliettoIntero(spettacolo, acquirente, costo, super.generatoreID);
    }
}