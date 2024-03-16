//package admin_commands.film.aggiungi_film;
//
//import admin_commands.film.aggiungi_film.AggiungiFilmCommand;
//import admin_interfaces.ICommand;
//import cinema_Infrastructure.film.Film;
//
//import cinema_Infrastructure.film.IFilm;
//
//import cinema_Infrastructure.film.gestione_film.AggiungiFilm;
//import cinema_Infrastructure.film.gestione_film.IAggiungiFilm;
//import domain.Amministratore;
//import domain.Ruolo;
//import id_generator_factory.abstract_factory.GeneratoreIDFactory;
//import id_generator_factory.concrete_factories.GeneratoreIDFilmFactory;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestAggiungiFilm {
//    public static void main(String[] args) {
//        try {
//            // Inizializzazione dell'ambiente di test
//            List<IFilm> filmInProgrammazione = new ArrayList<>();
//            GeneratoreIDFactory generatoreIDFilmFactory = new GeneratoreIDFilmFactory();
//            IAggiungiFilm servizioAggiungiFilm = new AggiungiFilm(filmInProgrammazione, generatoreIDFilmFactory);
//
//            // Creazione di un nuovo film da aggiungere
//            IFilm nuovoFilm = new Film("Interstellar", 169, "Sci-fi");
//
//            IFilm nuovoFilm2 = new Film("Fast And Furious", 120, "Azione");
//
//            IFilm nuovoFilm3 = new Film("Una notte da leoni", 110, "Commedia");
//
//            // Creazione del comando per aggiungere il film
//            ICommand aggiungiFilmCommand = new AggiungiFilmCommand(servizioAggiungiFilm, nuovoFilm);
//
//            ICommand aggiungiFilmCommand2 = new AggiungiFilmCommand(servizioAggiungiFilm, nuovoFilm2);
//
//            ICommand aggiungiFilmCommand3 = new AggiungiFilmCommand(servizioAggiungiFilm, nuovoFilm3);
//
//            // Creazione dell'amministratore e assegnazione del comando
//            Amministratore amministratore = new Amministratore("Luca", "Rossi", Ruolo.AMMINISTRATORE);
//
//            //Film 1
//            amministratore.setCommand(aggiungiFilmCommand);
//            // Esecuzione del comando attraverso l'amministratore
//            amministratore.eseguiComando();
//
//            //Film 2
//            amministratore.setCommand(aggiungiFilmCommand2);
//            amministratore.eseguiComando();
//
//            //Film 3
//            amministratore.setCommand(aggiungiFilmCommand3);
//            amministratore.eseguiComando();
//
//            // Stampa dei film in programmazione dopo l'aggiunta
//            System.out.println("Film in programmazione:");
//            for (IFilm film : servizioAggiungiFilm.getFilm()) {
//                System.out.println(film.getTitolo() + " (ID: " + film.getId() + ")");
//            }
//        } catch (Exception e) {
//            // Catch-all per qualsiasi altra eccezione non prevista
//            System.err.println("Errore imprevisto: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}

