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
//import cinema_Infrastructure.spettacolo.gestione_spettacolo.IRimuoviSpettacolo;
//import cinema_Infrastructure.spettacolo.gestione_spettacolo.RimuoviSpettacolo;
//import exception.spettacolo.SpettacoloNonTrovatoException;
//import id_generator_factory.abstract_factory.GeneratoreIDFactory;
//import id_generator_factory.concrete_factories.GeneratoreIDFilmFactory;
//import id_generator_factory.concrete_factories.GeneratoreIDSalaFactory;
//import id_generator_factory.concrete_factories.GeneratoreIDSpettacoloFactory;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//
//public class TestAggiungiRimuoviSpettacolo {
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
//        IRimuoviSpettacolo rimuoviSpettacolo = new RimuoviSpettacolo(spettacoliInProgrammazione);
//
//        try {
//            // Aggiunta di 3 film, 3 sale e 3 spettacoli...
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
//
//
//
//            // Tentativo di rimozione dello spettacolo con ID 1
//            System.out.println("\nTentativo di rimozione dello spettacolo con ID: 1");
//            rimuoviSpettacolo.rimuoviSpettacoloPerId(1);
//
//            // Stampa finale di tutti gli elementi dopo la rimozione
//            System.out.println("\nElenco aggiornato dei film in programmazione, delle sale e degli spettacoli dopo la rimozione dello spettacolo con ID 1:");
//
//            // Stampa dei film
//            System.out.println("Film:");
//            for (IFilm film : filmInProgrammazione) {
//                System.out.println("ID: " + film.getId() + ", Titolo: " + film.getTitolo());
//            }
//
//            // Stampa delle sale
//            System.out.println("Sale:");
//            for (ISala sala : saleInProgrammazione) {
//                System.out.println("ID: " + sala.getId() + ", Numero Sala: " + sala.getNumeroSala());
//            }
//
//            // Stampa degli spettacoli
//            System.out.println("Spettacoli:");
//            for (ISpettacolo spettacolo : spettacoliInProgrammazione) {
//                System.out.println("ID: " + spettacolo.getId() + ", Film: " + spettacolo.getFilm().getTitolo() + ", Sala: " + spettacolo.getSala().getNumeroSala() + ", Orario: " + spettacolo.getOrarioProiezione());
//            }
//
//
//            // Ri-Aggiunta di 3 spettacoli
//            for (int i = 0; i < 3; i++) {
//                ISpettacolo nuovoSpettacolo = new Spettacolo(filmInProgrammazione.get(i), saleInProgrammazione.get(i), LocalDateTime.now().plusHours(10));
//                aggiungiSpettacolo.aggiungiSpettacolo(nuovoSpettacolo);
//                System.out.println("Aggiunto spettacolo con ID: " + nuovoSpettacolo.getId() + " per il film: " + nuovoSpettacolo.getFilm().getTitolo() + " nella sala: " + nuovoSpettacolo.getSala().getNumeroSala());
//            }
//
//            // Stampa degli spettacoli
//            System.out.println("Spettacoli:");
//            for (ISpettacolo spettacolo : spettacoliInProgrammazione) {
//                System.out.println("ID: " + spettacolo.getId() + ", Film: " + spettacolo.getFilm().getTitolo() + ", Sala: " + spettacolo.getSala().getNumeroSala() + ", Orario: " + spettacolo.getOrarioProiezione());
//            }
//
//
//        } catch (SpettacoloNonTrovatoException e) {
//            System.err.println("Errore: " + e.getMessage());
//        } catch (Exception e) {
//            System.err.println("Errore generico: " + e.getMessage());
//        }
//    }
//}
