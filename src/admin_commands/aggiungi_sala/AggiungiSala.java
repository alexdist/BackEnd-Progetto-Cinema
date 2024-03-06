package admin_commands.aggiungi_sala;

import cinema_Infrastructure.sala.Sala;
import exception.sala.NumeroSalaNegativoException;
import exception.sala.SalaGiaEsistenteException;

public interface AggiungiSala {
    void aggiungiSala(Sala sala);
}
