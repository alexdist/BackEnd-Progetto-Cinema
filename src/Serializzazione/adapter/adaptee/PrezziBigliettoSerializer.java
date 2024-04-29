package Serializzazione.adapter.adaptee;

import ticket_pricing.PrezziBiglietto;

import java.io.*;

// PrezziBigliettoSerializer è l'Adaptee nel pattern Adapter.
// Contiene la logica di business specifica per la serializzazione e deserializzazione dei Prezzi Biglietto,
// ma la sua interfaccia non è compatibile con quella richiesta dal client.
public class PrezziBigliettoSerializer {

    public void serialize(PrezziBiglietto prezziBiglietto, String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(prezziBiglietto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PrezziBiglietto deserialize(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (PrezziBiglietto) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
