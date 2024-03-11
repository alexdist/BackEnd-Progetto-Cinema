package user_commands.annulla_biglietto;

//import revenues.IRegistroBiglietti;
//import revenues.RegistroBiglietti;
import revenues_observer.observable.AbstractRegistroBiglietti;
//import revenues_observer.observable.IRegistroBiglietti;
import user_interfaces.IUserCommand;

public class AnnullaBigliettoCommand implements IUserCommand {

    private long id;
    private AbstractRegistroBiglietti annulla;
    public AnnullaBigliettoCommand(long id, AbstractRegistroBiglietti annulla){
        this.id = id;
        this.annulla = annulla;
    }


    public void execute(){
        annulla.annullaAcquisto(id);
    }
}
