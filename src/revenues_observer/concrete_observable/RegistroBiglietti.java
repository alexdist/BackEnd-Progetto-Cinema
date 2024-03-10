package revenues_observer.concrete_observable;

import revenues_observer.observable.IRegistroBiglietti;
import revenues_observer.observer.IReport;
import ticket.factory.product.IBiglietto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//CONCRETE OBSERVABLE

public class RegistroBiglietti implements IRegistroBiglietti {
    private List<IBiglietto> biglietti = new ArrayList<>();
    private List<IReport> observers = new ArrayList<>();

    @Override
    public void aggiungiBiglietto(IBiglietto biglietto) {
        biglietti.add(biglietto);
        notifyObservers();
    }

    @Override
    public boolean annullaAcquisto(long idBiglietto) {
        for (IBiglietto biglietto : biglietti) {
            if (biglietto.getId() == idBiglietto) {
                LocalDateTime tempoDiAcquisto = biglietto.getTimestampAcquisto();
                LocalDateTime tempoLimite = tempoDiAcquisto.plusMinutes(10);
                if (LocalDateTime.now().isBefore(tempoLimite)) {
                    biglietti.remove(biglietto);
                    notifyObservers();
                    return true;
                }
                break;
            }
        }
        return false;
    }

    @Override
    public List<IBiglietto> getBiglietti() {
        return new ArrayList<>(biglietti);
    }

    @Override
    public void addObserver(IReport observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IReport observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IReport observer : observers) {
            observer.update();
        }
    }
}
