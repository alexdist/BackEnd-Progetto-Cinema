package admin_commands.aggiungi_film;

import cinema_Infrastructure.film.Film;
import admin_interfaces.Command;
import cinema_Infrastructure.film.ValidatoreFilm;
import exception.film.FilmGiaPresenteException;


public class AggiungiFilmCommand implements Command {

    private Film film;
    private AggiungiFilm gestoreFilm; // Dipendenza verso l'interfaccia

    // Costruttore della classe AggiungiFilmCommand.
    // L'iniezione dell'interfaccia AggiungiFilm riduce la dipendenza dal singleton Cinema.
    public AggiungiFilmCommand(Film film, AggiungiFilm gestoreFilm) {
       // ValidatoreFilm.validaParametri(film); // Verifica che l'oggetto film non sia null
        this.film = film;
        this.gestoreFilm = gestoreFilm; // Assegna l'interfaccia iniettata
    }

    // Implementazione del metodo execute definito dall'interfaccia Command.
//    @Override
//    public void execute() {
//        try {
//            // Utilizza l'interfaccia iniettata per aggiungere il film
//            gestoreFilm.aggiungiFilm(film);
//        } catch (Exception e) {
//            // Gestisce l'eccezione per il caso in cui il film è già presente.
//            GestoreEccezioniFilm.gestisciEccezione(e);
//        }
//    }

    @Override
    public void execute(){

        // Utilizza l'interfaccia iniettata per aggiungere il film
        gestoreFilm.aggiungiFilm(film);
    }

}