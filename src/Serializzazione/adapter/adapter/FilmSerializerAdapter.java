package Serializzazione.adapter.adapter;

import Serializzazione.adapter.adaptee.FilmSerializer;
import Serializzazione.adapter.target.IDataSerializer;

import cinema_Infrastructure.film.IFilm;

import java.io.IOException;
import java.util.List;

public class FilmSerializerAdapter implements IDataSerializer {
    private FilmSerializer adaptee;

    public FilmSerializerAdapter() {
        this.adaptee = new FilmSerializer();
    }

    public FilmSerializerAdapter(FilmSerializer adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void serialize(Object data, String filePath){
        if (!(data instanceof List<?>)) {
            throw new IllegalArgumentException("Data type not supported for Film serialization.");
        }
        // Similmente, qui si assume che data sia del tipo corretto (List<IFilm>).
        adaptee.serializeFilmList((List<IFilm>) data, filePath);
    }

    @Override
    public Object deserialize(String filePath) {
        return adaptee.deserializeFilmList(filePath);
    }
}
