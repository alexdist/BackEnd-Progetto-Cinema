package cinema_Infrastructure.film;

import java.util.List;
import java.util.Optional;

public class RimuoviFilm implements IRimuoviFilm{

    private List<Film> filmInProgrammazione;

    public RimuoviFilm(List<Film> filmInProgrammazione) {
        this.filmInProgrammazione = filmInProgrammazione;
    }

    public boolean rimuoviFilm(long idFilm) {
        // Ricerca il film con l'ID specificato nella lista dei film in programmazione
        Optional<Film> filmDaRimuovere = filmInProgrammazione.stream()
                .filter(film -> film.getId() == idFilm)
                .findFirst();
        // Se il film è presente, viene rimosso dalla lista e restituisce true
        if (filmDaRimuovere.isPresent()) {
            filmInProgrammazione.remove(filmDaRimuovere.get());
            System.out.println("Film con ID: " + idFilm + " rimosso con successo.");
            return true;
        } else {
            // Se il film non è trovato, restituisce false
            System.out.println("Film con ID: " + idFilm + " non trovato.");
            return false;
        }
    }
}
