package user_services;



import cinema_Infrastructure.sala.ISala;
import cinema_Infrastructure.sala.Sala;
import cinema_Infrastructure.spettacolo.Spettacolo;

import payment_strategy.IMetodoPagamentoStrategy;
import payment_strategy.PayContext;

import revenues.RegistroBiglietti;
import ticket.factory.IBiglietto;
import user_interfaces.AcquistoBiglietto;




import java.time.LocalDateTime;

public class ServizioAcquistoBiglietto implements AcquistoBiglietto {
    private PayContext pay;


    public ServizioAcquistoBiglietto(PayContext pay) {
        this.pay = pay;
    }

    @Override
    public void acquistaBiglietto(IBiglietto biglietto) {


        //if (sala.occupaPosto()) { // Verifica la disponibilità di posti prima dell'acquisto
        pay.eseguiPagamento(biglietto.getCosto());
        RegistroBiglietti.aggiungiBiglietto(biglietto);



        System.out.println("Biglietto acquistato con successo per lo spettacolo: "
                + biglietto.getSpettacolo().getFilm().getTitolo() + " al costo di: " + biglietto.getCosto());
//        } else {
//            System.out.println("Non è stato possibile acquistare il biglietto: posti esauriti.");
//        }
    }
}

