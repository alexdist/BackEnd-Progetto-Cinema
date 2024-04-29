package cinema_Infrastructure.sala.gestione_sala;

import exception.sala.SalaNonTrovataException;

// IRimuoviSala agisce come 'Receiver' nel pattern Command.
// Questa interfaccia dichiara i metodi che saranno implementati per rimuovere una Sala.
public interface IRimuoviSala {
    void rimuoviSalaPerId(long idSala) throws SalaNonTrovataException;
}
