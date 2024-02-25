package ticket_pricing;

import cinema_Infrastructure.Spettacolo;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Gestisce la definizione e l'aggiornamento dei prezzi dei biglietti per il cinema,
 * inclusa la logica per l'applicazione di sovrapprezzi in base a criteri specifici,
 * come il weekend.
 */
public class GestorePrezzi implements Serializable {
    private static final long serialVersionUID = 1L;
    // Prezzi correnti per i biglietti interi e ridotti.
    private PrezziBiglietto prezziCorrenti;
    // Sovrapprezzo applicabile ai biglietti venduti durante il weekend.
    private double sovrapprezzoWeekend;

    /**
     * Costruttore per inizializzare i prezzi dei biglietti senza specificare il sovrapprezzo weekend.
     * @param prezzoIntero Il prezzo base per i biglietti interi.
     * @param prezzoRidotto Il prezzo base per i biglietti ridotti.
     */
    public GestorePrezzi(double prezzoIntero, double prezzoRidotto) {
        this.prezziCorrenti = new PrezziBiglietto(prezzoIntero, prezzoRidotto);
        // Imposta un valore predefinito per il sovrapprezzo weekend a 0.
        this.sovrapprezzoWeekend = 0;
    }

    /**
     * Costruttore esteso che permette di specificare anche il sovrapprezzo per il weekend.
     * @param prezzoIntero Il prezzo base per i biglietti interi.
     * @param prezzoRidotto Il prezzo base per i biglietti ridotti.
     * @param sovrapprezzoWeekend Il sovrapprezzo da applicare durante il weekend.
     */
    public GestorePrezzi(double prezzoIntero, double prezzoRidotto, double sovrapprezzoWeekend) {
        this.prezziCorrenti = new PrezziBiglietto(prezzoIntero, prezzoRidotto);
        this.sovrapprezzoWeekend = sovrapprezzoWeekend;
    }

    /**
     * Calcola il prezzo finale di un biglietto in base al giorno della settimana.
     * @param spettacolo Lo spettacolo per cui si acquista il biglietto.
     * @param tipoBiglietto Il tipo di biglietto ("intero" o "ridotto").
     * @return Il prezzo finale del biglietto.
     */
    public double calcolaPrezzoFinale(Spettacolo spettacolo, String tipoBiglietto) {
        LocalDateTime dataProiezione = spettacolo.getOrarioProiezione();
        boolean isWeekend = dataProiezione.getDayOfWeek() == DayOfWeek.SATURDAY || dataProiezione.getDayOfWeek() == DayOfWeek.SUNDAY;

        // Seleziona la strategia di prezzo in base al giorno della settimana.
        PrezzoStrategy strategiaPrezzo = isWeekend ?
                new SovrapprezzoFineSettimanaStrategy(sovrapprezzoWeekend) :
                new PrezzoStandardStrategy();

        // Utilizza la strategia selezionata per calcolare il prezzo finale.
        return strategiaPrezzo.calcolaPrezzo(spettacolo, tipoBiglietto, prezziCorrenti);
    }

    // Getter e setter per i prezzi correnti e il sovrapprezzo weekend.

    public PrezziBiglietto getPrezziCorrenti() {
        return prezziCorrenti;
    }

    public void setSovrapprezzoWeekend(double sovrapprezzoWeekend) {
        this.sovrapprezzoWeekend = sovrapprezzoWeekend;
    }

    /**
     * Aggiorna i prezzi dei biglietti applicando un aumento specificato.
     * @param aumentoIntero L'aumento da applicare al prezzo del biglietto intero.
     * @param aumentoRidotto L'aumento da applicare al prezzo del biglietto ridotto.
     */
    public void aumentaPrezzi(double aumentoIntero, double aumentoRidotto) {
        prezziCorrenti = new PrezziBiglietto(prezziCorrenti.getPrezzoIntero() + aumentoIntero, prezziCorrenti.getPrezzoRidotto() + aumentoRidotto);
    }

    /**
     * Aggiorna i prezzi dei biglietti applicando una diminuzione specificata.
     * @param diminuzioneIntero La diminuzione da applicare al prezzo del biglietto intero.
     * @param diminuzioneRidotto La diminuzione da applicare al prezzo del biglietto ridotto.
     */
    public void diminuisciPrezzi(double diminuzioneIntero, double diminuzioneRidotto) {
        prezziCorrenti = new PrezziBiglietto(prezziCorrenti.getPrezzoIntero() - diminuzioneIntero, prezziCorrenti.getPrezzoRidotto() - diminuzioneRidotto);
    }

    /**
     * Imposta i prezzi iniziali per i biglietti interi e ridotti.
     * @param prezzoIntero Il nuovo prezzo per il biglietto intero.
     * @param prezzoRidotto Il nuovo prezzo per il biglietto ridotto.
     */
    public void impostaPrezziIniziali(double prezzoIntero, double prezzoRidotto) {
        this.prezziCorrenti = new PrezziBiglietto(prezzoIntero, prezzoRidotto);
    }
}
