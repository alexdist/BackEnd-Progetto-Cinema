package revenues;

import ticket.factory.IBiglietto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RicaviPerSalaReport implements IReport {
    private List<IBiglietto> biglietti;

    public RicaviPerSalaReport(List<IBiglietto> biglietti) {
        this.biglietti = biglietti;
    }

    @Override
    public void generate() {
        Map<Integer, Double> ricaviPerSala = new HashMap<>();
        for (IBiglietto biglietto : biglietti) {
            int numeroSala = biglietto.getSpettacolo().getSala().getNumeroSala();
            ricaviPerSala.merge(numeroSala, biglietto.getCosto(), Double::sum);
        }
        System.out.println("Report Ricavi per Sala:");
        ricaviPerSala.forEach((sala, ricavo) ->
                System.out.println("Sala " + sala + ": ricavi totali = " + ricavo + "€"));

    }
}
