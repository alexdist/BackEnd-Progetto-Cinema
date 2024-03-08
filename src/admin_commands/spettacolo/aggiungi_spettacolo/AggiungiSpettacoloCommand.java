package admin_commands.spettacolo.aggiungi_spettacolo;

import admin_interfaces.ICommand;
import cinema_Infrastructure.spettacolo.ISpettacolo;
import cinema_Infrastructure.spettacolo.gestione_spettacolo.IAggiungiSpettacolo;
import exception.FilmNonValidoException;
import exception.SalaNonValidaException;
import exception.spettacolo.SovrapposizioneSpettacoloException;

public class AggiungiSpettacoloCommand implements ICommand {

    private IAggiungiSpettacolo add;

    private ISpettacolo spettacolo;

    public AggiungiSpettacoloCommand(IAggiungiSpettacolo add, ISpettacolo spettacolo){
        this.add = add;
        this.spettacolo = spettacolo;
    }

    public void execute() throws SovrapposizioneSpettacoloException, FilmNonValidoException, SalaNonValidaException {
        add.aggiungiSpettacolo(spettacolo);
    }

}
