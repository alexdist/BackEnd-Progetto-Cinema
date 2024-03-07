package cinema_Infrastructure.film;

import cinema_Infrastructure.film.gestione_film.AggiungiFilm;
import cinema_Infrastructure.film.gestione_film.IAggiungiFilm;
import cinema_Infrastructure.film.gestione_film.IRimuoviFilm;
import cinema_Infrastructure.film.gestione_film.RimuoviFilm;
import exception.film.FilmGiaPresenteException;
import exception.film.DurataFilmNonValidaException;
import exception.film.FilmNonTrovatoException;
import exception.film.TitoloVuotoException;

import java.util.ArrayList;
import java.util.List;

public class FilmTest {

    public static void main(String[] args) {
        // Inizializza il generatore di ID
        IGeneratoreIDFilm generatoreID = GeneratoreIDFilm.getInstance();

        // Inizializza la lista di film in programmazione come lista di IFilm
        List<IFilm> filmInProgrammazione = new ArrayList<>();

        // Assumeremo che AggiungiFilm ora accetti List<IFilm>
        IAggiungiFilm aggiungiFilm = new AggiungiFilm(filmInProgrammazione, generatoreID);

        // Crea alcuni film senza assegnare direttamente l'ID utilizzando l'interfaccia IFilm
        IFilm film1 = new Film("Interstellar", 120, "Sci-Fi");
        IFilm film2 = new Film("Inception", 140, "Sci-Fi/Thriller");
        IFilm film3 = new Film("Interstellar", 150, "Sci-Fi");
        IFilm film4 = new Film("Una notte da leoni", 110, "Commedia");

        // Segue la logica per aggiungere i film e gestire le eccezioni
        // Prova ad aggiungere i film alla programmazione
        try {
            aggiungiFilm.aggiungiFilm(film1);
            System.out.println("Aggiunto: " + film1.getTitolo() + " Genere: "+film1.getGenere()+" con ID: " + film1.getId());
        } catch (FilmGiaPresenteException | TitoloVuotoException | DurataFilmNonValidaException e) {
            System.out.println("Errore nell'aggiungere " + film1.getTitolo() + ": " + e.getMessage());
        }

        try {
            aggiungiFilm.aggiungiFilm(film2);
            System.out.println("Aggiunto: " + film2.getTitolo() + " Genere: "+film2.getGenere()+" con ID: " + film2.getId());
        } catch (FilmGiaPresenteException | TitoloVuotoException | DurataFilmNonValidaException e) {
            System.out.println("Errore nell'aggiungere " + film2.getTitolo() + ": " + e.getMessage());
        }

        // Tentativo di aggiungere nuovamente il film1 per testare la gestione dei duplicati
        try {
            aggiungiFilm.aggiungiFilm(film3); // Questo è corretto per testare l'aggiunta di un film con lo stesso titolo
            System.out.println("Aggiunto: " + film3.getTitolo() + " Genere: "+film3.getGenere()+" con ID: " + film3.getId());
        } catch (FilmGiaPresenteException | TitoloVuotoException | DurataFilmNonValidaException e) {
            System.out.println("Tentativo di aggiungere nuovamente il film '" + film3.getTitolo() + "': " + e.getMessage());
        }

        try {
            aggiungiFilm.aggiungiFilm(film4);
            System.out.println("Aggiunto: " + film4.getTitolo() + " con ID: " + film4.getId());
        } catch (FilmGiaPresenteException | TitoloVuotoException | DurataFilmNonValidaException e) {
            System.out.println("Errore nell'aggiungere " + film4.getTitolo() + ": " + e.getMessage());
        }

        // Assumeremo che RimuoviFilm ora accetti List<IFilm>
        IRimuoviFilm rimuovi = new RimuoviFilm(filmInProgrammazione);

        // Tentativi di rimozione di film per ID e gestione delle eccezioni

       try {
           rimuovi.rimuoviFilmPerId(5);
       }   catch(FilmNonTrovatoException e){
           System.out.println("Errore nell'eliminare il film " + e.getMessage());
       }

        // Stampa la lista di film in programmazione dopo la rimozione per verificare le modifiche
        System.out.println("\nFilm in programmazione dopo le operazioni:");
        List<IFilm> filmDopoOperazioni = aggiungiFilm.getFilm(); // Utilizza getFilm() che ora restituisce List<IFilm>
        filmDopoOperazioni.forEach(film -> System.out.println("- " + film.getTitolo() + " (ID: " + film.getId() + ")"));
    }
}

