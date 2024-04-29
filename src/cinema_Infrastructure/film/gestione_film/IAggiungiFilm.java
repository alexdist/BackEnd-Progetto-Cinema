package cinema_Infrastructure.film.gestione_film;

import cinema_Infrastructure.film.IFilm;
import exception.film.FilmGiaPresenteException;
import exception.film.DurataFilmNonValidaException;
import exception.film.TitoloVuotoException;

import java.io.IOException;
import java.util.List;

// IAggiungiFilm agisce come 'Receiver' nel pattern Command.
// Questa interfaccia dichiara i metodi che saranno implementati per aggiungere un film
// e recuperare la lista dei film esistenti.
public interface IAggiungiFilm {

    // Metodo per aggiungere un film alla programmazione.
    // Il film da aggiungere è passato come parametro.
    // Può sollevare eccezioni se il film è già presente, se il titolo è vuoto,
    // se la durata non è valida o se si verifica un errore di I/O.
    void aggiungiFilm(IFilm film) throws FilmGiaPresenteException, TitoloVuotoException, DurataFilmNonValidaException, IOException;

    // Metodo per ottenere l'elenco dei film attualmente in programmazione.
    // Restituisce una lista di film, permettendo così di interrogare
    // quali film sono stati precedentemente aggiunti.
    List<IFilm> getFilm();
}
