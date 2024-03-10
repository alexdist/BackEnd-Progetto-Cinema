package Serializzazione.adapter.adaptee;

import ticket.factory.product.IBiglietto;

import java.io.*;
import java.util.List;

public class BigliettiSerializer {
    public void serializeBigliettiList(List<IBiglietto> biglietti, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(biglietti);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<IBiglietto> deserializeBigliettiList(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<IBiglietto>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
