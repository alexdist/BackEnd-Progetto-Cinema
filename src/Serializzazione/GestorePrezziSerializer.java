package Serializzazione;

import ticket_pricing.GestorePrezzi;

import java.io.*;

public class GestorePrezziSerializer {

    public static void salvaStatoGestorePrezzi(GestorePrezzi gestorePrezzi, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(gestorePrezzi);
            System.out.println("Stato di GestorePrezzi salvato con successo in " + filePath);
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio dello stato di GestorePrezzi: " + e.getMessage());
        }
    }

    public static GestorePrezzi caricaStatoGestorePrezzi(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            System.out.println("Stato di GestorePrezzi caricato con successo da " + filePath);
            return (GestorePrezzi) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Errore durante il caricamento dello stato di GestorePrezzi: " + e.getMessage());
            return null;
        }
    }
}
