package prova_id_PERSISTENTE;

import java.io.*;

public class GeneratoreIDPersistente implements IGeneratoreIDPersistente {
    private long ultimoId;
    private static final String FILE_PATH = "ultimoId.txt";

    public GeneratoreIDPersistente() {
        caricaUltimoIdUsato();
    }

    @Override
    public synchronized long generaProssimoId() {
        ultimoId++;
        salvaUltimoIdUsato();
        return ultimoId;
    }

    @Override
    public void salvaUltimoIdUsato() {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_PATH))) {
            out.println(ultimoId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void caricaUltimoIdUsato() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = reader.readLine();
            if (line != null) {
                ultimoId = Long.parseLong(line);
            } else {
                ultimoId = 0; // Se il file è vuoto, iniziamo da 0
            }
        } catch (FileNotFoundException e) {
            ultimoId = 0; // Se il file non esiste, iniziamo da 0
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
