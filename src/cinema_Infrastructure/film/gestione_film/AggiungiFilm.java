package cinema_Infrastructure.film.gestione_film;

import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.film.ValidatoreFilm;
import exception.film.FilmGiaPresenteException;
import exception.film.DurataFilmNonValidaException;
import exception.film.TitoloVuotoException;
import ID_persistente.IGeneratoreIDPersistente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// AggiungiFilm è la classe concreta che implementa l'interfaccia IAggiungiFilm,
// agendo come il 'Receiver' nel pattern Command.
// Ha il compito di gestire l'aggiunta di nuovi film alla programmazione.
public class AggiungiFilm implements IAggiungiFilm {

    // Componente per la generazione di ID persistenti, utile per assegnare un identificativo univoco ad ogni film.
    IGeneratoreIDPersistente generatoreID;

    // Lista che tiene traccia dei film attualmente in programmazione.
    private List<IFilm> filmInProgrammazione; // Usa l'interfaccia IFilm

    // Costruttore che inizializza la classe con una lista esistente di film e un generatore di ID.
    public AggiungiFilm(List<IFilm> filmInProgrammazione, IGeneratoreIDPersistente generatoreID) {
        this.filmInProgrammazione = filmInProgrammazione;
        this.generatoreID = generatoreID;
    }

    // Implementazione del metodo per aggiungere un film alla programmazione.
    // Prima di aggiungere il film, valida i suoi parametri e controlla che non sia già presente.
    // Se il film è valido e non presente, gli viene assegnato un ID e viene aggiunto alla lista.
    @Override
    public void aggiungiFilm(IFilm film) throws FilmGiaPresenteException, TitoloVuotoException, DurataFilmNonValidaException, IOException {

        ValidatoreFilm.validaParametri(film);
        ValidatoreFilm.controllaSeFilmEsiste(filmInProgrammazione, film);

        long id = generatoreID.generaProssimoId();
        film.setId(id);
        filmInProgrammazione.add(film);
        System.out.println("Film \"" + film.getTitolo() + "\" aggiunto con successo");
    }

    // Metodo che restituisce una lista dei film in programmazione.
    // Per evitare modifiche indesiderate alla lista originale, restituisce una copia della stessa.
    public List<IFilm> getFilm() {
        return new ArrayList<>(filmInProgrammazione); // Restituisce una copia della lista per evitare modifiche esterne
    }
}

