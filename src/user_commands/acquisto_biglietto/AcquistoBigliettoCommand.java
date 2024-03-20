package user_commands.acquisto_biglietto;

import ticket.factory.product.IBiglietto;
import user_interfaces.AcquistoBiglietto;
import user_interfaces.IUserCommand;

import java.io.Serializable;

public class AcquistoBigliettoCommand implements IUserCommand, Serializable {

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
