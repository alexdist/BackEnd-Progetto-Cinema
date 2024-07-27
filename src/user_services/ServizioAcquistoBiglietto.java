package user_services;



import payment_strategy.PayContext;

//import revenues.IRegistroBiglietti;
import revenues_observer.observable.AbstractRegistroBiglietti;
//import revenues_observer.observable.IRegistroBiglietti;
import ticket.factory.product.IBiglietto;
import user_interfaces.AcquistoBiglietto;

import java.io.Serializable;

public class ServizioAcquistoBiglietto implements AcquistoBiglietto, Serializable {
    private PayContext pay;
    private AbstractRegistroBiglietti registro;


    public ServizioAcquistoBiglietto(PayContext pay, AbstractRegistroBiglietti registro) {
        this.pay = pay;
        this.registro = registro;
    }



    @Override
    public boolean acquistaBiglietto(IBiglietto biglietto) {

            pay.eseguiPagamento(biglietto.getCosto());
            registro.aggiungiBiglietto(biglietto);

            return true; // Acquisto riuscito
    }


}

