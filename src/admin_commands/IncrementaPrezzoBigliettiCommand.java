//package admin_commands;
//
//
//
//import admin_interfaces.Command;
//import ticket_pricing.GestorePrezzi;
//import singleton.*;
//
//
//// Definisce un comando per aumentare i prezzi dei biglietti nel sistema di gestione del cinema.
//public class IncrementaPrezzoBigliettiCommand implements Command {
//    // Campo privato per memorizzare l'importo dell'aumento per il prezzo del biglietto intero.
//    private double aumentoIntero;
//    // Campo privato per memorizzare l'importo dell'aumento per il prezzo del biglietto ridotto.
//    private double aumentoRidotto;
//
//    // Costruttore della classe IncreaseTicketPriceCommand.
//    // @param aumentoIntero L'importo dell'aumento per il prezzo del biglietto intero.
//    // @param aumentoRidotto L'importo dell'aumento per il prezzo del biglietto ridotto.
//    // Questi valori vengono utilizzati per calcolare i nuovi prezzi dei biglietti.
//    public IncrementaPrezzoBigliettiCommand(double aumentoIntero, double aumentoRidotto) {
//        this.aumentoIntero = aumentoIntero;
//        this.aumentoRidotto = aumentoRidotto;
//    }
//
//    // Implementazione del metodo execute definito dall'interfaccia Command.
//    // Questo metodo viene chiamato per eseguire l'azione di incremento dei prezzi dei biglietti.
//    @Override
//    public void execute() {
//        if (aumentoIntero < 0 || aumentoRidotto < 0) {
//            throw new IllegalArgumentException("L'aumento dei prezzi non può essere negativo.");
//        }
//        // Accede a GestorePrezzi tramite il singleton Cinema e invoca il metodo aumentaPrezzi
//        // per applicare gli aumenti specificati ai prezzi dei biglietti.
//        Cinema.getInstance().getGestorePrezzi().aumentaPrezzi(aumentoIntero, aumentoRidotto);
//        // Stampa un messaggio di conferma che mostra gli importi degli aumenti applicati.
//        System.out.println("Prezzi dei biglietti aumentati: intero di " + aumentoIntero + "€, ridotto di " + aumentoRidotto + "€.");
//    }
//}
