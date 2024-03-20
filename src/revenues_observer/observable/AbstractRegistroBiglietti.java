package revenues_observer.observable;

import revenues_observer.observer.IReport;
import ticket.factory.product.IBiglietto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// SUBJECT
public abstract class AbstractRegistroBiglietti implements Serializable {
    private List<IBiglietto> biglietti = new ArrayList<>();
    private List<IReport> observers = new ArrayList<>();

    public abstract void aggiungiBiglietto(IBiglietto biglietto);

    public abstract boolean annullaAcquisto(long idBiglietto);

    public List<IBiglietto> getBiglietti() {
        // Potrebbe essere necessario rendere questa implementazione più specifica, a seconda del comportamento desiderato.
        return new ArrayList<>(biglietti);
    }

    public void addObserver(IReport observer) {
        observers.add(observer);
    }

    public void removeObserver(IReport observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (IReport observer : observers) {
            observer.update();
        }
    }

    // Metodo protetto per accedere alla lista di biglietti dalla classe concreta che estende questa classe astratta.
    protected List<IBiglietto> biglietti() {
        return biglietti;
    }
}
