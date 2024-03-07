package cinema_Infrastructure.spettacolo.gestione_spettacolo;

import exception.SpettacoloNonTrovatoException;
import exception.sala.SalaNonTrovataException;

public interface IRimuoviSpettacolo {

    void rimuoviSpettacoloPerId(long idSpettacolo) throws SpettacoloNonTrovatoException;
}
