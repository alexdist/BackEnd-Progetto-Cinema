package revenues_observer.observable;

import revenues_observer.observer.IReport;
import ticket.factory.product.IBiglietto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// OBSERVABLE

// AbstractRegistroBiglietti agisce come l'Observable nel pattern Observer.
// Fornisce un'implementazione di base per gestire gli Observer e notificarli dei cambiamenti.
public abstract class AbstractRegistroBiglietti implements Serializable {

    // La lista di biglietti rappresenta lo stato dell'Observable che, quando cambia,
    // deve notificare tutti gli Observer sottoscritti.
    private List<IBiglietto> biglietti = new ArrayList<>();

    // La lista di Observer che devono essere notificati in caso di cambiamenti nello stato.
    private List<IReport> observers = new ArrayList<>();

    // Metodi astratti che devono essere implementati dalle sottoclassi concrete.
    // Aggiunge un biglietto allo stato dell'Observable.
    public abstract void aggiungiBiglietto(IBiglietto biglietto);

    // Annulla l'acquisto di un biglietto.
    public abstract boolean annullaAcquisto(long idBiglietto);

    // Variabile per tenere traccia dell'esito dell'ultima operazione di annullamento.
    private boolean ultimoAnnullamentoRiuscito = false;

    // Fornisce una copia della lista dei biglietti agli Observer senza esporre la lista originale.
    public List<IBiglietto> getBiglietti() {
        return new ArrayList<>(biglietti);
    }

    // Metodo per aggiungere un Observer alla lista. Chiamato dagli Observer stessi quando si registrano.
    public void addObserver(IReport observer) {
        observers.add(observer);
    }

    // Metodo per rimuovere un Observer dalla lista.
    public void removeObserver(IReport observer) {
        observers.remove(observer);
    }

    // Notifica tutti gli Observer registrati di un cambiamento nello stato dell'Observable.
    // Questo è il cuore del pattern Observer, dove gli Observer sono informati dei cambiamenti.
    public void notifyObservers() {
        for (IReport observer : observers) {
            observer.update();
        }
    }

    // Metodo protetto per accedere alla lista di biglietti dalla classe concreta che estende questa classe astratta.
    protected List<IBiglietto> biglietti() {
        return biglietti;
    }

    // Getter che indica se l'ultima operazione di annullamento è stata eseguita con successo.
    public boolean isUltimoAnnullamentoRiuscito() {
        return ultimoAnnullamentoRiuscito;
    }
}
