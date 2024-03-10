package ticket.factory;

import cinema_Infrastructure.spettacolo.ISpettacolo;
import cinema_Infrastructure.spettacolo.Spettacolo;
import domain.Utente;
import id_generator_factory.abstract_factory.GeneratoreIDFactory;
//import ticket.IGeneratoreIDBiglietto;

//public class BigliettoInteroFactory extends BigliettoFactory {
//    @Override
//    public IBiglietto creaBiglietto(ISpettacolo spettacolo, Utente acquirente, double costo, IGeneratoreIDBiglietto generatoreID) {
//        return new BigliettoIntero(spettacolo, acquirente, costo, generatoreID);
//    }
//}

public class BigliettoInteroFactory extends BigliettoFactory {

    public BigliettoInteroFactory(GeneratoreIDFactory generatoreIDFactory) {
        super(generatoreIDFactory);
    }

    @Override
    public IBiglietto creaBiglietto(ISpettacolo spettacolo, Utente acquirente, double costo) {
        return new BigliettoIntero(spettacolo, acquirente, costo, super.generatoreIDFactory);
    }
}