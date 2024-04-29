package revenues_observer.concrete_observable;

import revenues_observer.observable.AbstractRegistroBiglietti;
//import revenues_observer.observable.IRegistroBiglietti;
import revenues_observer.observer.IReport;
import ticket.factory.product.IBiglietto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//CONCRETE OBSERVABLE

// RegistroBiglietti è un ConcreteObservable nel pattern Observer.
// Estende AbstractRegistroBiglietti implementando le operazioni specifiche per manipolare i biglietti.
public class RegistroBiglietti extends AbstractRegistroBiglietti implements Serializable {

    // Questo flag tiene traccia dell'esito dell'ultima operazione di annullamento di un biglietto.
    private boolean ultimoAnnullamentoRiuscito = false;

    // Metodo per aggiungere un biglietto al sistema. Questo metodo concretezza l'azione definita in modo astratto nella classe genitore.
    @Override
    public void aggiungiBiglietto(IBiglietto biglietto) {
        biglietti().add(biglietto); // Aggiunge un biglietto alla lista interna.
        notifyObservers(); // Notifica tutti gli observer di un cambiamento nello stato.
    }

    // Metodo per annullare l'acquisto di un biglietto, basato su un identificatore univoco.
    @Override
    public boolean annullaAcquisto(long idBiglietto) {
        ultimoAnnullamentoRiuscito = false; // Inizializza il flag di annullamento a false.
        List<IBiglietto> biglietti = biglietti(); // Ottiene la lista corrente di biglietti.
        // Itera sui biglietti per trovare quello con l'ID corrispondente.
        for (IBiglietto biglietto : biglietti) {
            if (biglietto.getId() == idBiglietto) {
                LocalDateTime tempoDiAcquisto = biglietto.getTimestampAcquisto();
                LocalDateTime tempoLimite = tempoDiAcquisto.plusMinutes(1);
                // Controlla se l'annullamento è ancora possibile in base al tempo trascorso dall'acquisto.
                if (LocalDateTime.now().isBefore(tempoLimite)) {
                    biglietti.remove(biglietto); // Rimuove il biglietto se l'annullamento è valido.
                    notifyObservers(); // Notifica gli observer dopo un cambiamento nello stato.
                    ultimoAnnullamentoRiuscito = true; // Imposta il flag di annullamento a vero.
                    return true; // Ritorna vero poiché l'annullamento è avvenuto con successo.
                }
                break; // Esce dal ciclo una volta trovato il biglietto, indipendentemente dall'esito.
            }
        }
        return false; // Ritorna falso se l'annullamento non è avvenuto.
    }

    public boolean isUltimoAnnullamentoRiuscito() {
        return ultimoAnnullamentoRiuscito;
    }

}

