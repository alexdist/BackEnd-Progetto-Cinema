package admin_commands.film.aggiungi_film;

import admin_interfaces.ICommand;
import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.film.gestione_film.IAggiungiFilm;
import exception.film.DurataFilmNonValidaException;
import exception.film.FilmGiaPresenteException;
import exception.film.TitoloVuotoException;

public class AggiungiFilmCommand implements ICommand {

    private IAggiungiFilm add;
    private IFilm film;


    public AggiungiFilmCommand(IAggiungiFilm add, IFilm film) {
        this.add = add;
        this.film = film;
    }

    @Override
    public void execute() throws FilmGiaPresenteException, DurataFilmNonValidaException, TitoloVuotoException {

        add.aggiungiFilm(film);
    }

}