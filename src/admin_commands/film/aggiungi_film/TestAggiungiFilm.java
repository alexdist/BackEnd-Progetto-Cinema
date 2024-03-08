package admin_commands.film.aggiungi_film;

import admin_commands.film.aggiungi_film.AggiungiFilmCommand;
import admin_interfaces.ICommand;
import cinema_Infrastructure.film.Film;
import cinema_Infrastructure.film.GeneratoreIDFilm;
import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.film.IGeneratoreIDFilm;
import cinema_Infrastructure.film.gestione_film.AggiungiFilm;
import cinema_Infrastructure.film.gestione_film.IAggiungiFilm;
import domain.Amministratore;
import domain.Ruolo;

import java.util.ArrayList;
import java.util.List;

public class TestAggiungiFilm {
    public static void main(String[] args) {
        try {
            // Inizializzazione dell'ambiente di test
            List<IFilm> filmInProgrammazione = new ArrayList<>();
            IGeneratoreIDFilm generatoreID = GeneratoreIDFilm.getInstance();
            IAggiungiFilm servizioAggiungiFilm = new AggiungiFilm(filmInProgrammazione, generatoreID);

            // Creazione di un nuovo film da aggiungere
            IFilm nuovoFilm = new Film("Interstellar", 169, "Sci-fi");

            // Creazione del comando per aggiungere il film
            ICommand aggiungiFilmCommand = new AggiungiFilmCommand(servizioAggiungiFilm, nuovoFilm);

            // Creazione dell'amministratore e assegnazione del comando
            Amministratore amministratore = new Amministratore("Luca", "Rossi", Ruolo.AMMINISTRATORE);
            amministratore.setCommand(aggiungiFilmCommand);

            // Esecuzione del comando attraverso l'amministratore
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

