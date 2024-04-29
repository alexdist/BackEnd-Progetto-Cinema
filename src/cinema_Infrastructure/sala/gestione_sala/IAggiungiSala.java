package cinema_Infrastructure.sala.gestione_sala;

import cinema_Infrastructure.film.Film;
import cinema_Infrastructure.sala.ISala;
import exception.sala.SalaGiaEsistenteException;

import java.io.IOException;
import java.util.List;

// IAggiungiSala agisce come 'Receiver' nel pattern Command.
// Questa interfaccia dichiara i metodi che saranno implementati per aggiungere una Sala
// e recuperare la lista delle Sale esistenti.
public interface IAggiungiSala {
    void aggiungiSala(ISala sala) throws SalaGiaEsistenteException, IOException;
    List<ISala> getSale();
}
