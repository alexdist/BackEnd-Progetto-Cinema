package admin_commands;

import cinema_Infrastructure.Sala;
import admin_interfaces.Command;
import exception.SalaGiaEsistenteException;
import singleton.*;

// Definisce un comando per aggiungere una nuova sala al sistema di gestione del cinema.
public class AggiungiSalaCommand implements Command {
    // Campo privato per memorizzare l'istanza della sala da aggiungere.
    private Sala sala;

    // Costruttore della classe AggiungiSalaCommand.
    // Se la sala è null, viene sollevata un'eccezione IllegalArgumentException.
    public AggiungiSalaCommand(Sala sala) {
        // Verifica che l'oggetto sala non sia null per prevenire l'aggiunta di una sala non valida.
        if (sala == null) {
            throw new IllegalArgumentException("La sala non può essere null");
        }
        // Assegna l'oggetto sala al campo privato della classe se supera la validazione.
        this.sala = sala;
    }


    @Override
    public void execute() {
        try {
            // Prova ad aggiungere la sala
            // Ottiene l'istanza singleton del cinema e chiama il metodo aggiungiSala
            // per aggiungere l'istanza della sala al sistema di gestione del cinema.
            Cinema.getInstance().getGestioneCinema().aggiungiSala(sala);
        } catch (SalaGiaEsistenteException e) {
            // Gestisci l'eccezione, stampando un messaggio di errore
            System.err.println(e.getMessage());
        }
    }
}
