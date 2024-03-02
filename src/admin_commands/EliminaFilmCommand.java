package admin_commands;

import admin_interfaces.Command;
import cinema_Infrastructure.Film;
import singleton.Cinema;
import singleton.GestioneCinema;

public class EliminaFilmCommand implements Command {
    private String titoloFilm; // Titolo del film da eliminare

    // Costruttore che accetta il titolo del film da eliminare
    public EliminaFilmCommand(String titoloFilm) {
        this.titoloFilm = titoloFilm;
    }

    @Override
    public void execute() {
        try {
            GestioneCinema gestioneCinema = Cinema.getInstance().getGestioneCinema();
            // Cerca il film nella lista dei film in programmazione
            Film filmDaEliminare = gestioneCinema.getFilmInProgrammazione().stream()
                    .filter(film -> film.getTitolo().equalsIgnoreCase(titoloFilm))
                    .findFirst()
                    .orElse(null);
            if (filmDaEliminare != null) {
                // Rimuove il film dalla lista dei film in programmazione
                gestioneCinema.getFilmInProgrammazione().remove(filmDaEliminare);
                System.out.println("Film \"" + titoloFilm + "\" eliminato con successo.");
            } else {
                System.err.println("Film \"" + titoloFilm + "\" non trovato.");
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'eliminazione del film: " + e.getMessage());
        }
    }
}
