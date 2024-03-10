package user_commands.annulla_biglietto;

//import revenues.IRegistroBiglietti;
//import revenues.RegistroBiglietti;
import revenues_observer.observable.IRegistroBiglietti;
import user_interfaces.IUserCommand;

public class AnnullaBigliettoCommand implements IUserCommand {

    private long id;
    private IRegistroBiglietti annulla;
    public AnnullaBigliettoCommand(long id, IRegistroBiglietti annulla){
        this.id = id;
        this.annulla = annulla;
    }


    public void execute(){
        annulla.annullaAcquisto(id);
    }
}
