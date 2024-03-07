package cinema_Infrastructure.film.gestione_film;

import exception.film.FilmNonTrovatoException;

public interface IRimuoviFilm {
    void rimuoviFilmPerId(long idFilm) throws FilmNonTrovatoException;
}
