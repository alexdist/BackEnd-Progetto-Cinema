package cinema_Infrastructure.film.gestione_film;

import cinema_Infrastructure.film.IFilm;
import exception.film.FilmNonTrovatoException;
import java.util.List;

// RimuoviFilm è la classe concreta che implementa l'interfaccia IRimuoviFilm,
// agendo come il 'Receiver' nel pattern Command.
// Ha il compito di gestire la rimozione dei film alla programmazione.
public class RimuoviFilm implements IRimuoviFilm {

    // Lista dei film in programmazione.
    private List<IFilm> filmInProgrammazione; // Usa l'interfaccia IFilm

    // Costruttore che inizializza la classe con una lista di film.
    public RimuoviFilm(List<IFilm> filmInProgrammazione) {
        this.filmInProgrammazione = filmInProgrammazione;
    }

    // Verifica se esiste un film con l'ID specificato
    private boolean esisteFilmPerId(long idFilm) {
        return filmInProgrammazione.stream()
                .anyMatch(film -> film.getId() == idFilm);
    }

    // Implementazione del metodo per rimuovere un film tramite ID.
    // Se il film esiste, viene rimosso dalla lista. Altrimenti, viene lanciata un'eccezione.
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



