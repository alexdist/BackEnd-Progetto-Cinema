package memento;

import java.time.LocalDateTime;
import java.util.Stack;
import singleton.Cinema;
import ticket_pricing.GestoreRicavi;

public class Caretaker {
    // Stack per memorizzare gli oggetti Memento (acquisti).
    private final Stack<AcquistoMemento> mementoStack;
    // Riferimento a GestoreRicavi per la gestione dei ricavi, inizializzato su richiesta.
    private GestoreRicavi gestoreRicavi;

    public Caretaker() {
        this.mementoStack = new Stack<>();
        this.gestoreRicavi = null; // Inizializzato più tardi per evitare dipendenze cicliche.
    }

    // Metodo per inizializzare il GestoreRicavi quando necessario, prevenendo chiamate ricorsive infinite.
    private void initGestoreRicaviIfNeeded() {
        if (gestoreRicavi == null) {
            gestoreRicavi = Cinema.getInstance().getGestoreRicavi();
        }
    }

    // Aggiunge un memento (acquisto) allo stack.
    public void addMemento(AcquistoMemento memento) {
        mementoStack.push(memento);
    }

    // Verifica se ci sono mementi (acquisti) memorizzati.
    public boolean hasMemento() {
        return !mementoStack.isEmpty();
    }

    // Determina se è possibile annullare l'ultimo acquisto basandosi sul tempo trascorso.
    public boolean canUndo() {
        if (!mementoStack.isEmpty()) {
            Acquisto lastAcquisto = (Acquisto) mementoStack.peek();
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime acquistoTime = lastAcquisto.getTimestampAcquisto();
            return now.minusMinutes(10).isBefore(acquistoTime);
        }
        return false;
    }

    // Annulla l'ultimo acquisto se possibile, aggiornando la gestione dei ricavi.
    public AcquistoMemento undoLastAcquisto() {
        initGestoreRicaviIfNeeded(); // Assicura l'inizializzazione di GestoreRicavi.
        if (canUndo()) {
            Acquisto lastAcquisto = (Acquisto) mementoStack.pop();
            lastAcquisto.getBiglietto().invalidate(); // Invalida il biglietto dell'ultimo acquisto.
            gestoreRicavi.annullaVenditaBiglietto(lastAcquisto.getBiglietto()); // Annulla la vendita nel gestore ricavi.
            return lastAcquisto;
        }
        return null;
    }
}