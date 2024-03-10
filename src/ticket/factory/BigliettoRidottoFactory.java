package ticket.factory;

import cinema_Infrastructure.spettacolo.ISpettacolo;
import cinema_Infrastructure.spettacolo.Spettacolo;
import domain.Utente;
import id_generator_factory.abstract_factory.GeneratoreIDFactory;
import id_generator_factory.product.IGeneratoreID;
//import ticket.IGeneratoreIDBiglietto;

//public class BigliettoRidottoFactory extends BigliettoFactory {
//    @Override
//    public IBiglietto creaBiglietto(ISpettacolo spettacolo, Utente acquirente, double costo, IGeneratoreIDBiglietto generatoreID) {
//        return new BigliettoRidotto(spettacolo, acquirente, costo, generatoreID);
//    }
//}

//public class BigliettoRidottoFactory extends BigliettoFactory {
//    private GeneratoreIDFactory generatoreIDFactory;
//
//    public BigliettoRidottoFactory(GeneratoreIDFactory generatoreIDFactory) {
//        this.generatoreIDFactory = generatoreIDFactory;
//    }
//
//    @Override
//    public IBiglietto creaBiglietto(ISpettacolo spettacolo, Utente acquirente, double costo) {
//        // Utilizza la generatoreIDFactory per ottenere il generatore di ID
//        IGeneratoreID generatoreID = generatoreIDFactory.creaGeneratoreID();
//        // Crea un nuovo BigliettoRidotto utilizzando il generatore di ID ottenuto
//        return new BigliettoRidotto(spettacolo, acquirente, costo, generatoreID);
//    }
//}

public class BigliettoRidottoFactory extends BigliettoFactory {

    public BigliettoRidottoFactory(GeneratoreIDFactory generatoreIDFactory) {
        super(generatoreIDFactory);
    }

    @Override
    public IBiglietto creaBiglietto(ISpettacolo spettacolo, Utente acquirente, double costo) {
        return new BigliettoRidotto(spettacolo, acquirente, costo, super.generatoreIDFactory);
    }
}