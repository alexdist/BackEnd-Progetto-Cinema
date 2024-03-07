package cinema_Infrastructure.sala.gestione_sala;

import cinema_Infrastructure.film.Film;
import cinema_Infrastructure.sala.ISala;
import exception.sala.SalaGiaEsistenteException;

import java.util.List;

public interface IAggiungiSala {
    void aggiungiSala(ISala sala) throws SalaGiaEsistenteException;
    List<ISala> getSale();
}
