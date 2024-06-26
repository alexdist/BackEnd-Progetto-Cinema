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

//    @Override
//    public void acquistaBiglietto(IBiglietto biglietto) {
//
//
//        if (biglietto.getSpettacolo().getSala().occupaPosto()) { // Verifica la disponibilità di posti prima dell'acquisto
//        pay.eseguiPagamento(biglietto.getCosto());
//        registro.aggiungiBiglietto(biglietto);
//
//
//
//        System.out.println("Biglietto acquistato con successo per lo spettacolo: "
//                + biglietto.getSpettacolo().getFilm().getTitolo() + " al costo di: " + biglietto.getCosto());
//        } else {
//            System.out.println("Non è stato possibile acquistare il biglietto: posti esauriti.");
//        }
//    }

    @Override
    public boolean acquistaBiglietto(IBiglietto biglietto) {

            pay.eseguiPagamento(biglietto.getCosto());
            registro.aggiungiBiglietto(biglietto);
           // biglietto.getSpettacolo().getSala().occupaPosto();
//            System.out.println("Biglietto acquistato con successo per lo spettacolo: "
//                    + biglietto.getSpettacolo().getFilm().getTitolo() + " al costo di: " + biglietto.getCosto());
            return true; // Acquisto riuscito
    }


}

