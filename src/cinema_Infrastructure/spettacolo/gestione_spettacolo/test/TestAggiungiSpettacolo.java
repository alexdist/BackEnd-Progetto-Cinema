//package cinema_Infrastructure.spettacolo.gestione_spettacolo.test;
//
//import cinema_Infrastructure.film.Film;
//import cinema_Infrastructure.film.IFilm;
//import cinema_Infrastructure.film.gestione_film.AggiungiFilm;
//import cinema_Infrastructure.film.gestione_film.IAggiungiFilm;
//import cinema_Infrastructure.sala.ISala;
//import cinema_Infrastructure.sala.Sala;
//import cinema_Infrastructure.sala.gestione_sala.AggiungiSala;
//import cinema_Infrastructure.sala.gestione_sala.IAggiungiSala;
//import cinema_Infrastructure.spettacolo.ISpettacolo;
//import cinema_Infrastructure.spettacolo.Spettacolo;
//import cinema_Infrastructure.spettacolo.gestione_spettacolo.AggiungiSpettacolo;
//import cinema_Infrastructure.spettacolo.gestione_spettacolo.IAggiungiSpettacolo;
//import id_generator_factory.abstract_factory.GeneratoreIDFactory;
//import id_generator_factory.concrete_factories.GeneratoreIDFilmFactory;
//import id_generator_factory.concrete_factories.GeneratoreIDSalaFactory;
//import id_generator_factory.concrete_factories.GeneratoreIDSpettacoloFactory;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//
//public class TestAggiungiSpettacolo {
//    public static void main(String[] args) {
//        ArrayList<IFilm> filmInProgrammazione = new ArrayList<>();
//        ArrayList<ISala> saleInProgrammazione = new ArrayList<>();
//        ArrayList<ISpettacolo> spettacoliInProgrammazione = new ArrayList<>();
//
//        GeneratoreIDFactory generatoreIDFilmFactory = new GeneratoreIDFilmFactory();
//        GeneratoreIDFactory generatoreIDSalaFactory = new GeneratoreIDSalaFactory();
//        GeneratoreIDFactory generatoreIDSpettacoloFactory = new GeneratoreIDSpettacoloFactory();
//
//        IAggiungiFilm aggiungiFilm = new AggiungiFilm(filmInProgrammazione, generatoreIDFilmFactory);
//        IAggiungiSala aggiungiSala = new AggiungiSala(saleInProgrammazione, generatoreIDSalaFactory);
//        IAggiungiSpettacolo aggiungiSpettacolo = new AggiungiSpettacolo(spettacoliInProgrammazione, generatoreIDSpettacoloFactory);
//
//        try {
//            // Aggiunta di 3 film
//            for (int i = 1; i <= 3; i++) {
//                IFilm nuovoFilm = new Film("Film " + i, 120 + i, "Genere " + i);
//                aggiungiFilm.aggiungiFilm(nuovoFilm);
//                System.out.println("Aggiunto film: " + nuovoFilm.getTitolo() + " con ID: " + nuovoFilm.getId());
//            }
//
//            // Aggiunta di 3 sale
//            for (int i = 1; i <= 3; i++) {
//                ISala nuovaSala = new Sala(i, 100 + i * 10);
//                aggiungiSala.aggiungiSala(nuovaSala);
//                System.out.println("Aggiunta sala numero: " + nuovaSala.getNumeroSala() + " con ID: " + nuovaSala.getId());
//            }
//
//            // Aggiunta di 3 spettacoli
//            for (int i = 0; i < 3; i++) {
//                ISpettacolo nuovoSpettacolo = new Spettacolo(filmInProgrammazione.get(i), saleInProgrammazione.get(i), LocalDateTime.now().plusHours(i));
//                aggiungiSpettacolo.aggiungiSpettacolo(nuovoSpettacolo);
//                System.out.println("Aggiunto spettacolo con ID: " + nuovoSpettacolo.getId() + " per il film: " + nuovoSpettacolo.getFilm().getTitolo() + " nella sala: " + nuovoSpettacolo.getSala().getNumeroSala());
//            }
//
//            // Stampa finale di tutti i film aggiunti
//            System.out.println("\nElenco completo dei film in programmazione:");
//            for (IFilm film : filmInProgrammazione) {
//                System.out.println("ID: " + film.getId() + " - Titolo: " + film.getTitolo() + " - Genere: " + film.getGenere() + " - Durata: " + film.getDurata() + " minuti");
//            }
//
//            // Stampa finale di tutte le sale
//            System.out.println("\nElenco completo delle sale:");
//            for (ISala sala : saleInProgrammazione) {
//                System.out.println("ID: " + sala.getId() + " - Numero Sala: " + sala.getNumeroSala() + " - Capacità: " + sala.getCapacita() + " - Posti Disponibili: " + sala.getPostiDisponibili());
//            }
//
//            // Stampa finale di tutti gli spettacoli
//            System.out.println("\nElenco completo degli spettacoli:");
//            for (ISpettacolo spettacolo : spettacoliInProgrammazione) {
//                System.out.println("ID: " + spettacolo.getId() + " - Film: " + spettacolo.getFilm().getTitolo() + " - Sala: " + spettacolo.getSala().getNumeroSala() + " - Orario Proiezione: " + spettacolo.getOrarioProiezione());
//            }
//        } catch (Exception e) {
//            System.err.println("Errore durante l'aggiunta di elementi al cinema: " + e.getMessage());
//        }
//    }
//}
