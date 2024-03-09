package Serializzazione.adapter.adaptee;

import cinema_Infrastructure.film.IFilm;

import java.io.*;
import java.util.List;

public class FilmSerializer {

    // Rimossi i modificatori static dai metodi
    public void serializeFilmList(List<IFilm> filmList, String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(filmList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<IFilm> deserializeFilmList(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<IFilm>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
