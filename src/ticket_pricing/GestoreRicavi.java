//package ticket_pricing;
//
//import Serializzazione.GestoreRicaviSerializer;
//import cinema_Infrastructure.spettacolo.Spettacolo;
//import singleton.Cinema;
//import ticket.Biglietto;
//
//import java.io.Serializable;
//import java.util.HashMap;
//import java.util.Map;

/**
 * Classe responsabile della gestione dei ricavi generati dalla vendita dei biglietti degli spettacoli.
 * Tiene traccia dei biglietti venduti e dei ricavi generati per ogni spettacolo.
 */

//public class GestoreRicavi implements Serializable{
//    // Mappa che associa ciascuno spettacolo al numero di biglietti venduti.
//    private Map<Spettacolo, Integer> bigliettiVendutiPerSpettacolo;
//    // Mappa che associa ciascuno spettacolo ai ricavi generati dalla vendita dei biglietti.
//    private Map<Spettacolo, Double> ricaviPerSpettacolo;
//
//    /**
//     * Costruttore della classe che inizializza le strutture dati per tenere traccia
//     * dei biglietti venduti e dei ricavi per spettacolo.
//     */
//    public GestoreRicavi() {
//        this.bigliettiVendutiPerSpettacolo = new HashMap<>();
//        this.ricaviPerSpettacolo = new HashMap<>();
//    }
//
//    /**
//     * Registra la vendita di un biglietto, aggiornando il conteggio dei biglietti venduti
//     * e i ricavi generati per lo spettacolo corrispondente.
//     *
//     * @param biglietto Il biglietto venduto.
//     */
//    public void registraVenditaBiglietto(Biglietto biglietto) {
//        Spettacolo spettacolo = biglietto.getSpettacolo();
//        double prezzo = biglietto.getCosto();
//        // Incrementa il conteggio dei biglietti venduti e aggiorna i ricavi per lo spettacolo.
//        bigliettiVendutiPerSpettacolo.merge(spettacolo, 1, Integer::sum);
//        ricaviPerSpettacolo.merge(spettacolo, prezzo, Double::sum);
//
//    }
//
//    /**
//     * Stampa un report dei ricavi generati dalla vendita dei biglietti per ogni spettacolo.
//     * Viene stampato solo se sono stati venduti biglietti validi (non annullati) per lo spettacolo.
//     */
//    public void stampaReportRicavi() {
//        for (Spettacolo spettacolo : bigliettiVendutiPerSpettacolo.keySet()) {
//            Integer bigliettiVenduti = bigliettiVendutiPerSpettacolo.get(spettacolo);
//            Double ricavi = ricaviPerSpettacolo.get(spettacolo);
//            // Stampa il report dei ricavi per ogni spettacolo con biglietti venduti.
//            if (bigliettiVenduti > 0) {
//                System.out.println("Spettacolo: " + spettacolo.getFilm().getTitolo() +
//                        ", Biglietti Venduti: " + bigliettiVenduti +
//                        ", Ricavo: €" + ricavi);
//            }
//        }
//    }
//
//    /**
//     * Annulla la vendita di un biglietto, decrementando il conteggio dei biglietti venduti
//     * e deducendo i ricavi corrispondenti per lo spettacolo del biglietto.
//     *
//     * @param biglietto Il biglietto la cui vendita deve essere annullata.
//     */
////    public void annullaVenditaBiglietto(Biglietto biglietto) {
////        Spettacolo spettacolo = biglietto.getSpettacolo();
////        double prezzo = biglietto.getCosto();
////        // Decrementa il conteggio dei biglietti venduti e aggiorna i ricavi per lo spettacolo.
////        bigliettiVendutiPerSpettacolo.merge(spettacolo, -1, Integer::sum);
////        ricaviPerSpettacolo.merge(spettacolo, -prezzo, Double::sum);
////    }
//
//    public void annullaVenditaBiglietto(Biglietto biglietto) {
//        Spettacolo spettacolo = biglietto.getSpettacolo();
//        double prezzo = biglietto.getCosto();
//        // Assicurati di controllare che il biglietto e lo spettacolo esistano prima di procedere
//        if (bigliettiVendutiPerSpettacolo.containsKey(spettacolo) && ricaviPerSpettacolo.containsKey(spettacolo)) {
//            bigliettiVendutiPerSpettacolo.put(spettacolo, bigliettiVendutiPerSpettacolo.get(spettacolo) - 1);
//            ricaviPerSpettacolo.put(spettacolo, ricaviPerSpettacolo.get(spettacolo) - prezzo);
//        }
//    }
//
//    /**
//     * Restituisce i ricavi generati da uno spettacolo specifico.
//     * @param idSpettacolo L'ID dello spettacolo per il quale si vogliono conoscere i ricavi.
//     * @return I ricavi generati dallo spettacolo.
//     */
//    public double getRicaviDaSpettacolo(String idSpettacolo) {
//        return ricaviPerSpettacolo.entrySet().stream()
//                .filter(entry -> entry.getKey().getId().equals(idSpettacolo))
//                .map(Map.Entry::getValue)
//                .findFirst()
//                .orElse(0.0);
//    }
//
//    /**
//     * Restituisce il numero di biglietti venduti per uno spettacolo specifico.
//     * @param idSpettacolo L'ID dello spettacolo per il quale si vogliono conoscere i biglietti venduti.
//     * @return Il numero di biglietti venduti per lo spettacolo.
//     */
//    public int getBigliettiVendutiDaSpettacolo(String idSpettacolo) {
//        return bigliettiVendutiPerSpettacolo.entrySet().stream()
//                .filter(entry -> entry.getKey().getId().equals(idSpettacolo))
//                .map(Map.Entry::getValue)
//                .findFirst()
//                .orElse(0);
//    }
//}

//public class GestoreRicavi implements Serializable {
//    private Map<String, Integer> bigliettiVendutiPerSpettacolo;
//    private Map<String, Double> ricaviPerSpettacolo;
//
//    public GestoreRicavi() {
//        this.bigliettiVendutiPerSpettacolo = new HashMap<>();
//        this.ricaviPerSpettacolo = new HashMap<>();
//    }
//
//    public void registraVenditaBiglietto(Biglietto biglietto) {
//        String idSpettacolo = biglietto.getSpettacolo().getId();
//        double prezzo = biglietto.getCosto();
//        bigliettiVendutiPerSpettacolo.merge(idSpettacolo, 1, Integer::sum);
//        ricaviPerSpettacolo.merge(idSpettacolo, prezzo, Double::sum);
//        GestoreRicaviSerializer.salvaStatoGestoreRicavi(Cinema.getInstance().getGestoreRicavi(), "gestoreRicavi.ser");
//    }
//
//    public void annullaVenditaBiglietto(Biglietto biglietto) {
//        String idSpettacolo = biglietto.getSpettacolo().getId();
//        double prezzo = biglietto.getCosto();
//        bigliettiVendutiPerSpettacolo.computeIfPresent(idSpettacolo, (k, v) -> v > 1 ? v - 1 : null);
//        ricaviPerSpettacolo.computeIfPresent(idSpettacolo, (k, v) -> v - prezzo > 0 ? v - prezzo : null);
//    }
//
//    public double getRicaviDaSpettacolo(String idSpettacolo) {
//        return ricaviPerSpettacolo.getOrDefault(idSpettacolo, 0.0);
//    }
//
//    public int getBigliettiVendutiDaSpettacolo(String idSpettacolo) {
//        return bigliettiVendutiPerSpettacolo.getOrDefault(idSpettacolo, 0);
//    }
//    // Metodo per stampare un report dei ricavi per ogni spettacolo
//    public void stampaReportRicavi() {
//        // Ottiene tutti gli spettacoli dal sistema di gestione del cinema
//        var spettacoli = Cinema.getInstance().getGestioneCinema().getProgrammazione();
//
//        // Se non ci sono spettacoli, stampa un messaggio e termina l'esecuzione del metodo
//        if (spettacoli.isEmpty()) {
//            System.out.println("Non ci sono spettacoli programmati al momento.");
//            return;
//        }
//
//        // Itera su ogni spettacolo per stampare i ricavi e i biglietti venduti
//        for (Spettacolo spettacolo : spettacoli) {
//            String idSpettacolo = spettacolo.getId();
//            double ricavi = this.getRicaviDaSpettacolo(idSpettacolo);
//            int bigliettiVenduti = this.getBigliettiVendutiDaSpettacolo(idSpettacolo);
//
//            System.out.println("Spettacolo: " + spettacolo.getFilm().getTitolo() + " (ID: " + idSpettacolo + ")");
//            System.out.println("\tRicavi: " + ricavi + " EUR");
//            System.out.println("\tBiglietti Venduti: " + bigliettiVenduti);
//        }
//
//        // Aggiungi qui eventuali altre logiche per la stampa del report complessivo se necessario
//    }
//
//
//    public void stampaReportRicavi() {
//        for (Spettacolo spettacolo : bigliettiVendutiPerSpettacolo.keySet()) {
//            Integer bigliettiVenduti = bigliettiVendutiPerSpettacolo.get(spettacolo);
//            Double ricavi = ricaviPerSpettacolo.get(spettacolo);
//            // Stampa il report dei ricavi per ogni spettacolo con biglietti venduti.
//            if (bigliettiVenduti > 0) {
//                System.out.println("Spettacolo: " + spettacolo.getFilm().getTitolo() +
//                        ", Biglietti Venduti: " + bigliettiVenduti +
//                        ", Ricavo: €" + ricavi);
//            }
//        }
//    }
//}

