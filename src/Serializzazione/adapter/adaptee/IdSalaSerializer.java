package Serializzazione.adapter.adaptee;

import java.io.*;

public class IdSalaSerializer {

    public void saveLastUsedId(Long ultimoId, String filePath) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath))) {
            out.println(ultimoId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Long loadLastUsedId(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line != null) {
                return Long.parseLong(line);
            } else {
                return 0L; // Se il file è vuoto, iniziamo da 0
            }
        } catch (FileNotFoundException e) {
            return 0L; // Se il file non esiste, iniziamo da 0
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
