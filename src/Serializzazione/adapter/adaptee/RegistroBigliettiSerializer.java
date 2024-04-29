package Serializzazione.adapter.adaptee;

import revenues_observer.observable.AbstractRegistroBiglietti;

import java.io.*;

// RegistroBigliettiSerializer è l'Adaptee nel pattern Adapter.
// Contiene la logica di business specifica per la serializzazione e deserializzazione delle liste di film,
// ma la sua interfaccia non è compatibile con quella richiesta dal client.
public class RegistroBigliettiSerializer {

    public void serializeRegistroBiglietti(AbstractRegistroBiglietti registro, String filePath){
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