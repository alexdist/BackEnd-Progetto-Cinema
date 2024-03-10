//package admin_commands.spettacolo.aggiungi_spettacolo;
//
//import admin_commands.spettacolo.aggiungi_spettacolo.AggiungiSpettacoloCommand;
//import admin_interfaces.ICommand;
//import cinema_Infrastructure.film.*;
//import cinema_Infrastructure.sala.*;
//import cinema_Infrastructure.spettacolo.*;
//import cinema_Infrastructure.spettacolo.gestione_spettacolo.AggiungiSpettacolo;
//import cinema_Infrastructure.spettacolo.gestione_spettacolo.IAggiungiSpettacolo;
//import domain.Amministratore;
//import domain.Ruolo;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//
//public class TestAggiungiSpettacolo {
//
//    public static void main(String[] args) {
//        // Setup iniziale: Creazione di un film, una sala, e configurazione del sistema di aggiunta spettacoli
//        IFilm film = new Film("Il Ritorno del Jedi", 120, "Fantascienza");
//        ISala sala = new Sala(1, 150);
//        ArrayList<ISpettacolo> spettacoli = new ArrayList<>();
//        IGeneratoreIDSpettacolo generatoreIDSpettacolo = GeneratoreIDSpettacolo.getInstance();
//
//        IAggiungiSpettacolo aggiungiSpettacolo = new AggiungiSpettacolo(spettacoli, generatoreIDSpettacolo);
//
//        // Creazione dello spettacolo
//        ISpettacolo spettacolo = new Spettacolo(film, sala, LocalDateTime.of(2024, 3, 15, 20, 30));
//
//        // Creazione del comando per aggiungere uno spettacolo e dell'amministratore che lo eseguirà
//        ICommand aggiungiSpettacoloCommand = new AggiungiSpettacoloCommand(aggiungiSpettacolo, spettacolo);
//        Amministratore amministratore = new Amministratore("Mario", "Rossi", Ruolo.AMMINISTRATORE);
//
//        amministratore.setCommand(aggiungiSpettacoloCommand);
//
//        try {
//            // Esecuzione del comando tramite l'amministratore
//            amministratore.eseguiComando();
//            System.out.println("Spettacolo aggiunto con successo.");
//
//            // Stampa dei dettagli dello spettacolo aggiunto
//            System.out.println("Dettagli dello spettacolo aggiunto:");
//            System.out.println("Film: " + spettacolo.getFilm().getTitolo() + " - Genere: " + spettacolo.getFilm().getGenere());
//            System.out.println("Sala: " + spettacolo.getSala().getNumeroSala() + " - Posti: " + spettacolo.getSala().getCapacita());
//            System.out.println("Orario: " + spettacolo.getOrarioProiezione());
//        } catch (Exception e) {
//            System.err.println("Errore durante l'aggiunta dello spettacolo: " + e.getMessage());
//        }
//    }
//}