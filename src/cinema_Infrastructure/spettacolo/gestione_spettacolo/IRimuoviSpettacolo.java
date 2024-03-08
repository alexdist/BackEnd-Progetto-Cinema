package cinema_Infrastructure.spettacolo.gestione_spettacolo;

import exception.spettacolo.SpettacoloNonTrovatoException;

public interface IRimuoviSpettacolo {

    void rimuoviSpettacoloPerId(long idSpettacolo) throws SpettacoloNonTrovatoException;
}
