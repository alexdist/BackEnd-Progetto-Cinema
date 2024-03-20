package revenues_observer.observer;


//import revenues_observer.observable.IRegistroBiglietti;

import java.io.Serializable;

//OBSERVER
public interface IReport {

    void update();  // Aggiorna i dati del report in risposta a un cambiamento
    void generate(); // Genera il report basato sui dati aggiornati
}
