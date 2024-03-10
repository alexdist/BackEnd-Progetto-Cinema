package admin_commands.film.elimina_film;

import admin_commands.film.aggiungi_film.AggiungiFilmCommand;
import admin_interfaces.ICommand;
import cinema_Infrastructure.film.Film;

import cinema_Infrastructure.film.IFilm;

import cinema_Infrastructure.film.gestione_film.AggiungiFilm;
import cinema_Infrastructure.film.gestione_film.IAggiungiFilm;
import cinema_Infrastructure.film.gestione_film.IRimuoviFilm;
import cinema_Infrastructure.film.gestione_film.RimuoviFilm;
import domain.Amministratore;
import domain.Ruolo;
import id_generator_factory.abstract_factory.GeneratoreIDFactory;
import id_generator_factory.concrete_factories.GeneratoreIDFilmFactory;

import java.util.ArrayList;
import java.util.List;

public class TestRimuoviFilm {
    public static void main(String[] args) {
        try {
            // Inizializzazione dell'ambiente di test
            List<IFilm> filmInProgrammazione = new ArrayList<>();
            GeneratoreIDFactory generatoreIDFilmFactory = new GeneratoreIDFilmFactory();
            IAggiungiFilm servizioAggiungiFilm = new AggiungiFilm(filmInProgrammazione,generatoreIDFilmFactory);

            // Creazione di un nuovo film da aggiungere
            IFilm nuovoFilm = new Film("Interstellar", 169, "Sci-fi");
            IFilm nuovoFIlm2 = new Film("Ciao",120,"Azione");

            // Creazione del comando per aggiungere il film1
            ICommand aggiungiFilmCommand = new AggiungiFilmCommand(servizioAggiungiFilm, nuovoFilm);

            //Creazione del comando per aggiungere il film2
            ICommand aggiungiFilmCommand2 = new AggiungiFilmCommand(servizioAggiungiFilm, nuovoFIlm2);

            // Creazione dell'amministratore e assegnazione del comando
            Amministratore amministratore = new Amministratore("Luca", "Rossi", Ruolo.AMMINISTRATORE);
            amministratore.setCommand(aggiungiFilmCommand);

            // Esecuzione del 1 comando attraverso l'amministratore
            amministratore.eseguiComando();

            //Assegnazione del secondo comando
            amministratore.setCommand(aggiungiFilmCommand2);


            // Esecuzione del 2 comando
            amministratore.eseguiComando();

            // Stampa dei film in programmazione dopo l'aggiunta
            System.out.println("Film in programmazione:");
            for (IFilm film : servizioAggiungiFilm.getFilm()) {
                System.out.println(film.getTitolo() + " (ID: " + film.getId() + ")");
            }


            //ELIMINA IL FILM
            IRimuoviFilm servizioEliminaFilm = new RimuoviFilm(filmInProgrammazione);
            ICommand rimuoviFilmCommand = new RimuoviFilmCommand(servizioEliminaFilm, 0);

            amministratore.setCommand(rimuoviFilmCommand);
            amministratore.eseguiComando();

            // Stampa dei film in programmazione dopo l'aggiunta
            System.out.println("Film in programmazione:");
            for (IFilm film : servizioAggiungiFilm.getFilm()) {
                System.out.println(film.getTitolo() + " (ID: " + film.getId() + ")");
            }


        } catch (Exception e) {
            // Catch-all per qualsiasi altra eccezione non prevista
            System.err.println("Errore imprevisto: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
