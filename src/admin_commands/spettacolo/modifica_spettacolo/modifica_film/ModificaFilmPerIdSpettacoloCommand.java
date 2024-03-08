package admin_commands.spettacolo.modifica_spettacolo.modifica_film;

import admin_interfaces.ICommand;
import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.sala.ISala;
import cinema_Infrastructure.spettacolo.gestione_spettacolo.IModificaSpettacolo;
import exception.spettacolo.SpettacoloNonTrovatoException;

public class ModificaFilmPerIdSpettacoloCommand implements ICommand {

    private IModificaSpettacolo edit;
    private IFilm film;

    private long idSpettacolo;

    public ModificaFilmPerIdSpettacoloCommand(IModificaSpettacolo edit, long idSpettacolo, IFilm film){
        this.edit = edit;
        this.idSpettacolo = idSpettacolo;
        this.film = film;
    }


    public void execute() throws SpettacoloNonTrovatoException {
        edit.modificaFilmPerIdSpettacolo(idSpettacolo, film);
    }



}
