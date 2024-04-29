package Serializzazione.adapter.adaptee;

import cinema_Infrastructure.film.IFilm;

import java.io.*;
import java.util.List;

// FilmSerializer è l'Adaptee nel pattern Adapter.
// Contiene la logica di business specifica per la serializzazione e deserializzazione delle liste di film,
// ma la sua interfaccia non è compatibile con quella richiesta dal client.
public class FilmSerializer {

    // Serializza una lista di film in un file.
    // Questo metodo è specifico per la lista di film e non è compatibile direttamente con l'interfaccia IDataSerializer.
    public void serializeFilmList(List<IFilm> filmList, String filePath){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(filmList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserializza una lista di film da un file.
    // Come il metodo serializeFilmList, anche questo è specifico per le liste di film.
    public List<IFilm> deserializeFilmList(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<IFilm>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
