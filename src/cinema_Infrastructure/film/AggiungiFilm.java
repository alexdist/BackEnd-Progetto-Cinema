package cinema_Infrastructure.film;

import exception.film.FilmGiaPresenteException;
import exception.film.DurataFilmNonValidaException;
import exception.film.TitoloVuotoException;

import java.util.List;

public class AggiungiFilm implements IAggiungiFilm{
    private IGeneratoreIDFilm generatoreID;

    private List<Film> filmInProgrammazione;

    public AggiungiFilm(List<Film> filmInProgrammazione, IGeneratoreIDFilm generatoreID) {
        this.filmInProgrammazione = filmInProgrammazione;
        this.generatoreID = generatoreID;
    }


    @Override
    public void aggiungiFilm(Film film) throws FilmGiaPresenteException, TitoloVuotoException, DurataFilmNonValidaException {
        // Utilizza ValidatoreFilm per validare i parametri del film
        ValidatoreFilm.validaParametri(film);
        // Utilizza ValidatoreFilm per controllare se il film esiste già
        ValidatoreFilm.controllaSeFilmEsiste(filmInProgrammazione, film);

        // Dopo aver superato le validazioni, genera un ID e aggiunge il film
        long id = generatoreID.generaProssimoId();
        film.setId(id);
        filmInProgrammazione.add(film);
        System.out.println("Film \"" + film.getTitolo() + "\" aggiunto con successo con ID: " + id);
    }
}
