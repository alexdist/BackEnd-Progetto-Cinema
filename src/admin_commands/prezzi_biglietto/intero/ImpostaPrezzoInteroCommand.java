package admin_commands.prezzi_biglietto.intero;

import admin_interfaces.ICommand;
import ticket_pricing.IPrezziBiglietto;

public class ImpostaPrezzoInteroCommand implements ICommand {

    private IPrezziBiglietto impostaIntero;
    private double prezzoIntero;

    public ImpostaPrezzoInteroCommand(IPrezziBiglietto impostaIntero, double prezzoIntero){
        this.impostaIntero = impostaIntero;
        this.prezzoIntero = prezzoIntero;
    }

    public void execute(){
        impostaIntero.setPrezzoIntero(prezzoIntero);
    }
}
