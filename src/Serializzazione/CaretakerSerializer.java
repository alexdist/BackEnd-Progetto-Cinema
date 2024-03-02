package Serializzazione;

import memento.Caretaker;

import java.io.*;

public class CaretakerSerializer {

    public static void salvaStatoCaretaker(Caretaker caretaker, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(caretaker);
            System.out.println("Stato del Caretaker salvato con successo.");
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio dello stato del Caretaker: " + e.getMessage());
        }
    }

    public static Caretaker caricaStatoCaretaker(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            System.out.println("Stato del Caretaker caricato con successo.");
            return (Caretaker) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Errore durante il caricamento dello stato del Caretaker: " + e.getMessage());
            return null;
        }
    }
}
