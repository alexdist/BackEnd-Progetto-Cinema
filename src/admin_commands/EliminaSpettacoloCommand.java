//package admin_commands;
//
//import admin_interfaces.Command;
//import cinema_Infrastructure.spettacolo.Spettacolo;
//import singleton.Cinema;
//import singleton.GestioneCinema;
//
//public class EliminaSpettacoloCommand implements Command {
//    private String idSpettacolo; // ID dello spettacolo da eliminare
//
//    // Costruttore che accetta l'ID dello spettacolo da eliminare
//    public EliminaSpettacoloCommand(String idSpettacolo) {
//        this.idSpettacolo = idSpettacolo;
//    }
//
//    @Override
//    public void execute() {
//        try {
//            // Ottiene l'istanza del sistema di gestione del cinema
//            GestioneCinema gestioneCinema = Cinema.getInstance().getGestioneCinema();
//            // Cerca lo spettacolo usando l'ID fornito
//            Spettacolo spettacoloDaEliminare = gestioneCinema.trovaSpettacolo(idSpettacolo);
//
//            if (spettacoloDaEliminare != null) {
//                // Rimuove lo spettacolo dalla programmazione
//                gestioneCinema.getProgrammazione().remove(spettacoloDaEliminare);
//                System.out.println("Spettacolo con ID \"" + idSpettacolo + "\" eliminato con successo.");
//            } else {
//                System.err.println("Spettacolo con ID \"" + idSpettacolo + "\" non trovato.");
//            }
//        } catch (Exception e) {
//            System.err.println("Errore durante l'eliminazione dello spettacolo: " + e.getMessage());
//        }
//    }
//}
