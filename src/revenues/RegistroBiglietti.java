package revenues;

import ticket.factory.product.IBiglietto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Implementazione concreta del registro dei biglietti
public class RegistroBiglietti implements IRegistroBiglietti {
    private List<IBiglietto> biglietti = new ArrayList<>();


    public RegistroBiglietti() {

    }

    @Override
    public void aggiungiBiglietto(IBiglietto biglietto) {
        biglietti.add(biglietto);
    }

    @Override
    public boolean annullaAcquisto(long idBiglietto) {
        for (IBiglietto biglietto : biglietti) {
            if (biglietto.getId() == idBiglietto) {
                LocalDateTime tempoDiAcquisto = biglietto.getTimestampAcquisto();
                LocalDateTime tempoLimite = tempoDiAcquisto.plusMinutes(10);
                if (LocalDateTime.now().isBefore(tempoLimite)) {
                    biglietti.remove(biglietto);
                    return true;
                }
                break;
            }
        }
        return false;
    }

    @Override
    public List<IBiglietto> getBiglietti() {
        return new ArrayList<>(biglietti);
    }

//    @Override
//    public void salvaBiglietti(String filePath) {
//        serializer.serialize(biglietti, filePath);
//    }

//    @Override
//    public void caricaBiglietti(String filePath) {
//        List<IBiglietto> loadedBiglietti = (List<IBiglietto>) serializer.deserialize(filePath);
//        if (loadedBiglietti != null) {
//            this.biglietti = loadedBiglietti;
//        }
//    }
}