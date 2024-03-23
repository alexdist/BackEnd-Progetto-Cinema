package admin_commands.spettacolo.modifica_spettacolo.modifica_orario;

import admin_interfaces.ICommand;
import cinema_Infrastructure.spettacolo.gestione_spettacolo.IModificaSpettacolo;
import exception.spettacolo.SpettacoloNonTrovatoException;

import java.time.LocalDateTime;

public class ModificaOrarioPerIdSpettacoloCommand implements ICommand {

    private IModificaSpettacolo edit;
    private LocalDateTime orario;

    private long idSpettacolo;

    public ModificaOrarioPerIdSpettacoloCommand(IModificaSpettacolo edit, long idSpettacolo, LocalDateTime orario){
        this.edit = edit;
        this.idSpettacolo = idSpettacolo;
        this.orario = orario;
    }


    public void execute() throws SpettacoloNonTrovatoException {
        edit.modificaOrarioProiezionePerIdSpettacolo(idSpettacolo, orario);
    }
}
