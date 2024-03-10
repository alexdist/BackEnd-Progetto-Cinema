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

import java.util.ArrayList;
import java.util.List;
public class AggiungiFilm implements IAggiungiFilm {
//    private IGeneratoreIDFilm generatoreID;
//
//    private List<IFilm> filmInProgrammazione; // Usa l'interfaccia IFilm
//
//    public AggiungiFilm(List<IFilm> filmInProgrammazione, IGeneratoreIDFilm generatoreID) {
//        this.filmInProgrammazione = filmInProgrammazione;
//        this.generatoreID = generatoreID;
//    }
//
//    public AggiungiFilm(List<IFilm> filmInProgrammazione) {
//        this.filmInProgrammazione = filmInProgrammazione;
//
//    }

    private GeneratoreIDFactory generatoreIDFactory;
    private List<IFilm> filmInProgrammazione; // Usa l'interfaccia IFilm

    // Il costruttore ora accetta una factory per i generatori di ID
    public AggiungiFilm(List<IFilm> filmInProgrammazione, GeneratoreIDFactory generatoreIDFactory) {
        this.filmInProgrammazione = filmInProgrammazione;
        this.generatoreIDFactory = generatoreIDFactory;
    }

//    @Override
//    public void aggiungiFilm(IFilm film) throws FilmGiaPresenteException, TitoloVuotoException, DurataFilmNonValidaException {
//        // Assumi che ValidatoreFilm sia stato aggiornato per lavorare con IFilm
//        ValidatoreFilm.validaParametri(film);
//        ValidatoreFilm.controllaSeFilmEsiste(filmInProgrammazione, film);
//
//        // Dopo aver superato le validazioni, genera un ID e aggiunge il film
//        long id = generatoreID.generaProssimoId();
//        film.setId(id);
//        filmInProgrammazione.add(film);
//        System.out.println("Film \"" + film.getTitolo() + "\" aggiunto con successo");
//    }

    @Override
    public void aggiungiFilm(IFilm film) throws FilmGiaPresenteException, TitoloVuotoException, DurataFilmNonValidaException {
        // Assumi che ValidatoreFilm sia stato aggiornato per lavorare con IFilm
        ValidatoreFilm.validaParametri(film);
        ValidatoreFilm.controllaSeFilmEsiste(filmInProgrammazione, film);

        // Usa la factory per ottenere un generatore di ID e genera il prossimo ID
        IGeneratoreID generatoreID = generatoreIDFactory.creaGeneratoreID();
        long id = generatoreID.generaProssimoId();
        film.setId(id);
        filmInProgrammazione.add(film);
        System.out.println("Film \"" + film.getTitolo() + "\" aggiunto con successo");
    }


    public List<IFilm> getFilm() {
        return new ArrayList<>(filmInProgrammazione); // Restituisce una copia della lista per evitare modifiche esterne
    }
}

