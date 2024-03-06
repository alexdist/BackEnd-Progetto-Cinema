package exception.sala;

public class NumeroPostiNegativoException extends IllegalArgumentException {
    // Costruttore senza argomenti con un messaggio di default
    public NumeroPostiNegativoException() {
        super("Il numero di posti a sedere non può essere negativo.");
    }

    // Costruttore che accetta un messaggio personalizzato
    public NumeroPostiNegativoException(String message) {
        super(message);
    }
}

