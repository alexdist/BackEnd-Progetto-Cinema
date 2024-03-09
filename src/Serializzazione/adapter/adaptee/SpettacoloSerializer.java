package Serializzazione.adapter.adaptee;

import cinema_Infrastructure.spettacolo.ISpettacolo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

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
