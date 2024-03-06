package admin_commands.aggiungi_film;

import cinema_Infrastructure.film.Film;
import exception.film.FilmGiaPresenteException;

public interface AggiungiFilm {
    void aggiungiFilm(Film film);
}
