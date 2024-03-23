package admin_commands.sala.rimuovi_sala;

import admin_interfaces.ICommand;
import cinema_Infrastructure.sala.gestione_sala.IRimuoviSala;
import exception.film.FilmNonTrovatoException;
import exception.sala.SalaNonTrovataException;

public class RimuoviSalaCommand implements ICommand {

    private IRimuoviSala remove;

    private long id;

    public RimuoviSalaCommand(IRimuoviSala remove, long id){
        this.remove = remove;
        this.id = id;
    }

    public void execute() throws FilmNonTrovatoException, SalaNonTrovataException {
        remove.rimuoviSalaPerId(id);
    }
}
