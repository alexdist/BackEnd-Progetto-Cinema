package admin_commands;


import admin_interfaces.Command;
import ticket_pricing.GestorePrezzi;
import singleton.*;


// Definisce un comando per diminuire i prezzi dei biglietti nel sistema di gestione del cinema.
public class DecreaseTicketPriceCommand implements Command {
    // Campo privato per memorizzare l'importo della diminuzione per il prezzo del biglietto intero.
    private double diminuzioneIntero;
    // Campo privato per memorizzare l'importo della diminuzione per il prezzo del biglietto ridotto.
    private double diminuzioneRidotto;

    // Costruttore della classe DecreaseTicketPriceCommand.
    // @param diminuzioneIntero L'importo della diminuzione per il prezzo del biglietto intero.
    // @param diminuzioneRidotto L'importo della diminuzione per il prezzo del biglietto ridotto.
    // Questi valori vengono utilizzati per calcolare i nuovi prezzi dei biglietti.
    public DecreaseTicketPriceCommand(double diminuzioneIntero, double diminuzioneRidotto) {
        this.diminuzioneIntero = diminuzioneIntero;
        this.diminuzioneRidotto = diminuzioneRidotto;
    }

    // Implementazione del metodo execute definito dall'interfaccia Command.
    // Questo metodo viene chiamato per eseguire l'azione di riduzione dei prezzi dei biglietti.
    @Override
    public void execute() {
        if (diminuzioneIntero < 0 || diminuzioneRidotto < 0) {
            throw new IllegalArgumentException("La diminuzione dei prezzi non può essere negativo.");
        }
        // Ottiene l'istanza singleton del cinema e chiama il metodo diminuisciPrezzi
        // per applicare le riduzioni specificate ai prezzi dei biglietti.
        Cinema.getInstance().getGestorePrezzi().diminuisciPrezzi(diminuzioneIntero, diminuzioneRidotto);
        // Stampa un messaggio di conferma che mostra gli importi delle riduzioni applicate.
        System.out.println("Prezzi dei biglietti diminuiti: intero di " + diminuzioneIntero + "€, ridotto di " + diminuzioneRidotto + "€.");
    }
}
