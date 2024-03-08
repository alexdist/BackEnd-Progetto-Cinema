package admin_commands.sala.aggiungi_sala;

import admin_interfaces.ICommand;
import cinema_Infrastructure.film.gestione_film.IAggiungiFilm;
import cinema_Infrastructure.sala.ISala;
import cinema_Infrastructure.sala.gestione_sala.IAggiungiSala;
import exception.sala.SalaGiaEsistenteException;

public class AggiungiSalaCommand implements ICommand {

    private IAggiungiSala add;

    private ISala sala;

    public AggiungiSalaCommand(IAggiungiSala add, ISala sala){
        this.add = add;
        this.sala = sala;
    }

    public void execute() throws SalaGiaEsistenteException {
        add.aggiungiSala(sala);
    }
}
