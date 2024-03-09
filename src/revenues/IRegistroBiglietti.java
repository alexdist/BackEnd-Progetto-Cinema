package revenues;

import ticket.factory.IBiglietto;

import java.util.List;

// Interfaccia per la gestione dei biglietti
public interface IRegistroBiglietti {
    void aggiungiBiglietto(IBiglietto biglietto);
    boolean annullaAcquisto(long idBiglietto);
    List<IBiglietto> getBiglietti();
//    void salvaBiglietti(String filePath);
//    void caricaBiglietti(String filePath);
}