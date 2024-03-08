package admin_commands.spettacolo.rimuovi_spettacolo;

import admin_interfaces.ICommand;
import cinema_Infrastructure.spettacolo.gestione_spettacolo.IRimuoviSpettacolo;
import exception.spettacolo.SpettacoloNonTrovatoException;

public class RimuoviSpettacoloCommand implements ICommand {


    private IRimuoviSpettacolo remove;

    private long id;

    public RimuoviSpettacoloCommand(IRimuoviSpettacolo remove, long id){
        this.remove = remove;
        this.id = id;
    }

    public void execute() throws SpettacoloNonTrovatoException {
        remove.rimuoviSpettacoloPerId(id);
    }
}
