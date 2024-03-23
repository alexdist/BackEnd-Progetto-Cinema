package cinema_Infrastructure.film.gestione_film;

import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.film.ValidatoreFilm;
import exception.film.FilmGiaPresenteException;
import exception.film.DurataFilmNonValidaException;
import exception.film.TitoloVuotoException;
import prova_id_PERSISTENTE.IGeneratoreIDPersistente;
import java.util.ArrayList;
import java.util.List;

public class AggiungiFilm implements IAggiungiFilm {
   IGeneratoreIDPersistente generatoreID;
    private List<IFilm> filmInProgrammazione; // Usa l'interfaccia IFilm


    public AggiungiFilm(List<IFilm> filmInProgrammazione, IGeneratoreIDPersistente generatoreID) {
        this.filmInProgrammazione = filmInProgrammazione;
        this.generatoreID = generatoreID;
    }


    @Override
    public void aggiungiFilm(IFilm film) throws FilmGiaPresenteException, TitoloVuotoException, DurataFilmNonValidaException {

        ValidatoreFilm.validaParametri(film);
        ValidatoreFilm.controllaSeFilmEsiste(filmInProgrammazione, film);

        long id = generatoreID.generaProssimoId();
        film.setId(id);
        filmInProgrammazione.add(film);
        System.out.println("Film \"" + film.getTitolo() + "\" aggiunto con successo");
    }


    public List<IFilm> getFilm() {
        return new ArrayList<>(filmInProgrammazione); // Restituisce una copia della lista per evitare modifiche esterne
    }
}

