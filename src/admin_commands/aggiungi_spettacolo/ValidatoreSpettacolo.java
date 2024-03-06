package admin_commands.aggiungi_spettacolo;

import cinema_Infrastructure.film.Film;
import cinema_Infrastructure.sala.Sala;

import java.time.LocalDateTime;

public class ValidatoreSpettacolo {
    public static void validaParametri(Film film, Sala sala, LocalDateTime orarioProiezione) {
        if (film == null) {
            throw new IllegalArgumentException("Il film non può essere null");
        }
        if (sala.getNumeroSala() <= 0) {
            throw new IllegalArgumentException("Il numero della sala deve essere maggiore di 0");
        }
        if (orarioProiezione == null) {
            throw new IllegalArgumentException("L'orario di proiezione non può essere null");
        }
    }
}
