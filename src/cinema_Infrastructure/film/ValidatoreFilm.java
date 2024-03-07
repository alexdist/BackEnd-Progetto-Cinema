package cinema_Infrastructure.film;

import exception.film.FilmGiaPresenteException;
import exception.film.DurataFilmNonValidaException;
import exception.film.TitoloVuotoException;

import java.util.List;

public class ValidatoreFilm {
    // Metodo statico per validare i parametri di un film, incluso il controllo sul titolo
    public static void validaParametri(IFilm film) throws TitoloVuotoException, DurataFilmNonValidaException {
        if (film == null) {
            throw new IllegalArgumentException("Il film non può essere null");
        }
        if (film.getTitolo() == null || film.getTitolo().trim().isEmpty()) {
            throw new TitoloVuotoException("Il titolo del film non può essere vuoto.");
        }
        if (film.getDurata() <= 0) {
            throw new DurataFilmNonValidaException("La durata del film deve essere maggiore di 0 minuti.");
        }
    }

    // Metodo statico per controllare se il film è già presente
    public static void controllaSeFilmEsiste(List<IFilm> filmInProgrammazione, IFilm film) throws FilmGiaPresenteException {
        if (filmInProgrammazione.stream().anyMatch(f -> f.getTitolo().equalsIgnoreCase(film.getTitolo()))) {
            throw new FilmGiaPresenteException("Film \"" + film.getTitolo() + "\" è già presente.");
        }
    }
}

