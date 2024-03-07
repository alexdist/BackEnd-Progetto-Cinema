package cinema_Infrastructure.film.gestione_film;

import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.film.IGeneratoreIDFilm;
import cinema_Infrastructure.film.ValidatoreFilm;
import exception.film.FilmGiaPresenteException;
import exception.film.DurataFilmNonValidaException;
import exception.film.TitoloVuotoException;

import java.util.ArrayList;
import java.util.List;
public class AggiungiFilm implements IAggiungiFilm {
    private IGeneratoreIDFilm generatoreID;
    private List<IFilm> filmInProgrammazione; // Usa l'interfaccia IFilm

    public AggiungiFilm(List<IFilm> filmInProgrammazione, IGeneratoreIDFilm generatoreID) {
        this.filmInProgrammazione = filmInProgrammazione;
        this.generatoreID = generatoreID;
    }

    public AggiungiFilm(List<IFilm> filmInProgrammazione) {
        this.filmInProgrammazione = filmInProgrammazione;

    }

    @Override
    public void aggiungiFilm(IFilm film) throws FilmGiaPresenteException, TitoloVuotoException, DurataFilmNonValidaException {
        // Assumi che ValidatoreFilm sia stato aggiornato per lavorare con IFilm
        ValidatoreFilm.validaParametri(film);
        ValidatoreFilm.controllaSeFilmEsiste(filmInProgrammazione, film);

        // Dopo aver superato le validazioni, genera un ID e aggiunge il film
        long id = generatoreID.generaProssimoId();
        film.setId(id);
        filmInProgrammazione.add(film);
        System.out.println("Film \"" + film.getTitolo() + "\" aggiunto con successo con ID: " + id);
    }

    public List<IFilm> getFilm() {
        return new ArrayList<>(filmInProgrammazione); // Restituisce una copia della lista per evitare modifiche esterne
    }
}

