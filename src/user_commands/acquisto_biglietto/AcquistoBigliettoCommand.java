package user_commands.acquisto_biglietto;

import ticket.factory.product.IBiglietto;
import user_interfaces.AcquistoBiglietto;
import user_interfaces.IUserCommand;

import java.io.Serializable;

// Questa classe rappresenta un ConcreteCommand nel pattern Command.
// Implementa l'interfaccia Command e invoca l'azione sul Receiver.
public class AcquistoBigliettoCommand implements IUserCommand, Serializable {

    private AcquistoBiglietto acquisto; // Riferimento al Receiver.

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
