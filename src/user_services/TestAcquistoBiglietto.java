//package user_services;
//
//import cinema_Infrastructure.film.Film;
//import cinema_Infrastructure.film.IFilm;
//import cinema_Infrastructure.sala.ISala;
//import cinema_Infrastructure.sala.Sala;
//import cinema_Infrastructure.spettacolo.ISpettacolo;
//import cinema_Infrastructure.spettacolo.Spettacolo;
//import domain.Ruolo;
//import domain.Utente;
//import payment_strategy.*;
//
//import revenues.RegistroBiglietti;
//import ticket.GeneratoreIDBiglietto;
//import ticket.IGeneratoreIDBiglietto;
//import ticket.factory.abstract_factory.BigliettoFactory;
//import ticket.factory.concrete_factory.BigliettoInteroFactory;
//import ticket.factory.product.IBiglietto;
//
//import java.time.LocalDateTime;
//
//public class TestAcquistoBiglietto {
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
////        servizioAcquisto.acquistaBiglietto(biglietto2,metodoPagamento);
//
//
//
//    }
//}
