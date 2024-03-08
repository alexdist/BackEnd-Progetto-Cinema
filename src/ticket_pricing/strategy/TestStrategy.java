package ticket_pricing.strategy;

import ticket_pricing.PrezziBiglietto;

public class TestStrategy {

    public static void main(String[] args) {
        // Creazione di un'istanza di PrezziBiglietto con prezzi iniziali
        PrezziBiglietto prezziBiglietto = new PrezziBiglietto(10.0, 7.5);

        // Stampa dei prezzi iniziali
        System.out.println("Prezzo intero iniziale: " + prezziBiglietto.getPrezzoIntero());
        System.out.println("Prezzo ridotto iniziale: " + prezziBiglietto.getPrezzoRidotto());

        // Applicazione della strategia di prezzo base
        Context context = new Context(new PrezzoBaseStrategy(prezziBiglietto));
        context.executeStrategy();

        // Stampa dei prezzi dopo l'applicazione della strategia di prezzo base
        System.out.println("Prezzo intero dopo strategia base: " + prezziBiglietto.getPrezzoIntero());
        System.out.println("Prezzo ridotto dopo strategia base: " + prezziBiglietto.getPrezzoRidotto());

        // Cambio della strategia per applicare un aumento per il weekend
        context.setStrategy(new PrezzoWeekEndStrategy(prezziBiglietto, 0.20)); // 20% di aumento
        context.executeStrategy();

        // Stampa dei prezzi dopo l'applicazione della strategia per il weekend
        System.out.println("Prezzo intero dopo strategia weekend: " + prezziBiglietto.getPrezzoIntero());
        System.out.println("Prezzo ridotto dopo strategia weekend: " + prezziBiglietto.getPrezzoRidotto());
    }
}
