//package admin_commands;
//
//import admin_interfaces.Command;
//import singleton.*;
//// Definisce un comando per impostare i prezzi dei biglietti (intero e ridotto) nel sistema di gestione del cinema.
//public class ImpostaPrezziBigliettiCommand implements Command {
//    // Campo privato per memorizzare il prezzo del biglietto intero.
//    private double prezzoIntero;
//    // Campo privato per memorizzare il prezzo del biglietto ridotto.
//    private double prezzoRidotto;
//
//    // Costruttore della classe ImpostaPrezziBigliettiCommand.
//    // @param prezzoIntero Il nuovo prezzo per il biglietto intero.
//    // @param prezzoRidotto Il nuovo prezzo per il biglietto ridotto.
//    public ImpostaPrezziBigliettiCommand(double prezzoIntero, double prezzoRidotto) {
//        this.prezzoIntero = prezzoIntero;
//        this.prezzoRidotto = prezzoRidotto;
//    }
//
//    // Implementazione del metodo execute definito dall'interfaccia Command.
//    // Questo metodo viene chiamato per eseguire l'azione di impostazione dei nuovi prezzi dei biglietti.
//    @Override
//    public void execute() {
//        if (prezzoIntero < 0 || prezzoRidotto < 0) {
//            throw new IllegalArgumentException("I prezzi dei biglietti non possono essere negativi.");
//        }
//        Cinema.getInstance().getGestorePrezzi().impostaPrezziIniziali(prezzoIntero, prezzoRidotto);
//        System.out.println("Prezzi biglietti impostati: intero a " + prezzoIntero + "€, ridotto a " + prezzoRidotto + "€.");
//    }
//}
