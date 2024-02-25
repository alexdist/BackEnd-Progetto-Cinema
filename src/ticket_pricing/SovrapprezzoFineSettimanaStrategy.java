package ticket_pricing;

import cinema_Infrastructure.Spettacolo;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class SovrapprezzoFineSettimanaStrategy extends AbstractPrezzoStrategy {

    private double sovrapprezzo;

    public SovrapprezzoFineSettimanaStrategy(double sovrapprezzo) {
        this.sovrapprezzo = sovrapprezzo;
    }

    @Override
    public double calcolaPrezzo(Spettacolo spettacolo, String tipoBiglietto, PrezziBiglietto prezziCorrenti) {
        LocalDateTime orarioProiezione = spettacolo.getOrarioProiezione();
        boolean isWeekend = orarioProiezione.getDayOfWeek() == DayOfWeek.SATURDAY || orarioProiezione.getDayOfWeek() == DayOfWeek.SUNDAY;
        double prezzoBase = tipoBiglietto.equalsIgnoreCase("intero") ? prezziCorrenti.getPrezzoIntero() : prezziCorrenti.getPrezzoRidotto();

        return isWeekend ? prezzoBase + (prezzoBase * sovrapprezzo / 100) : prezzoBase;
    }

    // Metodo per ottenere il prezzo base in base al tipo di biglietto
    private double getPrezzoBase(String tipoBiglietto) {
        if (tipoBiglietto.equalsIgnoreCase("intero")) {
            return prezzi.getPrezzoIntero();
        } else if (tipoBiglietto.equalsIgnoreCase("ridotto")) {
            return prezzi.getPrezzoRidotto();
        } else {
            throw new IllegalArgumentException("Tipo di biglietto non supportato: " + tipoBiglietto);
        }
    }
}
