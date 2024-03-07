package cinema_Infrastructure.sala.gestione_sala;

import exception.sala.SalaNonTrovataException;

public interface IRimuoviSala {
    void rimuoviSalaPerId(long idSala) throws SalaNonTrovataException;
}
