package admin_commands.spettacolo.rimuovi_spettacolo;

import admin_interfaces.ICommand;
import cinema_Infrastructure.spettacolo.gestione_spettacolo.IRimuoviSpettacolo;
import exception.spettacolo.SpettacoloNonTrovatoException;

// RimuoviSpettacoloCommand è un 'ConcreteCommand' che implementa l'interfaccia ICommand.
// Questa classe definisce l'azione di rimozione di una Spettacolo.
public class RimuoviSpettacoloCommand implements ICommand {

    // Riferimento all'interfaccia del Receiver che sa come eseguire l'azione di rimozione dello Spettacolo.
    private IRimuoviSpettacolo remove;

    // Identificativo dello Spettacolo da rimuovere.
    private long id;

    // Costruttore che inizializza il comando con il Receiver e l'ID dello Spettacolo da rimuovere.
    public RimuoviSpettacoloCommand(IRimuoviSpettacolo remove, long id){
        this.remove = remove;
        this.id = id;
    }

    // Metodo execute che, quando invocato, chiama il metodo di rimozione dello Spettacolo sul Receiver.
    // Questo metodo può lanciare un'eccezione nel caso in cui lo Spettacolo con l'ID specificato
    // non venga trovato.
    public void execute() throws SpettacoloNonTrovatoException {
        remove.rimuoviSpettacoloPerId(id);
    }
}
