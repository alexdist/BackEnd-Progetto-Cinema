package admin_commands.film.elimina_film;

import admin_interfaces.ICommand;
import cinema_Infrastructure.film.gestione_film.IRimuoviFilm;
import exception.film.FilmNonTrovatoException;

public class RimuoviFilmCommand implements ICommand {

    private IRimuoviFilm remove;
    private long id;

    public RimuoviFilmCommand(IRimuoviFilm remove, long id){
        this.remove = remove;
        this.id = id;
    }

    public void execute() throws FilmNonTrovatoException {
        remove.rimuoviFilmPerId(id);
    }
}
