package cinema_Infrastructure.film.gestione_film;

import cinema_Infrastructure.film.IFilm;
import exception.film.FilmGiaPresenteException;
import exception.film.DurataFilmNonValidaException;
import exception.film.TitoloVuotoException;

import java.util.List;

public interface IAggiungiFilm {
    void aggiungiFilm(IFilm film) throws FilmGiaPresenteException, TitoloVuotoException, DurataFilmNonValidaException;
    List<IFilm> getFilm();
}
