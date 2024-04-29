package cinema_Infrastructure.spettacolo;

import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.sala.ISala;
import java.time.LocalDateTime;

// Interfaccia ISpettacolo che definisce il contratto per le operazioni base su uno Spettacolo.
public interface ISpettacolo {
    long getId();
    void setId(long id);
    IFilm getFilm();
    void setFilm(IFilm film);
    ISala getSala();
    void setSala(ISala sala);
    LocalDateTime getOrarioProiezione();
    void setOrarioProiezione(LocalDateTime orarioProiezione);
}