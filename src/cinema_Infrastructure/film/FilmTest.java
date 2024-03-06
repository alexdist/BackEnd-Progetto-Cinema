package cinema_Infrastructure.film;

import exception.film.FilmGiaPresenteException;
import exception.film.DurataFilmNonValidaException;
import exception.film.TitoloVuotoException;

import java.util.ArrayList;

public class FilmTest {

    public static void main(String[] args) {
        // Inizializza il generatore di ID
        IGeneratoreIDFilm generatoreID = GeneratoreIDFilm.getInstance();

        // Inizializza la lista di film in programmazione
        ArrayList<Film> filmInProgrammazione = new ArrayList<>();

        // Inizializza AggiungiFilm con la lista e il generatore di ID
        IAggiungiFilm aggiungiFilm = new AggiungiFilm(filmInProgrammazione, generatoreID);

        // Crea alcuni film senza assegnare direttamente l'ID
        Film film1 = new Film("Interstellar", 120);
        Film film2 = new Film("Inception", 140);
        Film film3 = new Film("Interstellar", 150);
        Film film4 = new Film("Una notte da leoni", 110);

        // Prova ad aggiungere i film alla programmazione
        try {
            aggiungiFilm.aggiungiFilm(film1);
            System.out.println("Aggiunto: " + film1.getTitolo() + " con ID: " + film1.getId());
        } catch (FilmGiaPresenteException | TitoloVuotoException | DurataFilmNonValidaException e) {
            System.out.println("Errore nell'aggiungere " + film1.getTitolo() + ": " + e.getMessage());
        }

        try {
            aggiungiFilm.aggiungiFilm(film2);
            System.out.println("Aggiunto: " + film2.getTitolo() + " con ID: " + film2.getId());
        } catch (FilmGiaPresenteException | TitoloVuotoException | DurataFilmNonValidaException e) {
            System.out.println("Errore nell'aggiungere " + film2.getTitolo() + ": " + e.getMessage());
        }

        // Tentativo di aggiungere nuovamente il film1 per testare la gestione dei duplicati
        try {
            aggiungiFilm.aggiungiFilm(film3); // Questo è corretto per testare l'aggiunta di un film con lo stesso titolo
            System.out.println("Aggiunto: " + film3.getTitolo() + " con ID: " + film3.getId());
        } catch (FilmGiaPresenteException | TitoloVuotoException | DurataFilmNonValidaException e) {
            System.out.println("Tentativo di aggiungere nuovamente il film '" + film3.getTitolo() + "': " + e.getMessage());
        }

        try {
            aggiungiFilm.aggiungiFilm(film4);
            System.out.println("Aggiunto: " + film4.getTitolo() + " con ID: " + film4.getId());
        } catch (FilmGiaPresenteException | TitoloVuotoException | DurataFilmNonValidaException e) {
            System.out.println("Errore nell'aggiungere " + film4.getTitolo() + ": " + e.getMessage());
        }

        // Stampa la lista di film in programmazione per verificare l'aggiunta
        System.out.println("\nFilm in programmazione:");
        filmInProgrammazione.forEach(film -> System.out.println("- " + film.getTitolo() + " (ID: " + film.getId() + ")"));

        //Rimozione di un film dalla lista dei film in programmazione
        IRimuoviFilm rimuovi = new RimuoviFilm(filmInProgrammazione);
        rimuovi.rimuoviFilm(1);


        // Stampa la lista di film in programmazione per verificare l'aggiunta
        System.out.println("\nFilm in programmazione:");
        filmInProgrammazione.forEach(film -> System.out.println("- " + film.getTitolo() + " (ID: " + film.getId() + ")"));



    }
}

