//package revenues;
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
//import payment_strategy.PagamentoBancomatStrategy;
//import payment_strategy.PayContext;
//import ticket.GeneratoreIDBiglietto;
//import ticket.IGeneratoreIDBiglietto;
//import ticket.factory.abstract_factory.BigliettoFactory;
//import ticket.factory.concrete_factory.BigliettoInteroFactory;
//import ticket.factory.product.IBiglietto;
//import user_services.ServizioAcquistoBiglietto;
//
//import java.time.LocalDateTime;
//
//public class TestAquistoeAnnullamento {
//
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
//        IMetodoPagamentoStrategy metodoPagamento = new PagamentoBancomatStrategy();
//        PayContext payContext = new PayContext(metodoPagamento);
//
//        // Creazione del servizio di acquisto biglietto
//        ServizioAcquistoBiglietto servizioAcquisto = new ServizioAcquistoBiglietto(payContext);
//
//        // Acquisto del biglietto
////        servizioAcquisto.acquistaBiglietto(biglietto, metodoPagamento);
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
////        servizioAcquisto.acquistaBiglietto(biglietto, metodoPagamento);
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
////        servizioAcquisto.acquistaBiglietto(biglietto2,metodoPagamento);
////
////        servizioAcquisto.acquistaBiglietto(biglietto2,metodoPagamento);
//
//
//
//
//
//        RegistroBiglietti.reportRicaviPerSala();
//        RegistroBiglietti.reportAffluenzaPerSala();
//
//
//
//        // Simula l'attesa (per esempio, l'utente sta riflettendo sull'acquisto)
//        // In un'applicazione reale, l'utente avrebbe la possibilità di annullare l'acquisto in qualche modo, e poi
//        // il seguente codice verrebbe eseguito in risposta a quella azione.
//        try {
//            Thread.sleep(70000); // Attendi 1 minuto e 10 secondi (70000 millisecondi)
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // Annullamento dell'acquisto entro 10 minuti
//        boolean annullato = RegistroBiglietti.annullaAcquisto(biglietto.getId());
//        if (annullato) {
//            System.out.println("L'acquisto del biglietto con ID " + biglietto.getId() + " è stato annullato con successo.");
//        } else {
//            System.out.println("Non è stato possibile annullare l'acquisto del biglietto con ID " + biglietto.getId() + ".");
//        }
//
//        // Report dei ricavi e dell'affluenza per sala, post annullamento
//        RegistroBiglietti.reportRicaviPerSala();
//        RegistroBiglietti.reportAffluenzaPerSala();
//    }
//}
