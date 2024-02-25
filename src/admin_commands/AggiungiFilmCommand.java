package admin_commands;

import cinema_Infrastructure.Film;
import admin_interfaces.Command;
import exception.FilmGiaPresenteException;
import singleton.*;

// Definisce un comando per aggiungere un film al sistema di gestione del cinema.
public class AggiungiFilmCommand implements Command {

    // Campo privato per memorizzare l'istanza del film da aggiungere.
    private Film film;


    // Costruttore della classe AggiungiFilmCommand.
    // Se il film è null, viene sollevata un'eccezione IllegalArgumentException.
    public AggiungiFilmCommand(Film film) {
        // Verifica che l'oggetto film non sia null per prevenire l'aggiunta di un film non valido.
        if (film == null) {
            throw new IllegalArgumentException("Il film non può essere null");
        }
        // Assegna l'oggetto film al campo privato della classe se supera la validazione.
        this.film = film;
    }

    // Implementazione del metodo execute definito dall'interfaccia Command.
    // Questo metodo viene chiamato per eseguire l'azione di aggiunta del film al cinema.
    @Override
    public void execute() {
        try {
            // Tenta di aggiungere il film al sistema di gestione del cinema.
            Cinema.getInstance().getGestioneCinema().aggiungiFilm(film);

        } catch (FilmGiaPresenteException e) {
            // Gestisce l'eccezione per il caso in cui il film è già presente.
            System.err.println(e.getMessage());
            // Qui potresti anche loggare l'errore o mostrare un messaggio all'utente, a seconda del tuo contesto di UI.
        }
    }
}