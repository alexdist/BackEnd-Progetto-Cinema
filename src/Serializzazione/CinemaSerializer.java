//package Serializzazione;
//import singleton.GestioneCinema;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.IOException;
//
//public class CinemaSerializer {
//
//    public static void salvaStatoGestioneCinema(GestioneCinema gestioneCinema, String filePath) {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
//            oos.writeObject(gestioneCinema);
//            System.out.println("Stato di GestioneCinema salvato con successo.");
//        } catch (IOException e) {
//            System.err.println("Errore durante il salvataggio dello stato di GestioneCinema: " + e.getMessage());
//        }
//    }
//
//    public static GestioneCinema caricaStatoGestioneCinema(String filePath) {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
//            System.out.println("Stato di GestioneCinema caricato con successo.");
//            return (GestioneCinema) ois.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            System.err.println("Errore durante il caricamento dello stato di GestioneCinema: " + e.getMessage());
//            return null;
//        }
//    }
//}
