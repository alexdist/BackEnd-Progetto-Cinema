package admin_commands.spettacolo.modifica_spettacolo.modifica_orario;

import admin_interfaces.ICommand;
import cinema_Infrastructure.spettacolo.gestione_spettacolo.IModificaSpettacolo;
import exception.spettacolo.SpettacoloNonTrovatoException;

import java.time.LocalDateTime;

// ModificaOrarioPerIdSpettacoloCommand è un ConcreteCommand che implementa ICommand.
// Questo comando si occupa di modificare l'orario di proiezione di uno spettacolo specifico.
public class ModificaOrarioPerIdSpettacoloCommand implements ICommand {

    // Riferimento al Receiver che gestisce la modifica dello spettacolo.
    private IModificaSpettacolo edit;

    // Il nuovo orario di proiezione da impostare per lo spettacolo.
    private LocalDateTime orario;

    // ID dello spettacolo da modificare.
    private long idSpettacolo;

    // Costruttore che inizializza il comando con il Receiver, l'ID dello spettacolo
    // e il nuovo orario di proiezione.
    public ModificaOrarioPerIdSpettacoloCommand(IModificaSpettacolo edit, long idSpettacolo, LocalDateTime orario){
        this.edit = edit;
        this.idSpettacolo = idSpettacolo;
        this.orario = orario;
    }

    // Metodo execute che chiama il Receiver per eseguire l'azione di modifica dell'orario dello spettacolo.
    // Lancia un'eccezione se lo spettacolo con l'ID specificato non viene trovato.
    public void execute() throws SpettacoloNonTrovatoException {
        edit.modificaOrarioProiezionePerIdSpettacolo(idSpettacolo, orario);
    }
}
