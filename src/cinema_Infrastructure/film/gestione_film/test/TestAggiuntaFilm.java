//package cinema_Infrastructure.film.gestione_film.test;
//
//import cinema_Infrastructure.film.Film;
//import cinema_Infrastructure.film.IFilm;
//import cinema_Infrastructure.film.gestione_film.AggiungiFilm;
//import id_generator_factory.abstract_factory.GeneratoreIDFactory;
//import id_generator_factory.concrete_factories.GeneratoreIDFilmFactory;
//
//import java.util.ArrayList;
//
//public class TestAggiuntaFilm {
//    public static void main(String[] args) {
//        // Creazione di una lista vuota per i film in programmazione
//        ArrayList<IFilm> filmInProgrammazione = new ArrayList<>();
//
//        // Creazione della factory per i generatori di ID dei film
//        GeneratoreIDFactory generatoreIDFactory = new GeneratoreIDFilmFactory();
//
//        // Creazione dell'oggetto AggiungiFilm
//        AggiungiFilm aggiungiFilm = new AggiungiFilm(filmInProgrammazione, generatoreIDFactory);
//
//        try {
//            // Aggiunta di tre film utilizzando AggiungiFilm
//            IFilm film1 = new Film("Il Signore degli Anelli", 178, "Fantasy");
//            aggiungiFilm.aggiungiFilm(film1);
//            System.out.println("Aggiunto: " + film1.getTitolo() + " con ID: " + film1.getId());
//
//            IFilm film2 = new Film("Inception", 148, "Sci-Fi");
//            aggiungiFilm.aggiungiFilm(film2);
//            System.out.println("Aggiunto: " + film2.getTitolo() + " con ID: " + film2.getId());
//
//            IFilm film3 = new Film("Interstellar", 169, "Sci-Fi");
//            aggiungiFilm.aggiungiFilm(film3);
//            System.out.println("Aggiunto: " + film3.getTitolo() + " con ID: " + film3.getId());
//        } catch (Exception e) {
//            System.err.println("Errore durante l'aggiunta di film: " + e.getMessage());
//        }
//
//        // Stampa dei film aggiunti per verificare
//        System.out.println("\nFilm in programmazione:");
//        for (IFilm film : aggiungiFilm.getFilm()) {
//            System.out.println(film.getTitolo() + " - ID: " + film.getId());
//        }
//    }
//}
