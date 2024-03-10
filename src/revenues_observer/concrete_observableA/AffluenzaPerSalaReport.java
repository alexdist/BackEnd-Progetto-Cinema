package revenues_observer.concrete_observableA;

import revenues_observer.observable.IRegistroBiglietti;
import revenues_observer.observer.IReport;
import ticket.factory.product.IBiglietto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//CONCRETE OBSERVABLE A
public class AffluenzaPerSalaReport implements IReport {
    private List<IBiglietto> biglietti;
    private IRegistroBiglietti registro;

    public AffluenzaPerSalaReport(IRegistroBiglietti registro) {
        this.registro = registro;
        this.biglietti = registro.getBiglietti();
        registro.addObserver(this);
    }

    @Override
    public void update() {
        this.biglietti = registro.getBiglietti();
        // Aggiorna il report qui o solo quando viene chiamato il metodo generate.
    }

    @Override
    public void generate() {
        Map<Integer, Integer> affluenzaPerSala = new HashMap<>();
        for (IBiglietto biglietto : biglietti) {
            int numeroSala = biglietto.getSpettacolo().getSala().getNumeroSala();
            affluenzaPerSala.merge(numeroSala, 1, Integer::sum);
        }
        System.out.println("Report Affluenza per Sala:");
        affluenzaPerSala.forEach((sala, affluenza) ->
                System.out.println("Sala " + sala + ": affluenza totale = " + affluenza + " persone"));
    }
}
