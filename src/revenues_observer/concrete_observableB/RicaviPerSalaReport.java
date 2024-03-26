package revenues_observer.concrete_observableB;

import revenues_observer.observable.AbstractRegistroBiglietti;
//import revenues_observer.observable.IRegistroBiglietti;
import revenues_observer.observer.IReport;
import ticket.factory.product.IBiglietto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//CONCRETE OBSERVABLE B
public class RicaviPerSalaReport implements IReport, Serializable {
    private List<IBiglietto> biglietti;
    private AbstractRegistroBiglietti registro;

    private Map<Integer, Double> ricaviPerSala; // Aggiunto per mantenere lo stato attuale dei ricavi per sala

    public RicaviPerSalaReport(AbstractRegistroBiglietti registro) {
        this.registro = registro;
        this.biglietti = registro.getBiglietti();
        this.ricaviPerSala = new HashMap<>();
        registro.addObserver(this);
    }

    @Override
    public void update() {
        this.biglietti = registro.getBiglietti();
        // Aggiorna il report qui o solo quando viene chiamato il metodo generate.
    }

    @Override
    public void generate() {
        ricaviPerSala.clear();
       // Map<Integer, Double> ricaviPerSala = new HashMap<>();
        for (IBiglietto biglietto : biglietti) {
            int numeroSala = biglietto.getSpettacolo().getSala().getNumeroSala();
            ricaviPerSala.merge(numeroSala, biglietto.getCosto(), Double::sum);
        }
        System.out.println("Report Ricavi per Sala:");
        ricaviPerSala.forEach((sala, ricavo) ->
                System.out.println("Sala " + sala + ": ricavi totali = " + ricavo + "€"));
    }
    public Map<Integer, Double> getRicaviPerSala() {
        return new HashMap<>(ricaviPerSala);
    }
}
//public class RicaviPerSalaReport implements IReport {
//    private List<IBiglietto> biglietti;
//    private IRegistroBiglietti registro;
//
//    public RicaviPerSalaReport(IRegistroBiglietti registro) {
//        this.registro = registro;
//        this.biglietti = registro.getBiglietti();
//        registro.addObserver(this);
//    }
//
//    @Override
//    public void update() {
//        this.biglietti = registro.getBiglietti();
//        // Aggiorna il report qui o solo quando viene chiamato il metodo generate.
//    }
//
//    @Override
//    public void generate() {
//        Map<Integer, Double> ricaviPerSala = new HashMap<>();
//        for (IBiglietto biglietto : biglietti) {
//            int numeroSala = biglietto.getSpettacolo().getSala().getNumeroSala();
//            ricaviPerSala.merge(numeroSala, biglietto.getCosto(), Double::sum);
//        }
//        System.out.println("Report Ricavi per Sala:");
//        ricaviPerSala.forEach((sala, ricavo) ->
//                System.out.println("Sala " + sala + ": ricavi totali = " + ricavo + "€"));
//    }
//}
