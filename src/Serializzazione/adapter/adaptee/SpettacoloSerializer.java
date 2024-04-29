package Serializzazione.adapter.adaptee;

import cinema_Infrastructure.spettacolo.ISpettacolo;

import java.io.*;
import java.util.List;

// SpettacoloSerializer è l'Adaptee nel pattern Adapter.
// Contiene la logica di business specifica per la serializzazione e deserializzazione delle liste di Spettacoli,
// ma la sua interfaccia non è compatibile con quella richiesta dal client.
public class SpettacoloSerializer {

    public void serializeSpettacoloList(List<ISpettacolo> spettacoloList, String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(spettacoloList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ISpettacolo> deserializeSpettacoloList(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<ISpettacolo>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
