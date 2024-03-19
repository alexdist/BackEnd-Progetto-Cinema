package ticket.factory.concrete_factory;

import cinema_Infrastructure.spettacolo.ISpettacolo;
import domain.Utente;
import id_generator_factory.abstract_factory.GeneratoreIDFactory;
import prova_id_PERSISTENTE.IGeneratoreIDPersistente;
import ticket.factory.abstract_factory.BigliettoFactory;
import ticket.factory.concrete_product.BigliettoIntero;
import ticket.factory.product.IBiglietto;
//import ticket.IGeneratoreIDBiglietto;

//public class BigliettoInteroFactory extends BigliettoFactory {
//    @Override
//    public IBiglietto creaBiglietto(ISpettacolo spettacolo, Utente acquirente, double costo, IGeneratoreIDBiglietto generatoreID) {
//        return new BigliettoIntero(spettacolo, acquirente, costo, generatoreID);
//    }
//}

public class BigliettoInteroFactory extends BigliettoFactory {

    public BigliettoInteroFactory(IGeneratoreIDPersistente generatoreID) {
        super(generatoreID);
    }

    @Override
    public IBiglietto creaBiglietto(ISpettacolo spettacolo, Utente acquirente, double costo) {
        return new BigliettoIntero(spettacolo, acquirente, costo, super.generatoreID);
    }
}