package Serializzazione.adapter.adaptee;

import ticket_pricing.PrezziBiglietto;

import java.io.*;

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
