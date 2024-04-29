package ID_persistente;

/**
 * Interfaccia IGeneratoreIDPersistente.
 * Questa interfaccia definisce i metodi necessari per gestire la persistenza dell'ultimo ID usato.
 * Il suo scopo principale è garantire che l'ultimo ID generato sia memorizzato in modo persistente, così che,
 * nel caso in cui l'applicazione venga terminata, l'ultimo ID possa essere salvato e poi correttamente ripreso
 * al riavvio dell'applicazione. Questo meccanismo previene la generazione di ID duplicati e assicura la continuità
 * nella sequenza degli ID assegnati, mantenendo l'integrità dei dati all'interno dell'applicazione.
 */
public interface IGeneratoreIDPersistente {
    long generaProssimoId() ;
    void salvaUltimoIdUsato() ;
    void caricaUltimoIdUsato() ;
}
