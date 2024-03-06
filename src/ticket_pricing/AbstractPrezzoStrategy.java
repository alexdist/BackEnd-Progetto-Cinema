//package ticket_pricing;
//import singleton.*;
//
///**
// * Classe astratta che implementa l'interfaccia PrezzoStrategy.
// * Fornisce una base per le strategie di calcolo dei prezzi dei biglietti,
// * incapsulando l'accesso ai prezzi correnti dei biglietti.
// */
//public abstract class AbstractPrezzoStrategy implements PrezzoStrategy {
//    // Campo protetto per mantenere i prezzi correnti dei biglietti.
//    // L'accessibilità protetta permette alle sottoclassi di accedere direttamente a questo campo.
//    protected PrezziBiglietto prezzi;
//
//    /**
//     * Costruttore della classe astratta.
//     * Inizializza il campo prezzi con i valori correnti dei prezzi dei biglietti
//     * ottenuti dal GestorePrezzi del singleton Cinema.
//     */
//    public AbstractPrezzoStrategy() {
//        // Ottiene l'istanza singleton del Cinema e, successivamente,
//        // recupera i prezzi correnti dei biglietti tramite il GestorePrezzi.
//        this.prezzi = Cinema.getInstance().getGestorePrezzi().getPrezziCorrenti();
//    }
//
//    // Le sottoclassi concrete implementeranno i metodi definiti nell'interfaccia PrezzoStrategy.
//}
