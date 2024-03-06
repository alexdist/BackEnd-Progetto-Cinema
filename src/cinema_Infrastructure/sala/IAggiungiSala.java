package cinema_Infrastructure.sala;

import exception.sala.SalaGiaEsistenteException;

public interface IAggiungiSala {
    public void aggiungiSala(Sala sala) throws SalaGiaEsistenteException;
}
