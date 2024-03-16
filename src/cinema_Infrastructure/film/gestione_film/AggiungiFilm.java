package cinema_Infrastructure.film.gestione_film;

import Serializzazione.adapter.adaptee.FilmSerializer;
import Serializzazione.adapter.adapter.FilmSerializerAdapter;
import Serializzazione.adapter.target.IDataSerializer;
import cinema_Infrastructure.film.IFilm;
//import cinema_Infrastructure.film.IGeneratoreIDFilm;
import cinema_Infrastructure.film.ValidatoreFilm;
import exception.film.FilmGiaPresenteException;
import exception.film.DurataFilmNonValidaException;
import exception.film.TitoloVuotoException;
import id_generator_factory.abstract_factory.GeneratoreIDFactory;
import id_generator_factory.product.IGeneratoreID;
import prova_id_PERSISTENTE.IGeneratoreIDPersistente;

import java.util.ArrayList;
import java.util.List;
public class AggiungiFilm implements IAggiungiFilm {


   // private GeneratoreIDFactory generatoreIDFactory;
   IGeneratoreIDPersistente generatoreID;
    private List<IFilm> filmInProgrammazione; // Usa l'interfaccia IFilm
    private static final String FILE_PATH = "film.ser"; // Definisce il percorso del file

    // Il costruttore ora accetta una factory per i generatori di ID
    public AggiungiFilm(List<IFilm> filmInProgrammazione, IGeneratoreIDPersistente generatoreID) {
        this.filmInProgrammazione = filmInProgrammazione;
        this.generatoreID = generatoreID;
    }


    @Override
    public void aggiungiFilm(IFilm film) throws FilmGiaPresenteException, TitoloVuotoException, DurataFilmNonValidaException {
        // Assumi che ValidatoreFilm sia stato aggiornato per lavorare con IFilm
        ValidatoreFilm.validaParametri(film);
        ValidatoreFilm.controllaSeFilmEsiste(filmInProgrammazione, film);

        // Usa la factory per ottenere un generatore di ID e genera il prossimo ID
       // IGeneratoreID generatoreID = generatoreIDFactory.creaGeneratoreID();
        long id = generatoreID.generaProssimoId();
        film.setId(id);
        filmInProgrammazione.add(film);
        System.out.println("Film \"" + film.getTitolo() + "\" aggiunto con successo");
    }


    public List<IFilm> getFilm() {
        return new ArrayList<>(filmInProgrammazione); // Restituisce una copia della lista per evitare modifiche esterne
    }
}

