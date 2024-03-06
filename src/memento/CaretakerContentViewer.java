package memento;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Stack;

//public class CaretakerContentViewer {
//
//    public static void main(String[] args) {
//        String filePathCaretaker = "caretaker.ser"; // Percorso del file da leggere
//
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePathCaretaker))) {
//            // Deserializza l'oggetto Caretaker dal file
//            Caretaker caretaker = (Caretaker) ois.readObject();
//
//            // Ottieni e stampa lo stack di mementi (acquisti) salvati
//            Stack<AcquistoMemento> mementos = caretaker.getMementos();
//            if (mementos.isEmpty()) {
//                System.out.println("Non ci sono acquisti salvati nel Caretaker.");
//            } else {
//                System.out.println("Acquisti salvati nel Caretaker:");
//                for (AcquistoMemento memento : mementos) {
//                    // Assumi che Acquisto implementi un metodo toString appropriato o esegui il cast se necessario
//                    System.out.println(memento);
//                }
//            }
//        } catch (Exception e) {
//            System.err.println("Errore durante la lettura del file " + filePathCaretaker + ": " + e.getMessage());
//        }
//    }
//}

//public class CaretakerContentViewer {
//
//    public static void main(String[] args) {
//        String filePathCaretaker = "caretaker.ser"; // Percorso del file da leggere
//
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePathCaretaker))) {
//            // Deserializza l'oggetto Caretaker dal file
//            Caretaker caretaker = (Caretaker) ois.readObject();
//
//            // Ottieni e stampa la lista di mementi (acquisti) salvati
//            List<AcquistoMemento> mementos = caretaker.getMementos();
//            if (mementos.isEmpty()) {
//                System.out.println("Non ci sono acquisti salvati nel Caretaker.");
//            } else {
//                System.out.println("Acquisti salvati nel Caretaker:");
//                for (AcquistoMemento memento : mementos) {
//                    // Assumi che Acquisto implementi un metodo toString appropriato o esegui il cast se necessario
//                    System.out.println(memento);
//                }
//            }
//        } catch (Exception e) {
//            System.err.println("Errore durante la lettura del file " + filePathCaretaker + ": " + e.getMessage());
//        }
//    }
//}
