package Serializzazione.adapter.adaptee;

import revenues_observer.observable.AbstractRegistroBiglietti;

import java.io.*;

public class RegistroBigliettiSerializer {

    public void serializeRegistroBiglietti(AbstractRegistroBiglietti registro, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(registro);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AbstractRegistroBiglietti deserializeRegistroBiglietti(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (AbstractRegistroBiglietti) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}