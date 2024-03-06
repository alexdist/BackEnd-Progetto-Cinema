//package Serializzazione;
//
//import ticket.Biglietto;
//import ticket_pricing.GestoreRicavi;
//
//import java.io.*;
//import java.util.List;
//import java.util.Map;
//
//public class GestoreRicaviSerializer {
//
//    public static void salvaStatoGestoreRicavi(GestoreRicavi gestoreRicavi, String filePath) {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath,false))) {
//            oos.writeObject(gestoreRicavi);
//            System.out.println("Stato di GestoreRicavi salvato con successo.");
//        } catch (IOException e) {
//            System.err.println("Errore durante il salvataggio dello stato di GestoreRicavi: " + e.getMessage());
//        }
//    }
//
//    public static GestoreRicavi caricaStatoGestoreRicavi(String filePath) {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
//            System.out.println("Stato di GestoreRicavi caricato con successo.");
//            return (GestoreRicavi) ois.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            System.err.println("Errore durante il caricamento dello stato di GestoreRicavi: " + e.getMessage());
//            return null;
//        }
//    }
//
//}