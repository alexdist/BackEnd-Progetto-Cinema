//package revenues;
//
//import ticket.factory.product.IBiglietto;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class AffluenzaPerSalaReport implements IReport {
//    private List<IBiglietto> biglietti;
//
//    public AffluenzaPerSalaReport(List<IBiglietto> biglietti) {
//        this.biglietti = biglietti;
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
//
//    }
//}
