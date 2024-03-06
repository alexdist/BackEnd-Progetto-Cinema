package memento;

//import java.io.Serializable;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
//import Serializzazione.GestoreRicaviSerializer;
//import singleton.Cinema;
//import ticket_pricing.GestoreRicavi;

//public class Caretaker implements Serializable {
//    private static final long serialVersionUID = 1L;
//    // Stack per memorizzare gli oggetti Memento (acquisti).
//    private final Stack<AcquistoMemento> mementoStack;
//    // Riferimento a GestoreRicavi per la gestione dei ricavi, inizializzato su richiesta.
//    private GestoreRicavi gestoreRicavi;
//
//    public Caretaker() {
//        this.mementoStack = new Stack<>();
//        this.gestoreRicavi = null; // Inizializzato più tardi per evitare dipendenze cicliche.
//    }
//
//    // Metodo per inizializzare il GestoreRicavi quando necessario, prevenendo chiamate ricorsive infinite.
//    private void initGestoreRicaviIfNeeded() {
//        if (gestoreRicavi == null) {
//            gestoreRicavi = Cinema.getInstance().getGestoreRicavi();
//        }
//    }
//
//    // Aggiunge un memento (acquisto) allo stack.
//    public void addMemento(AcquistoMemento memento) {
//        mementoStack.push(memento);
//
//    }
//
//    // Metodo getter per ottenere lo stack di mementi
//    public Stack<AcquistoMemento> getMementos() {
//        return mementoStack;
//    }
//
//    // Verifica se ci sono mementi (acquisti) memorizzati.
//    public boolean hasMemento() {
//        return !mementoStack.isEmpty();
//    }
//
//    // Determina se è possibile annullare l'ultimo acquisto basandosi sul tempo trascorso.
//    public boolean canUndo() {
//        if (!mementoStack.isEmpty()) {
//            Acquisto lastAcquisto = (Acquisto) mementoStack.peek();
//            LocalDateTime now = LocalDateTime.now();
//            LocalDateTime acquistoTime = lastAcquisto.getTimestampAcquisto();
//            return now.minusMinutes(10).isBefore(acquistoTime);
//        }
//        return false;
//    }
//
//    // Annulla l'ultimo acquisto se possibile, aggiornando la gestione dei ricavi.
////    public AcquistoMemento undoLastAcquisto() {
////        initGestoreRicaviIfNeeded(); // Assicura l'inizializzazione di GestoreRicavi.
////        if (canUndo()) {
////            Acquisto lastAcquisto = (Acquisto) mementoStack.pop();
////            lastAcquisto.getBiglietto().invalidate(); // Invalida il biglietto dell'ultimo acquisto.
////            gestoreRicavi.annullaVenditaBiglietto(lastAcquisto.getBiglietto()); // Annulla la vendita nel gestore ricavi.
////
////            return lastAcquisto;
////        }
////        return null;
////    }
//
//    public AcquistoMemento undoLastAcquisto() {
//        // Codice esistente per annullare l'ultimo acquisto...
//        if (canUndo()) {
//            Acquisto lastAcquisto = (Acquisto) mementoStack.pop();
//            // Notifica al GestoreRicavi l'annullamento della vendita
//            Cinema.getInstance().getGestoreRicavi().annullaVenditaBiglietto(lastAcquisto.getBiglietto());
//            return lastAcquisto;
//        }
//        return null;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Caretaker{");
//        sb.append("mementos=[");
//        for (AcquistoMemento memento : mementoStack) {
//            if (memento instanceof Acquisto) {
//                Acquisto acquisto = (Acquisto) memento;
//                sb.append("\n  Acquisto{");
//                sb.append("biglietto=").append(acquisto.getBiglietto().toString()).append(", ");
//                sb.append("timestampAcquisto=").append(acquisto.getTimestampAcquisto());
//                sb.append("},");
//            }
//        }
//        if (!mementoStack.isEmpty()) {
//            sb.deleteCharAt(sb.length() - 1); // Rimuove l'ultima virgola se lo stack non è vuoto
//        }
//        sb.append("\n]");
//        sb.append("}");
//        return sb.toString();
//    }
//}

//public class Caretaker implements Serializable {
//    private static final long serialVersionUID = 1L;
//    // Lista per memorizzare gli oggetti Memento (acquisti).
//    private final List<AcquistoMemento> mementoList;
//    // Riferimento a GestoreRicavi per la gestione dei ricavi, inizializzato su richiesta.
//    private GestoreRicavi gestoreRicavi;
//
//    public Caretaker() {
//        this.mementoList = new ArrayList<>(); // Modifica qui
//        this.gestoreRicavi = null;
//    }
//
//    // Aggiunge un memento (acquisto) alla lista.
//    public void addMemento(AcquistoMemento memento) {
//        mementoList.add(memento); // Modifica qui
//    }
//
//    // Metodo getter per ottenere la lista di mementi
//    public List<AcquistoMemento> getMementos() {
//        return mementoList; // Modifica qui
//    }
//
//    // Verifica se ci sono mementi (acquisti) memorizzati.
//    public boolean hasMemento() {
//        return !mementoList.isEmpty(); // Modifica qui
//    }
//
//    // Annulla l'ultimo acquisto se possibile, aggiornando la gestione dei ricavi.
//    public AcquistoMemento undoLastAcquisto() {
//        if (canUndo()) {
//            // Ottiene e rimuove l'ultimo elemento dalla lista
//            Acquisto lastAcquisto = (Acquisto) mementoList.remove(mementoList.size() - 1); // Modifica qui
//            Cinema.getInstance().getGestoreRicavi().annullaVenditaBiglietto(lastAcquisto.getBiglietto());
//            return lastAcquisto;
//        }
//        return null;
//    }
//
//    public boolean canUndo() {
//        if (!mementoList.isEmpty()) {
//            // Ottiene l'ultimo acquisto dalla lista senza rimuoverlo.
//            Acquisto lastAcquisto = (Acquisto) mementoList.get(mementoList.size() - 1);
//            LocalDateTime now = LocalDateTime.now();
//            LocalDateTime acquistoTime = lastAcquisto.getTimestampAcquisto();
//            // Verifica se l'acquisto è stato fatto meno di 10 minuti fa.
//            return now.minusMinutes(10).isBefore(acquistoTime);
//        }
//        return false;
//    }
//
//
//    // Il resto del codice rimane invariato...
//}
