package admin_commands.prezzi_biglietto.intero;

import admin_commands.prezzi_biglietto.intero.ImpostaPrezzoInteroCommand;
import admin_interfaces.ICommand;
import domain.Amministratore;
import domain.Ruolo;
import ticket_pricing.IPrezziBiglietto;
import ticket_pricing.PrezziBiglietto;

public class TestImpostaIntero {

    public static void main(String[] args) {
        // Creazione dell'oggetto PrezziBiglietto con prezzi iniziali
        IPrezziBiglietto prezziBiglietto = new PrezziBiglietto(10.0, 7.5);

        // Stampa dei prezzi iniziali
        System.out.println("Prezzo intero iniziale: " + prezziBiglietto.getPrezzoIntero());
        System.out.println("Prezzo ridotto iniziale: " + prezziBiglietto.getPrezzoRidotto());

        // Impostazione del comando per cambiare il prezzo intero a 12.0
        ICommand cambiaPrezzoIntero = new ImpostaPrezzoInteroCommand(prezziBiglietto, 12.0);

        // Creazione dell'amministratore che può cambiare i prezzi
        Amministratore amministratore = new Amministratore("Mario", "Rossi", Ruolo.AMMINISTRATORE);


        amministratore.setCommand(cambiaPrezzoIntero);

        // Esecuzione del comando tramite l'amministratore
        try {
            amministratore.eseguiComando();
        } catch (Exception e) {
            System.out.println("Si è verificato un errore nell'esecuzione del comando.");
            // Qui si potrebbero gestire le varie eccezioni se necessario
        }

        // Stampa dei prezzi dopo l'esecuzione del comando
        System.out.println("\nPrezzo intero dopo l'esecuzione del comando: " + prezziBiglietto.getPrezzoIntero());
        System.out.println("Prezzo ridotto dopo l'esecuzione del comando: " + prezziBiglietto.getPrezzoRidotto());
    }
}
