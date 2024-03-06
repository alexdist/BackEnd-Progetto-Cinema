//package Serializzazione;
//
//import ticket_pricing.GestoreRicavi;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//
//public class TestGestoreRicavi {
//
//    public static void main(String[] args) {
//        // Percorso del file da cui deserializzare l'oggetto GestoreRicavi
//        String filePath = "gestoreRicavi.ser";
//
//        // Tentativo di deserializzare l'oggetto GestoreRicavi dal file
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
//            // Legge l'oggetto dal file
//            GestoreRicavi gestoreRicavi = (GestoreRicavi) ois.readObject();
//
//            // Stampa le informazioni relative al GestoreRicavi
//            System.out.println("Contenuto di gestoreRicavi.ser:");
//            System.out.println(gestoreRicavi);
//
//
//
//
//
//        } catch (IOException | ClassNotFoundException e) {
//            System.err.println("Errore durante la deserializzazione di gestoreRicavi.ser: " + e.getMessage());
//        }
//    }
//}
