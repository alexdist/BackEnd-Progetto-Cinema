package admin_commands.spettacolo.modifica_spettacolo.modifica_sala;

import admin_interfaces.ICommand;
import cinema_Infrastructure.sala.ISala;
import cinema_Infrastructure.spettacolo.gestione_spettacolo.IModificaSpettacolo;
import exception.spettacolo.SpettacoloNonTrovatoException;

public class ModificaSalaPerIdSpettacoloCommand implements ICommand {

    private IModificaSpettacolo edit;
    private ISala sala;

    private long idSpettacolo;

    public ModificaSalaPerIdSpettacoloCommand(IModificaSpettacolo edit, long idSpettacolo, ISala sala){
        this.edit = edit;
        this.idSpettacolo = idSpettacolo;
        this.sala = sala;
    }


    public void execute() throws SpettacoloNonTrovatoException {
        edit.modificaSalaPerIdSpettacolo(idSpettacolo, sala);
    }
}
