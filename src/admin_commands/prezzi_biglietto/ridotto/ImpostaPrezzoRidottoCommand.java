package admin_commands.prezzi_biglietto.ridotto;

import admin_interfaces.ICommand;
import ticket_pricing.IPrezziBiglietto;

public class ImpostaPrezzoRidottoCommand implements ICommand {

    private IPrezziBiglietto impostaRidotto;
    private double prezzoRidotto;

    public ImpostaPrezzoRidottoCommand(IPrezziBiglietto impostaRidotto, double prezzoRidotto){
        this.impostaRidotto = impostaRidotto;
        this.prezzoRidotto = prezzoRidotto;
    }

    public void execute(){
        impostaRidotto.setPrezzoRidotto(prezzoRidotto);
    }
}