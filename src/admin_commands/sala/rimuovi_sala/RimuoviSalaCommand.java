package admin_commands.sala.rimuovi_sala;

import admin_interfaces.ICommand;
import cinema_Infrastructure.sala.gestione_sala.IRimuoviSala;
import exception.film.FilmNonTrovatoException;
import exception.sala.SalaNonTrovataException;

// RimuoviSalaCommand è un 'ConcreteCommand' che implementa l'interfaccia ICommand.
// Questa classe definisce l'azione di rimozione di una Sala.
public class RimuoviSalaCommand implements ICommand {

    // Riferimento all'interfaccia del Receiver che sa come eseguire l'azione di rimozione della Sala.
    private IRimuoviSala remove;

    // Identificativo della Sala da rimuovere.
    private long id;

    // Costruttore che inizializza il comando con il Receiver e l'ID della Sala da rimuovere.
    public RimuoviSalaCommand(IRimuoviSala remove, long id){
        this.remove = remove;
        this.id = id;
    }

    // Metodo execute che, quando invocato, chiama il metodo di rimozione della Sala sul Receiver.
    // Questo metodo può lanciare un'eccezione nel caso in cui la Sala con l'ID specificato
    // non venga trovato.
    public void execute() throws FilmNonTrovatoException, SalaNonTrovataException {
        remove.rimuoviSalaPerId(id);
    }
}
