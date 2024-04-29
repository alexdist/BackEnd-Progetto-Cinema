package admin_commands.prezzi_biglietto.intero;

import admin_interfaces.ICommand;
import ticket_pricing.IPrezziBiglietto;

// ImpostaPrezzoInteroCommand è un 'ConcreteCommand' che implementa l'interfaccia ICommand.
// Questa classe definisce interagisce con IPrezziBiglietto per settare il prezzo dei Biglietti.
public class ImpostaPrezzoInteroCommand implements ICommand {

    // Interfaccia per la gestione dei prezzi dei biglietti.
    private IPrezziBiglietto impostaIntero;

    // Prezzo intero da impostare.
    private double prezzoIntero;

    public ImpostaPrezzoInteroCommand(IPrezziBiglietto impostaIntero, double prezzoIntero){
        this.impostaIntero = impostaIntero;
        this.prezzoIntero = prezzoIntero;
    }


    // Metodo che esegue l'azione del comando, impostando il nuovo prezzo intero.
    public void execute(){
        impostaIntero.setPrezzoIntero(prezzoIntero);
    }
}
