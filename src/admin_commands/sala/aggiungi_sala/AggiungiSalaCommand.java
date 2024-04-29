package admin_commands.sala.aggiungi_sala;

import admin_interfaces.ICommand;
import cinema_Infrastructure.sala.ISala;
import cinema_Infrastructure.sala.gestione_sala.IAggiungiSala;
import exception.sala.SalaGiaEsistenteException;

import java.io.IOException;

// AggiungiSalaCommand è un 'ConcreteCommand' che implementa l'interfaccia ICommand.
// Questa classe definisce l'azione di aggiunta di una sala.
public class AggiungiSalaCommand implements ICommand {

    // Riferimento all'interfaccia del Receiver che sa come eseguire l'azione.
    private IAggiungiSala add;

    // La Sala da aggiungere, rappresentato dall'interfaccia ISala.
    private ISala sala;

    // Costruttore che associa il Receiver e la Sala al comando concreto.
    // Questi parametri sono necessari per l'esecuzione del comando.
    public AggiungiSalaCommand(IAggiungiSala add, ISala sala){
        this.add = add;
        this.sala = sala;
    }

    // Metodo execute che, quando chiamato, eseguirà l'azione di aggiungere una sala
    // tramite il Receiver. Questo metodo può sollevare eccezioni specifiche
    // relative all'aggiunta di una sala.
    public void execute() throws SalaGiaEsistenteException, IOException {
        add.aggiungiSala(sala);
    }
}
