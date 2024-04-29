package admin_commands.film.aggiungi_film;

import admin_interfaces.ICommand;
import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.film.gestione_film.IAggiungiFilm;
import exception.film.DurataFilmNonValidaException;
import exception.film.FilmGiaPresenteException;
import exception.film.TitoloVuotoException;

import java.io.IOException;

// AggiungiFilmCommand è un 'ConcreteCommand' che implementa l'interfaccia ICommand.
// Questa classe definisce l'azione di aggiunta di un film alla programmazione.
public class AggiungiFilmCommand implements ICommand {

    // Riferimento all'interfaccia del Receiver che sa come eseguire l'azione.
    private IAggiungiFilm add;

    // Il film da aggiungere, rappresentato dall'interfaccia IFilm.
    private IFilm film;

    // Costruttore che associa il Receiver e il film al comando concreto.
    // Questi parametri sono necessari per l'esecuzione del comando.
    public AggiungiFilmCommand(IAggiungiFilm add, IFilm film) {
        this.add = add;
        this.film = film;
    }

    // Metodo execute che, quando chiamato, eseguirà l'azione di aggiungere il film
    // tramite il Receiver. Questo metodo può sollevare eccezioni specifiche
    // relative all'aggiunta di un film.
    @Override
    public void execute() throws FilmGiaPresenteException, DurataFilmNonValidaException, TitoloVuotoException, IOException {

        add.aggiungiFilm(film);
    }

}