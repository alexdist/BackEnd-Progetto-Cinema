package cinema_Infrastructure.film;

import exception.film.FilmGiaPresenteException;
import exception.film.DurataFilmNonValidaException;
import exception.film.TitoloVuotoException;

public interface IAggiungiFilm {
    public void aggiungiFilm(Film film) throws FilmGiaPresenteException, TitoloVuotoException, DurataFilmNonValidaException;
}
