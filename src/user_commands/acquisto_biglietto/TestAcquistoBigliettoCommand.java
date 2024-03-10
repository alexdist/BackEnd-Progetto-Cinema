//package user_commands.acquisto_biglietto;
//
//import cinema_Infrastructure.film.Film;
//import cinema_Infrastructure.film.IFilm;
//import cinema_Infrastructure.sala.ISala;
//import cinema_Infrastructure.sala.Sala;
//import cinema_Infrastructure.spettacolo.ISpettacolo;
//import cinema_Infrastructure.spettacolo.Spettacolo;
//import domain.Ruolo;
//import domain.Utente;
//import payment_strategy.IMetodoPagamentoStrategy;
//import payment_strategy.PagamentoContantiStrategy;
//import payment_strategy.PayContext;
//import ticket.GeneratoreIDBiglietto;
//import ticket.IGeneratoreIDBiglietto;
//import ticket.factory.abstract_factory.BigliettoFactory;
//import ticket.factory.concrete_factory.BigliettoInteroFactory;
//import ticket.factory.product.IBiglietto;
//import user_commands.acquisto_biglietto.AcquistoBigliettoCommand;
//import user_interfaces.AcquistoBiglietto;
//import user_interfaces.IUserCommand;
//import user_services.ServizioAcquistoBiglietto;
//
//import java.time.LocalDateTime;
//
//public class TestAcquistoBigliettoCommand {
//    public static void main(String[] args) {
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
//
//        // Creazione del servizio di acquisto biglietto
//        AcquistoBiglietto servizioAcquisto = new ServizioAcquistoBiglietto(payContext);
//
//        IUserCommand acquistoCommand = new AcquistoBigliettoCommand(servizioAcquisto,biglietto);
//
//        utente.setCommand(acquistoCommand);
//        utente.eseguiComando();
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
