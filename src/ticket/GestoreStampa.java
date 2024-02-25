package ticket;

public class GestoreStampa {

    public static void stampaDettagliBiglietto(Biglietto biglietto) {


        System.out.println("------ Dettagli Biglietto ------");
        if (!biglietto.isValid()) {
            System.out.println("Attenzione: Questo biglietto è stato invalidato. I seguenti dettagli potrebbero non essere più attuali.");
        }
        System.out.println("Logo Cinema: " + biglietto.getLogoCinema());
        System.out.println("Film: " + biglietto.getSpettacolo().getFilm().getTitolo());
        System.out.println("Sala: " + biglietto.getSpettacolo().getSala().getNumeroSala());
        System.out.println("Orario: " + biglietto.getSpettacolo().getOrarioProiezione());
        // Gestisce il caso in cui l'acquirente è null a seguito dell'invalidazione del biglietto
        String nomeAcquirente = (biglietto.getAcquirente() != null) ? biglietto.getAcquirente().getNome() + " " + biglietto.getAcquirente().getCognome() : "Non disponibile";
        System.out.println("Nome Acquirente: " + nomeAcquirente);
        System.out.println("Costo: " + biglietto.getCosto() + "€");
        System.out.println("Tipo Biglietto: " + (biglietto.getColore().equalsIgnoreCase("Blu") ? "Intero" : "Ridotto"));
        System.out.println("Colore Biglietto: " + biglietto.getColore());
        System.out.println("--------------------------------");
    }
}
