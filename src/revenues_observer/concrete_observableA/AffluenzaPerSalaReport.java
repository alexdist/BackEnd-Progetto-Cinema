package revenues_observer.concrete_observableA;

import revenues_observer.observable.AbstractRegistroBiglietti;
//import revenues_observer.observable.IRegistroBiglietti;
import revenues_observer.observer.IReport;
import ticket.factory.product.IBiglietto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//CONCRETE OBSERVABLE A
public class AffluenzaPerSalaReport implements IReport, Serializable {
    private List<IBiglietto> biglietti;
    private AbstractRegistroBiglietti registro;
    private Map<Integer, Integer> affluenzaPerSala; // Aggiunto per mantenere lo stato attuale dell'affluenza per sala

    public AffluenzaPerSalaReport(AbstractRegistroBiglietti registro) {
        this.registro = registro;
        this.biglietti = registro.getBiglietti();
        this.affluenzaPerSala = new HashMap<>();
        registro.addObserver(this);
    }

    @Override
    public void update() {
        this.biglietti = registro.getBiglietti();
        // Aggiorna il report qui o solo quando viene chiamato il metodo generate.
    }

    @Override
    public void generate() {
        affluenzaPerSala.clear();
        //Map<Integer, Integer> affluenzaPerSala = new HashMap<>();
        for (IBiglietto biglietto : biglietti) {
            int numeroSala = biglietto.getSpettacolo().getSala().getNumeroSala();
            affluenzaPerSala.merge(numeroSala, 1, Integer::sum);
        }
        System.out.println("Report Affluenza per Sala:");
        affluenzaPerSala.forEach((sala, affluenza) ->
                System.out.println("Sala " + sala + ": affluenza totale = " + affluenza + " persone"));
    }
    public Map<Integer, Integer> getAffluenzaPerSala() {
        return new HashMap<>(affluenzaPerSala);
    }
}
//public class AffluenzaPerSalaReport implements IReport {
//    private List<IBiglietto> biglietti;
//    private IRegistroBiglietti registro;
//
//    public AffluenzaPerSalaReport(IRegistroBiglietti registro) {
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
//        Map<Integer, Integer> affluenzaPerSala = new HashMap<>();
//        for (IBiglietto biglietto : biglietti) {
//            int numeroSala = biglietto.getSpettacolo().getSala().getNumeroSala();
//            affluenzaPerSala.merge(numeroSala, 1, Integer::sum);
//        }
//        System.out.println("Report Affluenza per Sala:");
//        affluenzaPerSala.forEach((sala, affluenza) ->
//                System.out.println("Sala " + sala + ": affluenza totale = " + affluenza + " persone"));
//    }
//}
