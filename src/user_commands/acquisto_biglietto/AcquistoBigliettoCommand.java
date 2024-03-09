package user_commands.acquisto_biglietto;

import payment_strategy.IMetodoPagamentoStrategy;
import ticket.factory.IBiglietto;
import user_interfaces.AcquistoBiglietto;
import user_interfaces.IUserCommand;

public class AcquistoBigliettoCommand implements IUserCommand {

    private AcquistoBiglietto acquisto;

    private IBiglietto biglietto;

   // private IMetodoPagamentoStrategy metodoPagamento;

    public AcquistoBigliettoCommand(AcquistoBiglietto acquisto, IBiglietto biglietto){
        this.acquisto = acquisto;
        this.biglietto = biglietto;
        //this.metodoPagamento = metodoPagamento;
    }

    public void execute(){
        acquisto.acquistaBiglietto(biglietto);
    }

}
