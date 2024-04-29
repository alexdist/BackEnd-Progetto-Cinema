package cinema_Infrastructure.film.gestione_film;

import exception.film.FilmNonTrovatoException;

// IRimuoviFilm agisce come 'Receiver' nel pattern Command.
// Questa interfaccia dichiara i metodi che saranno implementati per rimuovere un film.
public interface IRimuoviFilm {
    void rimuoviFilmPerId(long idFilm) throws FilmNonTrovatoException;
}
