package admin_commands.prezzi_biglietto;

import admin_interfaces.ICommand;
import ticket_pricing.IPrezziBiglietto;

public class ImpostaSovrapprezzoCommand implements ICommand {

    private IPrezziBiglietto impostaSovrapprezzo;
    private double sovrapprezzo;

    public ImpostaSovrapprezzoCommand(IPrezziBiglietto impostaSovrapprezzo, double sovrapprezzo){
        this.impostaSovrapprezzo = impostaSovrapprezzo;
        this.sovrapprezzo = sovrapprezzo;
    }

    public void execute(){
        impostaSovrapprezzo.setSovrapprezzo(sovrapprezzo);
    }
}
