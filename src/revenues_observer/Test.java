package revenues_observer;

import admin_commands.revenues.GeneraReportRicaviCommand;
import admin_interfaces.ICommand;
import cinema_Infrastructure.film.Film;
import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.sala.ISala;
import cinema_Infrastructure.sala.Sala;
import cinema_Infrastructure.spettacolo.ISpettacolo;
import cinema_Infrastructure.spettacolo.Spettacolo;
import domain.Amministratore;
import domain.Ruolo;
import domain.Utente;
import exception.film.*;
import exception.sala.SalaGiaEsistenteException;
import exception.sala.SalaNonTrovataException;
import exception.sala.SalaNonValidaException;
import exception.spettacolo.SovrapposizioneSpettacoloException;
import exception.spettacolo.SpettacoloNonTrovatoException;
import id_generator_factory.abstract_factory.GeneratoreIDFactory;
import id_generator_factory.concrete_factories.GeneratoreIDBigliettoFactory;
import payment_strategy.IMetodoPagamentoStrategy;
import payment_strategy.PagamentoContantiStrategy;
import payment_strategy.PayContext;
import revenues_observer.concrete_observable.RegistroBiglietti;
import revenues_observer.concrete_observableA.AffluenzaPerSalaReport;
import revenues_observer.concrete_observableB.RicaviPerSalaReport;
import revenues_observer.observable.AbstractRegistroBiglietti;
//import revenues_observer.observable.IRegistroBiglietti;
import ticket.factory.abstract_factory.BigliettoFactory;
import ticket.factory.concrete_factory.BigliettoInteroFactory;
import ticket.factory.product.IBiglietto;
import user_commands.acquisto_biglietto.AcquistoBigliettoCommand;
import user_commands.annulla_biglietto.AnnullaBigliettoCommand;
import user_interfaces.AcquistoBiglietto;
import user_interfaces.IUserCommand;
import user_services.ServizioAcquistoBiglietto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws FilmGiaPresenteException, DurataFilmNonValidaException, SpettacoloNonTrovatoException, TitoloVuotoException, SalaGiaEsistenteException, SalaNonTrovataException, FilmNonValidoException, SovrapposizioneSpettacoloException, SalaNonValidaException, FilmNonTrovatoException {
        // Creazione del registro biglietti (ConcreteObservable)
        AbstractRegistroBiglietti registroBiglietti = new RegistroBiglietti();

        // Creazione dei report (ConcreteObservers) e registrazione al registro
        RicaviPerSalaReport ricaviReport = new RicaviPerSalaReport(registroBiglietti);
        AffluenzaPerSalaReport affluenzaReport = new AffluenzaPerSalaReport(registroBiglietti);

        GeneratoreIDFactory generatoreIDBigliettoFactory = new GeneratoreIDBigliettoFactory();

        // Inizializzazione delle factory per i generatori di ID (omessa per brevità)
        // ...

        // Creazione di alcuni film e sale di esempio
        IFilm film1 = new Film("Il signore degli anelli", 180, "Fantasy");
        ISala sala1 = new Sala(1, 200);
        ISpettacolo spettacolo1 = new Spettacolo(film1, sala1, LocalDateTime.now().plusHours(3));

        // Aggiungere i film, le sale e gli spettacoli alle rispettive liste
        ArrayList<IFilm> filmInProgrammazione = new ArrayList<>();
        ArrayList<ISala> saleInProgrammazione = new ArrayList<>();
        ArrayList<ISpettacolo> spettacoliInProgrammazione = new ArrayList<>();
        filmInProgrammazione.add(film1);
        saleInProgrammazione.add(sala1);
        spettacoliInProgrammazione.add(spettacolo1);

        // Creazione di utenti e biglietti
        Utente acquirente1 = new Utente("Mario", "Rossi", 30, Ruolo.UTENTE);
        BigliettoFactory bigliettoInteroFactory = new BigliettoInteroFactory(generatoreIDBigliettoFactory);
        IBiglietto bigliettoIntero1 = bigliettoInteroFactory.creaBiglietto(spettacolo1, acquirente1, 10.0);

        // Aggiunta di un biglietto al registro per simulare un acquisto
        //registroBiglietti.aggiungiBiglietto(bigliettoIntero1);

        // Creazione e esecuzione del comando di acquisto biglietto
        IMetodoPagamentoStrategy metodoPagamentoContanti = new PagamentoContantiStrategy();
        PayContext pagamentoContanti = new PayContext(metodoPagamentoContanti);
        AcquistoBiglietto servizioAcquisto = new ServizioAcquistoBiglietto(pagamentoContanti, registroBiglietti);

        IUserCommand acquistoCommand = new AcquistoBigliettoCommand(servizioAcquisto, bigliettoIntero1);
        acquirente1.setCommand(acquistoCommand);
        acquirente1.eseguiComando();

        // Simulazione di un amministratore che genera report di ricavi e affluenza
        Amministratore admin = new Amministratore("Luca", "Rossi", Ruolo.AMMINISTRATORE);
        ICommand ricaviCommand = new GeneraReportRicaviCommand(ricaviReport);
        ICommand affluenzaCommand = new GeneraReportRicaviCommand(affluenzaReport);
        admin.setCommand(ricaviCommand);
        admin.eseguiComando();
        admin.setCommand(affluenzaCommand);
        admin.eseguiComando();

        // Simulazione dell'annullamento di un biglietto
        IUserCommand annullaCommand = new AnnullaBigliettoCommand(bigliettoIntero1.getId(), registroBiglietti);
        acquirente1.setCommand(annullaCommand);
        acquirente1.eseguiComando();

        // I report vengono aggiornati automaticamente grazie al pattern Observer
        // Se desideri vedere i report dopo l'annullamento, puoi generare nuovamente i report
        System.out.println("Rapporto aggiornato post-annullamento:");
        admin.setCommand(ricaviCommand);
        admin.eseguiComando();
        admin.setCommand(affluenzaCommand);
        admin.eseguiComando();
//        ricaviReport.generate();
//        affluenzaReport.generate();
    }
}
