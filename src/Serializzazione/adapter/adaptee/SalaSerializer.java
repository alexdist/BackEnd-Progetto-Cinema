package Serializzazione.adapter.adaptee;

import cinema_Infrastructure.sala.ISala;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class SalaSerializer {

    // Rimossi i modificatori static dai metodi
    public void serializeSaleList(List<ISala> saleList, String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(saleList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ISala> deserializeSaleList(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<ISala>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
