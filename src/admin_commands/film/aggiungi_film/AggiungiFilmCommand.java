package admin_commands.film.aggiungi_film;

import admin_interfaces.ICommand;
import cinema_Infrastructure.film.Film;

import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.film.ValidatoreFilm;
import cinema_Infrastructure.film.gestione_film.AggiungiFilm;
import cinema_Infrastructure.film.gestione_film.IAggiungiFilm;
import exception.film.DurataFilmNonValidaException;
import exception.film.FilmGiaPresenteException;
import exception.film.TitoloVuotoException;


public class AggiungiFilmCommand implements ICommand {

    private IAggiungiFilm add;
    private IFilm film;

    private int state;

    // Costruttore della classe AggiungiFilmCommand.

    public AggiungiFilmCommand(IAggiungiFilm add, IFilm film) {
        this.add = add;
        this.film = film;

    }

    @Override
    public void execute() throws FilmGiaPresenteException, DurataFilmNonValidaException, TitoloVuotoException {

        add.aggiungiFilm(film);
    }

}