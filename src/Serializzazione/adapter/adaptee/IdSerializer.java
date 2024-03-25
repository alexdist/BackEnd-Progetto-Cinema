package Serializzazione.adapter.adaptee;

import java.io.*;

public class IdSerializer {
    public void saveId(Long id, String filePath){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(id.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Long loadId(String filePath){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line != null) {
                return Long.parseLong(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0L; // Assume 0 as default if file is empty or not found
    }
}
