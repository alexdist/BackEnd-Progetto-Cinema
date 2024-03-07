package cinema_Infrastructure.spettacolo.gestione_spettacolo;

import cinema_Infrastructure.spettacolo.ISpettacolo;
import exception.SovrapposizioneSpettacoloException;

import java.util.List;

public interface IAggiungiSpettacolo {

    void aggiungiSpettacolo(ISpettacolo nuovoSpettacolo)throws SovrapposizioneSpettacoloException;
    List<ISpettacolo> getSpettacoli();
}
