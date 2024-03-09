package user_commands.annulla_biglietto;

import revenues.RegistroBiglietti;
import user_interfaces.IUserCommand;

public class AnnullaBigliettoCommand implements IUserCommand {

    private long id;
    public AnnullaBigliettoCommand(long id){
        this.id = id;
    }


    public void execute(){
        RegistroBiglietti.annullaAcquisto(id);
    }
}
