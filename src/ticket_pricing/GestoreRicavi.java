package ticket_pricing;

import cinema_Infrastructure.Spettacolo;
import ticket.Biglietto;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsabile della gestione dei ricavi generati dalla vendita dei biglietti degli spettacoli.
 * Tiene traccia dei biglietti venduti e dei ricavi generati per ogni spettacolo.
 */
public class GestoreRicavi {
    // Mappa che associa ciascuno spettacolo al numero di biglietti venduti.
    private Map<Spettacolo, Integer> bigliettiVendutiPerSpettacolo;
    // Mappa che associa ciascuno spettacolo ai ricavi generati dalla vendita dei biglietti.
    private Map<Spettacolo, Double> ricaviPerSpettacolo;

    /**
     * Costruttore della classe che inizializza le strutture dati per tenere traccia
     * dei biglietti venduti e dei ricavi per spettacolo.
     */
    public GestoreRicavi() {
        this.bigliettiVendutiPerSpettacolo = new HashMap<>();
        this.ricaviPerSpettacolo = new HashMap<>();
    }

    /**
     * Registra la vendita di un biglietto, aggiornando il conteggio dei biglietti venduti
     * e i ricavi generati per lo spettacolo corrispondente.
     *
     * @param biglietto Il biglietto venduto.
     */
    public void registraVenditaBiglietto(Biglietto biglietto) {
        Spettacolo spettacolo = biglietto.getSpettacolo();
        double prezzo = biglietto.getCosto();
        // Incrementa il conteggio dei biglietti venduti e aggiorna i ricavi per lo spettacolo.
        bigliettiVendutiPerSpettacolo.merge(spettacolo, 1, Integer::sum);
        ricaviPerSpettacolo.merge(spettacolo, prezzo, Double::sum);
    }

    /**
     * Stampa un report dei ricavi generati dalla vendita dei biglietti per ogni spettacolo.
     * Viene stampato solo se sono stati venduti biglietti validi (non annullati) per lo spettacolo.
     */
    public void stampaReportRicavi() {
        for (Spettacolo spettacolo : bigliettiVendutiPerSpettacolo.keySet()) {
            Integer bigliettiVenduti = bigliettiVendutiPerSpettacolo.get(spettacolo);
            Double ricavi = ricaviPerSpettacolo.get(spettacolo);
            // Stampa il report dei ricavi per ogni spettacolo con biglietti venduti.
            if (bigliettiVenduti > 0) {
                System.out.println("Spettacolo: " + spettacolo.getFilm().getTitolo() +
                        ", Biglietti Venduti: " + bigliettiVenduti +
                        ", Ricavo: €" + ricavi);
            }
        }
    }

    /**
     * Annulla la vendita di un biglietto, decrementando il conteggio dei biglietti venduti
     * e deducendo i ricavi corrispondenti per lo spettacolo del biglietto.
     *
     * @param biglietto Il biglietto la cui vendita deve essere annullata.
     */
    public void annullaVenditaBiglietto(Biglietto biglietto) {
        Spettacolo spettacolo = biglietto.getSpettacolo();
        double prezzo = biglietto.getCosto();
        // Decrementa il conteggio dei biglietti venduti e aggiorna i ricavi per lo spettacolo.
        bigliettiVendutiPerSpettacolo.merge(spettacolo, -1, Integer::sum);
        ricaviPerSpettacolo.merge(spettacolo, -prezzo, Double::sum);
    }
}
