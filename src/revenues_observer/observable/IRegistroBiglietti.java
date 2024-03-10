package revenues_observer.observable;

import revenues_observer.observer.IReport;
import ticket.factory.product.IBiglietto;

import java.util.List;

//OBSERVABLE

public interface IRegistroBiglietti {
    void aggiungiBiglietto(IBiglietto biglietto);
    boolean annullaAcquisto(long idBiglietto);
    List<IBiglietto> getBiglietti();
    void addObserver(IReport observer);
    void removeObserver(IReport observer);
    void notifyObservers();
}
