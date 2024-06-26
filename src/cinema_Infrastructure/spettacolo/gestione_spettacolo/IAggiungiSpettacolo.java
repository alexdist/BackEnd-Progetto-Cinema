package cinema_Infrastructure.spettacolo.gestione_spettacolo;

import cinema_Infrastructure.spettacolo.ISpettacolo;
import exception.film.FilmNonValidoException;
import exception.sala.SalaNonValidaException;
import exception.spettacolo.SovrapposizioneSpettacoloException;

import java.io.IOException;
import java.util.List;

// IAggiungiSpettacolo agisce come 'Receiver' nel pattern Command.
// Questa interfaccia dichiara i metodi che saranno implementati per aggiungere uno Spettacolo
// e recuperare la lista degli Spettacoli esistenti.
public interface IAggiungiSpettacolo {
    void aggiungiSpettacolo(ISpettacolo nuovoSpettacolo) throws SovrapposizioneSpettacoloException, FilmNonValidoException, SalaNonValidaException, IOException;
    List<ISpettacolo> getSpettacoli();
}
