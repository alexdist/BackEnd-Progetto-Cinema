package admin_interfaces;

import exception.film.FilmNonValidoException;
import exception.sala.SalaNonValidaException;
import exception.spettacolo.SovrapposizioneSpettacoloException;
import exception.film.DurataFilmNonValidaException;
import exception.film.FilmGiaPresenteException;
import exception.film.FilmNonTrovatoException;
import exception.film.TitoloVuotoException;
import exception.sala.SalaGiaEsistenteException;
import exception.sala.SalaNonTrovataException;
import exception.spettacolo.SpettacoloNonTrovatoException;

/**
 * Interfaccia Command definisce l'operazione di esecuzione per tutti i comandi concreti.
 * Questa interfaccia è il nucleo del pattern Command, consentendo di incapsulare una richiesta come un oggetto.
 * Ogni implementazione concreta di questa interfaccia eseguirà un'azione specifica all'interno del sistema.
 */
public interface ICommand {
    /**
     * Metodo execute che ogni comando concreto dovrà implementare.
     * Questo metodo è responsabile dell'esecuzione dell'azione specifica del comando.
     */
    void execute() throws FilmGiaPresenteException, DurataFilmNonValidaException, TitoloVuotoException, FilmNonTrovatoException, SalaGiaEsistenteException, SalaNonTrovataException, SovrapposizioneSpettacoloException, FilmNonValidoException, SalaNonValidaException, SpettacoloNonTrovatoException;
}
