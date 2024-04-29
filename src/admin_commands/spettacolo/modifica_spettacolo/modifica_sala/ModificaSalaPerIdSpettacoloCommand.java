package admin_commands.spettacolo.modifica_spettacolo.modifica_sala;

import admin_interfaces.ICommand;
import cinema_Infrastructure.sala.ISala;
import cinema_Infrastructure.spettacolo.gestione_spettacolo.IModificaSpettacolo;
import exception.spettacolo.SpettacoloNonTrovatoException;

// ModificaSalaPerIdSpettacoloCommand è un ConcreteCommand che implementa l'interfaccia ICommand.
// Questo comando è responsabile della modifica della sala assegnata a uno spettacolo specifico.
public class ModificaSalaPerIdSpettacoloCommand implements ICommand {

    // Riferimento al Receiver che gestisce la modifica dello spettacolo.
    private IModificaSpettacolo edit;

    // La nuova Sala da impostare per lo spettacolo
    private ISala sala;

    // ID dello spettacolo da modificare.
    private long idSpettacolo;

    // Costruttore che inizializza il comando con il Receiver, l'ID dello spettacolo
    // e la nuova Sala.
    public ModificaSalaPerIdSpettacoloCommand(IModificaSpettacolo edit, long idSpettacolo, ISala sala){
        this.edit = edit;
        this.idSpettacolo = idSpettacolo;
        this.sala = sala;
    }

    // Metodo execute che chiama il Receiver per eseguire l'azione di modifica della Sala dello spettacolo.
    // Lancia un'eccezione se lo spettacolo con l'ID specificato non viene trovato.
    public void execute() throws SpettacoloNonTrovatoException {
        edit.modificaSalaPerIdSpettacolo(idSpettacolo, sala);
    }
}
