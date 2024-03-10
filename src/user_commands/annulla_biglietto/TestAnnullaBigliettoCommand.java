//package user_commands.annulla_biglietto;
//
////import admin_commands.revenues.GeneraReportRicaviCommand;
//import admin_commands.revenues.GeneraReportRicaviCommand;
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
//import payment_strategy.IMetodoPagamentoStrategy;
//import payment_strategy.PagamentoBancomatStrategy;
//import payment_strategy.PagamentoContantiStrategy;
//import payment_strategy.PayContext;
//import revenues.*;
//import ticket.GeneratoreIDBiglietto;
//import ticket.IGeneratoreIDBiglietto;
//import ticket.factory.BigliettoFactory;
//import ticket.factory.BigliettoInteroFactory;
//import ticket.factory.IBiglietto;
//import user_commands.acquisto_biglietto.AcquistoBigliettoCommand;
//import user_interfaces.AcquistoBiglietto;
//import user_interfaces.IUserCommand;
//import user_services.ServizioAcquistoBiglietto;
//
//import java.time.LocalDateTime;
//
//public class TestAnnullaBigliettoCommand {
//
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
//        ISpettacolo spettacolo2 = new Spettacolo(film,sala,LocalDateTime.now());
//
//        // Creazione di un utente
//        Utente utente = new Utente("Mario", "Rossi", 30, Ruolo.UTENTE);
//
//
//
//        // Creazione del biglietto (utilizzando una factory e un generatore di ID fittizio)
//        BigliettoFactory bigliettoFactory = new BigliettoInteroFactory();
//
//        // Creazione di un generatore di ID per i biglietti
//        IGeneratoreIDBiglietto generatoreIDBiglietto = GeneratoreIDBiglietto.getInstance();
//
//        IBiglietto biglietto = bigliettoFactory.creaBiglietto(spettacolo, utente, 8.0, generatoreIDBiglietto);
//
//        IBiglietto biglietto2 = bigliettoFactory.creaBiglietto(spettacolo2,utente,8.0,generatoreIDBiglietto);
//
//
//        // Scelta del metodo di pagamento
//        IMetodoPagamentoStrategy metodoPagamento = new PagamentoContantiStrategy();
//        PayContext payContext = new PayContext(metodoPagamento);
//
//        IRegistroBiglietti registroBiglietti = new RegistroBiglietti();
//
//        // Creazione del servizio di acquisto biglietto
//        AcquistoBiglietto servizioAcquisto = new ServizioAcquistoBiglietto(payContext,registroBiglietti);
//
//        IUserCommand acquistoCommand = new AcquistoBigliettoCommand(servizioAcquisto,biglietto);
//
//        utente.setCommand(acquistoCommand);
//        utente.eseguiComando();
//
//
//        IUserCommand acquistoCommand2 = new AcquistoBigliettoCommand(servizioAcquisto,biglietto2);
//        utente.setCommand(acquistoCommand2);
//        utente.eseguiComando();
//
//        System.out.println("Dopo L'acquisto: ");
//        for (IBiglietto iBiglietto : registroBiglietti.getBiglietti()) {
//            System.out.println(iBiglietto);
//        }
//
//        IReport report = new RicaviPerSalaReport(registroBiglietti.getBiglietti());
//        IReport reportaff = new AffluenzaPerSalaReport(registroBiglietti.getBiglietti());
//
//        Amministratore admin = new Amministratore("Luca","Rossi",Ruolo.AMMINISTRATORE);
//        ICommand ricaviCommand = new GeneraReportRicaviCommand(report);
//        admin.setCommand(ricaviCommand);
//        admin.eseguiComando();
//
//        ICommand ricaviCommandAff = new GeneraReportRicaviCommand(reportaff);
//        admin.setCommand(ricaviCommandAff);
//        admin.eseguiComando();
//
//
//
//        IUserCommand annullaCommand = new AnnullaBigliettoCommand(biglietto.getId(),registroBiglietti);
//        utente.setCommand(annullaCommand);
//        utente.eseguiComando();
//
////        IUserCommand annullaCommand2 = new AnnullaBigliettoCommand(biglietto2.getId(),registroBiglietti);
////        utente.setCommand(annullaCommand2);
////        utente.eseguiComando();
//
//        System.out.println("Dopo L'annullamento: ");
//        for (IBiglietto iBiglietto : registroBiglietti.getBiglietti()) {
//            System.out.println(iBiglietto);
//        }
//
//        IReport report2 = new RicaviPerSalaReport(registroBiglietti.getBiglietti());
//
//       // Amministratore admin = new Amministratore("Luca","Rossi",Ruolo.AMMINISTRATORE);
//        ICommand ricaviCommand2 = new GeneraReportRicaviCommand(report2);
//        admin.setCommand(ricaviCommand2);
//        admin.eseguiComando();
//
//        IReport reportAff2 = new AffluenzaPerSalaReport(registroBiglietti.getBiglietti());
//
//        ICommand ricaviCommandAff2 = new GeneraReportRicaviCommand(reportAff2);
//        admin.setCommand(ricaviCommandAff2);
//        admin.eseguiComando();
//
////        ICommand ricaviCommand2 = new GeneraReportRicaviCommand();
////        admin.setCommand(ricaviCommand2);
////        admin.eseguiComando();
//
//
//        // Acquisto del biglietto
////        servizioAcquisto.acquistaBiglietto(biglietto, metodoPagamento);
////
////        servizioAcquisto.acquistaBiglietto(biglietto2,metodoPagamento);
//
//        //        System.out.println("Biglietto Intero - ID: " + biglietto.getId() +
////                ", Costo: " + biglietto.getCosto() +
////                ", Spettacolo: Film '" + spettacolo.getFilm().getTitolo() +
////                "' in Sala '" + spettacolo.getSala().getNumeroSala() +
////                "', Orario: " + spettacolo.getOrarioProiezione() +
////                ", Acquirente: " + biglietto.getAcquirente().getNome() +
////                " " + biglietto.getAcquirente().getCognome());
//
//
//
//
////        System.out.println("Biglietto Intero - ID: " + biglietto.getId() +
////                ", Costo: " + biglietto.getCosto() +
////                ", Spettacolo: Film '" + spettacolo.getFilm().getTitolo() +
////                "' in Sala '" + spettacolo.getSala().getNumeroSala() +
////                "', Orario: " + spettacolo.getOrarioProiezione() +
////                ", Acquirente: " + biglietto.getAcquirente().getNome() +
////                " " + biglietto.getAcquirente().getCognome());
//
//
//
//
//
//    }
//}
