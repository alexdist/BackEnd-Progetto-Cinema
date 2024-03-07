package cinema_Infrastructure.film.gestione_film;

import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.film.gestione_film.IRimuoviFilm;
import exception.film.FilmNonTrovatoException;

import java.util.List;

public class RimuoviFilm implements IRimuoviFilm {
    private List<IFilm> filmInProgrammazione; // Usa l'interfaccia IFilm

    public RimuoviFilm(List<IFilm> filmInProgrammazione) {
        this.filmInProgrammazione = filmInProgrammazione;
    }

    // Verifica se esiste un film con l'ID specificato
    private boolean esisteFilmPerId(long idFilm) {
        return filmInProgrammazione.stream()
                .anyMatch(film -> film.getId() == idFilm);
    }

    @Override
    public void rimuoviFilmPerId(long idFilm) throws FilmNonTrovatoException {
        boolean esisteFilm = esisteFilmPerId(idFilm);
        if (esisteFilm) {
            filmInProgrammazione.removeIf(film -> film.getId() == idFilm);
            System.out.println("Film con ID: " + idFilm + " rimosso con successo.");
        } else {
            throw new FilmNonTrovatoException("Film con ID: " + idFilm + " non trovato.");
        }
    }
}



