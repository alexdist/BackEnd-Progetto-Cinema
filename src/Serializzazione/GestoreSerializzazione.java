package Serializzazione;
import java.io.*;
public class GestoreSerializzazione {

    public static void salvaOggettoSuFile(Object oggetto, String nomeFile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            oos.writeObject(oggetto);
            System.out.println("Oggetto salvato su file: " + nomeFile);
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio dell'oggetto: " + e.getMessage());
        }
    }

    public static Object caricaOggettoDaFile(String nomeFile) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFile))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Errore durante il caricamento dell'oggetto: " + e.getMessage());
            return null;
        }
    }
}
