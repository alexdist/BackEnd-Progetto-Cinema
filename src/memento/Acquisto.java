package memento;

import ticket.Biglietto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Acquisto implements AcquistoMemento, Serializable {
    // Variabili d'istanza private e finali per il biglietto e il timestamp dell'acquisto.
    // L'uso di final indica che queste variabili possono essere assegnate solo una volta, all'interno del costruttore.
    private final Biglietto biglietto;
    private final LocalDateTime timestampAcquisto;

    // Costruttore della classe Acquisto che inizializza le variabili d'istanza con i valori forniti.
    public Acquisto(Biglietto biglietto, LocalDateTime timestampAcquisto) {
        this.biglietto = biglietto;
        this.timestampAcquisto = timestampAcquisto;
    }

    // Metodo getter per ottenere il biglietto associato all'acquisto.
    public Biglietto getBiglietto() {
        return biglietto;
    }

    // Metodo getter per ottenere il timestamp dell'acquisto.
    public LocalDateTime getTimestampAcquisto() {
        return timestampAcquisto;
    }
}
