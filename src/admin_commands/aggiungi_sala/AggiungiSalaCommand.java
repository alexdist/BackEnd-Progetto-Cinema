package admin_commands.aggiungi_sala;

import cinema_Infrastructure.sala.Sala;
import admin_interfaces.Command;

// Definisce un comando per aggiungere una nuova sala al sistema di gestione del cinema.
public class AggiungiSalaCommand implements Command {
    // Campo privato per memorizzare l'istanza della sala da aggiungere.
    private Sala sala;
    private AggiungiSala gestoreSala; //Dipendenza verso l'interfaccia.

    // Costruttore della classe AggiungiSalaCommand.
    // Se la sala è null, viene sollevata un'eccezione IllegalArgumentException.
    public AggiungiSalaCommand(Sala sala, AggiungiSala gestoreSala) {
        // Verifica che l'oggetto sala non sia null per prevenire l'aggiunta di una sala non valida.
       //ValidatoreSala.validaParametri(sala);
        // Assegna l'oggetto sala al campo privato della classe se supera la validazione.
        this.sala = sala;
        this.gestoreSala = gestoreSala;
    }


//    @Override
//    public void execute() {
//        try {
//            gestoreSala.aggiungiSala(sala);
//        } catch (Exception e) {
//            GestoreEccezioniSala.gestisciEccezione(e);
//        }
//    }

    @Override
    public void execute() {

            gestoreSala.aggiungiSala(sala);

    }
}
