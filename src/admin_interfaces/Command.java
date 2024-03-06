package admin_interfaces;

import exception.film.FilmGiaPresenteException;

/**
 * Interfaccia Command definisce l'operazione di esecuzione per tutti i comandi concreti.
 * Questa interfaccia è il nucleo del pattern Command, consentendo di incapsulare una richiesta come un oggetto.
 * Ogni implementazione concreta di questa interfaccia eseguirà un'azione specifica all'interno del sistema.
 */
public interface Command {
    /**
     * Metodo execute che ogni comando concreto dovrà implementare.
     * Questo metodo è responsabile dell'esecuzione dell'azione specifica del comando.
     */
    void execute();
}
