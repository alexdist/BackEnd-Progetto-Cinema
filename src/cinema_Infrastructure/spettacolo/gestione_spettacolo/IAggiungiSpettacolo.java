package cinema_Infrastructure.spettacolo.gestione_spettacolo;

import cinema_Infrastructure.spettacolo.ISpettacolo;
import exception.FilmNonValidoException;
import exception.SalaNonValidaException;
import exception.spettacolo.SovrapposizioneSpettacoloException;

import java.util.List;

public interface IAggiungiSpettacolo {

    void aggiungiSpettacolo(ISpettacolo nuovoSpettacolo) throws SovrapposizioneSpettacoloException, FilmNonValidoException, SalaNonValidaException;
    List<ISpettacolo> getSpettacoli();
}
