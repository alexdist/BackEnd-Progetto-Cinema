package admin_commands.prezzi_biglietto.ridotto;

import admin_interfaces.ICommand;
import ticket_pricing.IPrezziBiglietto;

// ImpostaPrezzoRidottoCommand è un 'ConcreteCommand' che implementa l'interfaccia ICommand.
// Questa classe definisce interagisce con IPrezziBiglietto per settare il prezzo dei Biglietti.
public class ImpostaPrezzoRidottoCommand implements ICommand {

    // Interfaccia per la gestione dei prezzi dei biglietti.
    private IPrezziBiglietto impostaRidotto;

    // Prezzo ridotto da impostare.
    private double prezzoRidotto;

    public ImpostaPrezzoRidottoCommand(IPrezziBiglietto impostaRidotto, double prezzoRidotto){
        this.impostaRidotto = impostaRidotto;
        this.prezzoRidotto = prezzoRidotto;
    }


    // Metodo che esegue l'azione del comando, impostando il nuovo prezzo ridotto.
    public void execute(){
        impostaRidotto.setPrezzoRidotto(prezzoRidotto);
    }
}