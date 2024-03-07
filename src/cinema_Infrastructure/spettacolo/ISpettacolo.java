package cinema_Infrastructure.spettacolo;

import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.sala.ISala;

import java.time.LocalDateTime;

public interface ISpettacolo {
    // Metodo getter per ottenere l'ID dello spettacolo
    long getId();

    // Metodo setter per impostare l'ID dello spettacolo
    void setId(long id);

    // Metodo getter per ottenere il film dello spettacolo
    IFilm getFilm();

    // Metodo setter per impostare il film dello spettacolo
    void setFilm(IFilm film);

    // Metodo getter per ottenere la sala dello spettacolo
    ISala getSala();

    // Metodo setter per impostare la sala dello spettacolo
    void setSala(ISala sala);

    // Metodo getter per ottenere l'orario di proiezione dello spettacolo
    LocalDateTime getOrarioProiezione();

    // Metodo setter per impostare l'orario di proiezione dello spettacolo
    void setOrarioProiezione(LocalDateTime orarioProiezione);
}