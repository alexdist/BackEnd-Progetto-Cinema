package revenues_observer.concrete_observableA;

import revenues_observer.observable.AbstractRegistroBiglietti;
//import revenues_observer.observable.IRegistroBiglietti;
import revenues_observer.observer.IReport;
import ticket.factory.product.IBiglietto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//CONCRETE OBSERVABLE A

// AffluenzaPerSalaReport è un ConcreteObserver secondo il pattern Observer.
// Monitora lo stato dell'oggetto Observable (AbstractRegistroBiglietti) e si aggiorna in base ai cambiamenti.
public class AffluenzaPerSalaReport implements IReport, Serializable {

    // Lista di biglietti che serve come parte dello stato dell'observer per calcolare l'affluenza.
    private List<IBiglietto> biglietti;

    // Riferimento al registro che è l'oggetto Observable.
    private AbstractRegistroBiglietti registro;

    // Mappa per tenere traccia dell'affluenza per ciascuna sala. È lo stato specifico di questo Observer.
    private Map<Integer, Integer> affluenzaPerSala; // Aggiunto per mantenere lo stato attuale dell'affluenza per sala

    // Il costruttore si registra con l'Observable per ricevere aggiornamenti.
    public AffluenzaPerSalaReport(AbstractRegistroBiglietti registro) {
        this.registro = registro;
        this.biglietti = registro.getBiglietti();
        this.affluenzaPerSala = new HashMap<>();
        registro.addObserver(this); // Registrazione con l'Observable.
    }

    // Metodo update() richiamato quando l'Observable notifica un cambiamento.
    @Override
    public void update() {
        // Aggiorna la lista di biglietti in base allo stato attuale dell'Observable.
        this.biglietti = registro.getBiglietti();
    }

    // Metodo generate() per elaborare l'attuale stato e produrre un report sull'affluenza.
    @Override
    public void generate() {
        // Inizializza la mappa per un nuovo calcolo.
        affluenzaPerSala.clear();
        // Calcola l'affluenza per ogni sala basandosi sui biglietti aggiornati.
        for (IBiglietto biglietto : biglietti) {
            int numeroSala = biglietto.getSpettacolo().getSala().getNumeroSala();
            // Utilizza il metodo merge per aggiornare il conteggio.
            affluenzaPerSala.merge(numeroSala, 1, Integer::sum);
        }
        System.out.println("Report Affluenza per Sala:");
        affluenzaPerSala.forEach((sala, affluenza) ->
                System.out.println("Sala " + sala + ": affluenza totale = " + affluenza + " persone"));
    }

    // Metodo getter per recuperare la mappa dell'affluenza attuale.
    public Map<Integer, Integer> getAffluenzaPerSala() {
        return new HashMap<>(affluenzaPerSala);
    }
}

