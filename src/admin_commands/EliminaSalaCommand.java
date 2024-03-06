//package admin_commands;
//
//import admin_interfaces.Command;
//import singleton.Cinema;
//import singleton.GestioneCinema;
//
//public class EliminaSalaCommand implements Command {
//    private int numeroSala; // Numero identificativo della sala da eliminare
//
//    // Costruttore che accetta il numero della sala da eliminare
//    public EliminaSalaCommand(int numeroSala) {
//        this.numeroSala = numeroSala;
//    }
//
//    @Override
//    public void execute() {
//        try {
//            GestioneCinema gestioneCinema = Cinema.getInstance().getGestioneCinema();
//            // Verifica se la sala esiste
//            if (gestioneCinema.getSale().containsKey(numeroSala)) {
//                // Rimuove la sala dalla mappa delle sale
//                gestioneCinema.getSale().remove(numeroSala);
//                System.out.println("Sala numero " + numeroSala + " eliminata con successo.");
//            } else {
//                System.err.println("Sala numero " + numeroSala + " non trovata.");
//            }
//        } catch (Exception e) {
//            System.err.println("Errore durante l'eliminazione della sala: " + e.getMessage());
//        }
//    }
//}
