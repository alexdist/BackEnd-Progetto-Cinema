//package ticket;
//
//public class GeneratoreIDBiglietto implements IGeneratoreIDBiglietto {
//    private static GeneratoreIDBiglietto istanza; // Singleton instance
//    private long ultimoIdAssegnato;
//
//    private GeneratoreIDBiglietto() {
//        this.ultimoIdAssegnato = -1; // Inizia da -1 per fare in modo che il primo ID sia 0.
//    }
//
//    // Metodo statico sincronizzato per ottenere l'istanza Singleton
//    public static synchronized GeneratoreIDBiglietto getInstance() {
//        if (istanza == null) {
//            istanza = new GeneratoreIDBiglietto();
//        }
//        return istanza;
//    }
//
//    @Override // Implementazione dell'interfaccia per la generazione dell'ID
//    public synchronized long generaProssimoId() {
//        return ++ultimoIdAssegnato; // Incrementa e restituisce il prossimo ID
//    }
//
//    // Metodo opzionale per resettare l'ID
//    public synchronized void reset() {
//        ultimoIdAssegnato = -1;
//    }
//}
