//package admin_commands.revenues;
//
//import admin_interfaces.ICommand;
//import cinema_Infrastructure.film.Film;
//import cinema_Infrastructure.film.IFilm;
//import cinema_Infrastructure.sala.ISala;
//import cinema_Infrastructure.sala.Sala;
//import cinema_Infrastructure.spettacolo.ISpettacolo;
//import cinema_Infrastructure.spettacolo.Spettacolo;
//import domain.Amministratore;
//import domain.Ruolo;
//import domain.Utente;
//import exception.film.*;
//import exception.sala.SalaGiaEsistenteException;
//import exception.sala.SalaNonTrovataException;
//import exception.sala.SalaNonValidaException;
//import exception.spettacolo.SovrapposizioneSpettacoloException;
//import exception.spettacolo.SpettacoloNonTrovatoException;
//import id_generator_factory.abstract_factory.GeneratoreIDFactory;
//import id_generator_factory.concrete_factories.GeneratoreIDBigliettoFactory;
//import id_generator_factory.concrete_factories.GeneratoreIDFilmFactory;
//import payment_strategy.IMetodoPagamentoStrategy;
//import payment_strategy.PagamentoBancomatStrategy;
//import payment_strategy.PayContext;
////import revenues.IRegistroBiglietti;
////import revenues.IReport;
////import revenues.RegistroBiglietti;
////
////import revenues.RicaviPerSalaReport;
//import revenues_observer.concrete_observable.RegistroBiglietti;
//import revenues_observer.concrete_observableA.AffluenzaPerSalaReport;
//import revenues_observer.concrete_observableB.RicaviPerSalaReport;
//import revenues_observer.observable.AbstractRegistroBiglietti;
////import revenues_observer.observable.IRegistroBiglietti;
//import ticket.factory.abstract_factory.BigliettoFactory;
//import ticket.factory.concrete_factory.BigliettoInteroFactory;
//import ticket.factory.product.IBiglietto;
//import user_services.ServizioAcquistoBiglietto;
//
//import java.time.LocalDateTime;
//
//public class TestGeneraReport {
//    public static void main(String[] args) throws FilmGiaPresenteException, DurataFilmNonValidaException, SpettacoloNonTrovatoException, TitoloVuotoException, SalaGiaEsistenteException, SalaNonTrovataException, FilmNonValidoException, SovrapposizioneSpettacoloException, SalaNonValidaException, FilmNonTrovatoException {
//
//
//        // Creazione di un film
//        IFilm film = new Film("Il signore degli anelli", 180, "Fantasy");
//
//        // Creazione di una sala
//        ISala sala = new Sala(1, 100);
//
//        ISala sala2 = new Sala(2,100);
//
//        // Creazione dello spettacolo
//        ISpettacolo spettacolo = new Spettacolo(film, sala, LocalDateTime.now());
//
//        ISpettacolo spettacolo2 = new Spettacolo(film,sala2,LocalDateTime.now());
//
//        // Creazione di un utente
//        Utente utente = new Utente("Mario", "Rossi", 30, Ruolo.UTENTE);
//
//        // Creazione di un generatore di ID per i biglietti
//        GeneratoreIDFactory generatoreIDBigliettoFactory = new GeneratoreIDBigliettoFactory();
//
//        // Creazione del biglietto (utilizzando una factory e un generatore di ID fittizio)
//        BigliettoFactory bigliettoFactory = new BigliettoInteroFactory(generatoreIDBigliettoFactory);
//
//
//        IBiglietto biglietto = bigliettoFactory.creaBiglietto(spettacolo, utente, 8.0);
//
//        IBiglietto biglietto2 = bigliettoFactory.creaBiglietto(spettacolo2,utente,8.0);
//
//
//        // Scelta del metodo di pagamento
//        IMetodoPagamentoStrategy metodoPagamentoBancomat = new PagamentoBancomatStrategy();
//        PayContext pagamentoBancomat = new PayContext(metodoPagamentoBancomat);
//
//        // Creazione del registro biglietti (ConcreteObservable)
//        AbstractRegistroBiglietti registroBiglietti = new RegistroBiglietti();
//
//        // Creazione dei report (ConcreteObservers) e registrazione al registro
//        RicaviPerSalaReport ricaviReport = new RicaviPerSalaReport(registroBiglietti);
//        AffluenzaPerSalaReport affluenzaReport = new AffluenzaPerSalaReport(registroBiglietti);
//
//        // Creazione del servizio di acquisto biglietto
//        ServizioAcquistoBiglietto servizioAcquisto = new ServizioAcquistoBiglietto(pagamentoBancomat, registroBiglietti);
//
//        // Acquisto del biglietto
//        servizioAcquisto.acquistaBiglietto(biglietto);
//
//        servizioAcquisto.acquistaBiglietto(biglietto);
//
//        servizioAcquisto.acquistaBiglietto(biglietto2);
//
//        servizioAcquisto.acquistaBiglietto(biglietto2);
//
//
//
//        Amministratore admin = new Amministratore("Luca","Rossi", Ruolo.AMMINISTRATORE);
//
//        ICommand generaReport = new GeneraReportRicaviCommand(ricaviReport);
//        admin.setCommand(generaReport);
//        admin.eseguiComando();
//
//
////        System.out.println("Biglietto Intero - ID: " + biglietto.getId() +
////                ", Costo: " + biglietto.getCosto() +
////                ", Spettacolo: Film '" + spettacolo.getFilm().getTitolo() +
////                "' in Sala '" + spettacolo.getSala().getNumeroSala() +
////                "', Orario: " + spettacolo.getOrarioProiezione() +
////                ", Acquirente: " + biglietto.getAcquirente().getNome() +
////                " " + biglietto.getAcquirente().getCognome());
//    }
//}

