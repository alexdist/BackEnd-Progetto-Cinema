package revenues;

import ticket.factory.IBiglietto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistroBiglietti {
    private static List<IBiglietto> biglietti = new ArrayList<>();

//    public RegistroBiglietti() {
//        biglietti = new ArrayList<>();
//    }

    public static void aggiungiBiglietto(IBiglietto biglietto) {
        biglietti.add(biglietto);
    }

//    public static void reportRicaviPerSala() {
//        Map<Integer, Double> ricaviPerSala = new HashMap<>();
//        for (IBiglietto biglietto : biglietti) {
//            ricaviPerSala.merge(biglietto.getSpettacolo().getSala().getNumeroSala(), biglietto.getCosto(), Double::sum);
//        }
//
//        for (Map.Entry<Integer, Double> entry : ricaviPerSala.entrySet()) {
//            System.out.println("Sala " + entry.getKey() + ": ricavi totali = " + entry.getValue() + "€");
//        }
//    }

    public static void reportRicaviPerSala() {
        Map<Integer, Double> ricaviPerSala = new HashMap<>();
        for (IBiglietto biglietto : biglietti) {
            int numeroSala = biglietto.getSpettacolo().getSala().getNumeroSala();
            ricaviPerSala.merge(numeroSala, biglietto.getCosto(), Double::sum);
        }

        for (Map.Entry<Integer, Double> entry : ricaviPerSala.entrySet()) {
            System.out.println("Sala " + entry.getKey() + ": ricavi totali = " + entry.getValue() + "€");
        }
    }

    public static void reportAffluenzaPerSala() {
        Map<Integer, Integer> affluenzaPerSala = new HashMap<>();
        for (IBiglietto biglietto : biglietti) {
            int numeroSala = biglietto.getSpettacolo().getSala().getNumeroSala();
            affluenzaPerSala.merge(numeroSala, 1, Integer::sum); // Incrementa il conteggio per ogni biglietto
        }

        for (Map.Entry<Integer, Integer> entry : affluenzaPerSala.entrySet()) {
            System.out.println("Sala " + entry.getKey() + ": affluenza totale = " + entry.getValue() + " persone");
        }
    }

    public static boolean annullaAcquisto(long idBiglietto) {
        IBiglietto bigliettoDaAnnullare = biglietti.stream()
                .filter(b -> b.getId() == idBiglietto)
                .findFirst()
                .orElse(null);

        if (bigliettoDaAnnullare != null) {
            LocalDateTime tempoDiAcquisto = bigliettoDaAnnullare.getTimestampAcquisto();
            LocalDateTime tempoLimite = tempoDiAcquisto.plusMinutes(10);
            if (LocalDateTime.now().isBefore(tempoLimite)) {
                biglietti.remove(bigliettoDaAnnullare);
                return true;
            }
        }
        return false;
    }

    public List<IBiglietto> getBiglietti() {
        return biglietti;
    }
}