//package cinema_Infrastructure.spettacolo;
//
//import cinema_Infrastructure.film.Film;
//import cinema_Infrastructure.film.IFilm;
//import cinema_Infrastructure.sala.ISala;
//import cinema_Infrastructure.sala.Sala;
//import cinema_Infrastructure.spettacolo.gestione_spettacolo.*;
//import exception.film.FilmNonValidoException;
//import exception.sala.SalaNonValidaException;
//import exception.spettacolo.SovrapposizioneSpettacoloException;
//import exception.spettacolo.SpettacoloNonTrovatoException;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//public class TestSpettacolo {
//
//    public static void main(String[] args) {
//        // Assunzione dell'esistenza di un generatore di ID per gli spettacoli
//        IGeneratoreIDSpettacolo generatoreID = GeneratoreIDSpettacolo.getInstance();
//
//        // Creazione di una lista di spettacoli per il cinema utilizzando ISpettacolo
//        List<ISpettacolo> spettacoli = new ArrayList<>();
//
//        // Creazione di un'istanza di AggiungiSpettacolo
//        IAggiungiSpettacolo gestoreSpettacoli = new AggiungiSpettacolo(spettacoli, generatoreID);
//
//        //Creazione di un'istanza di RimuoviSpettacolo
//        IRimuoviSpettacolo rimozione = new RimuoviSpettacolo(spettacoli);
//
//        //Creazione di un'istanza di ModificaSpettacolo
//        IModificaSpettacolo modifica = new ModificaSpettacolo(spettacoli);
//
//        // Creazione di film e sale per lo spettacolo usando le interfacce IFilm e ISala
//        IFilm film1 = new Film("Interstellar", 120, "Sci-Fi"); // Utilizzando l'implementazione concreta di IFilm
//        ISala sala1 = new Sala(1, 100); // Utilizzando l'implementazione concreta di ISala
//
//        IFilm film2 = new Film("Fast and Furious", 120,"Azione");
//        ISala sala2 = new Sala(2, 150);
//
//        // Creazione di oggetti LocalDateTime per gli orari di proiezione
//        LocalDateTime orarioProiezione1 = LocalDateTime.of(2024, 3, 10, 20, 0);
//        LocalDateTime orarioProiezione2 = LocalDateTime.of(2024, 3, 10, 22, 30);
//
//        // Creazione degli spettacoli utilizzando l'interfaccia ISpettacolo
//        ISpettacolo nuovoSpettacolo1 = new Spettacolo(film1, sala1, orarioProiezione1);
//        ISpettacolo nuovoSpettacolo2 = new Spettacolo(film2, sala2, orarioProiezione2);
//
//        // Aggiunta degli spettacoli alla lista attraverso il gestore
//        try {
//            gestoreSpettacoli.aggiungiSpettacolo(nuovoSpettacolo1);
//            System.out.println("Spettacolo aggiunto: " + film1.getTitolo());
//            System.out.println("Genere: " + film1.getGenere());
//        } catch (SovrapposizioneSpettacoloException e) {
//            System.out.println(e.getMessage());
//        } catch (FilmNonValidoException e) {
//            throw new RuntimeException(e);
//        } catch (SalaNonValidaException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            gestoreSpettacoli.aggiungiSpettacolo(nuovoSpettacolo2);
//            System.out.println("Spettacolo aggiunto: " + film2.getTitolo());
//            System.out.println("Genere: " + film2.getGenere());
//        } catch (SovrapposizioneSpettacoloException e) {
//            System.out.println(e.getMessage());
//        } catch (FilmNonValidoException e) {
//            throw new RuntimeException(e);
//        } catch (SalaNonValidaException e) {
//            throw new RuntimeException(e);
//        }
//
//        // Stampa di conferma
//        System.out.println("\nSpettacoli programmati dopo aggiunte:");
//        spettacoli.forEach(spettacolo -> System.out.println("Film: " + spettacolo.getFilm().getTitolo() + " Genere: " + spettacolo.getFilm().getGenere() + ", Sala: " + spettacolo.getSala().getNumeroSala() + ", Orario: " + spettacolo.getOrarioProiezione() + ", ID: " + spettacolo.getId()));
//
//
////        try {
////            rimozione.rimuoviSpettacoloPerId(0);
////            System.out.println("Spettacolo rimosso " + film2.getTitolo());
////        } catch (SpettacoloNonTrovatoException e) {
////            System.out.println(e.getMessage());
////        }
////
////        // Stampa di conferma dopo rimozione
////        System.out.println("\nSpettacoli programmati dopo rimozione:");
////        spettacoli.forEach(spettacolo -> System.out.println("Film: " + spettacolo.getFilm().getTitolo() + ", Sala: " + spettacolo.getSala().getNumeroSala() + ", Orario: " + spettacolo.getOrarioProiezione() + ", ID: " + spettacolo.getId()));
//
//        //MODIFICA DEL FILM
//        try{
//            modifica.modificaFilmPerIdSpettacolo(0,film2);
//        } catch (SpettacoloNonTrovatoException e){
//            System.out.println("Spettacolo non trovato!");
//        }
//
//        // Stampa di conferma
//        System.out.println("\nSpettacoli programmati dopo modifica del FILM:");
//        spettacoli.forEach(spettacolo -> System.out.println("Film: " + spettacolo.getFilm().getTitolo() + " Genere: " + spettacolo.getFilm().getGenere() + ", Sala: " + spettacolo.getSala().getNumeroSala() + ", Orario: " + spettacolo.getOrarioProiezione() + ", ID: " + spettacolo.getId()));
//
//
//        //MODIFICA DELLA SALA
//        try{
//            modifica.modificaSalaPerIdSpettacolo(0,sala2);
//        } catch (SpettacoloNonTrovatoException e){
//            System.out.println("Spettacolo non trovato!");
//        }
//
//        // Stampa di conferma
//        System.out.println("\nSpettacoli programmati dopo modifica della SALA:");
//        spettacoli.forEach(spettacolo -> System.out.println("Film: " + spettacolo.getFilm().getTitolo() + " Genere: " + spettacolo.getFilm().getGenere() + ", Sala: " + spettacolo.getSala().getNumeroSala() + ", Orario: " + spettacolo.getOrarioProiezione() + ", ID: " + spettacolo.getId()));
//
//
//        //MODIFICA DELL' ORARIO
//        try{
//            modifica.modificaOrarioProiezionePerIdSpettacolo(0,orarioProiezione2);
//        } catch (SpettacoloNonTrovatoException e){
//            System.out.println("Spettacolo non trovato!");
//        }
//
//        // Stampa di conferma
//        System.out.println("\nSpettacoli programmati dopo modifica dell' ORARIO:");
//        spettacoli.forEach(spettacolo -> System.out.println("Film: " + spettacolo.getFilm().getTitolo() + " Genere: " + spettacolo.getFilm().getGenere() + ", Sala: " + spettacolo.getSala().getNumeroSala() + ", Orario: " + spettacolo.getOrarioProiezione() + ", ID: " + spettacolo.getId()));
//
//    }
//}
