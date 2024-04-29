package Serializzazione.adapter.adapter;

import Serializzazione.adapter.adaptee.FilmSerializer;
import Serializzazione.adapter.target.IDataSerializer;

import cinema_Infrastructure.film.IFilm;

import java.io.IOException;
import java.util.List;

// FilmSerializerAdapter è l'Adapter che implementa l'interfaccia Target IDataSerializer.
// Questa classe adatta l'interfaccia dell'Adaptee FilmSerializer a quella richiesta dal client.
public class FilmSerializerAdapter implements IDataSerializer {
    private FilmSerializer adaptee;// L'istanza dell'Adaptee che verrà utilizzata per delegare le richieste reali.

    public FilmSerializerAdapter() {
        this.adaptee = new FilmSerializer();
    }

    public FilmSerializerAdapter(FilmSerializer adaptee) {
        this.adaptee = adaptee;
    }

    // Implementa il metodo serialize dell'interfaccia Target convertendo il tipo di dati generico
    // nel tipo specifico atteso dall'Adaptee (List<IFilm>) prima di chiamare il metodo corrispondente.
    @Override
    public void serialize(Object data, String filePath){
        if (!(data instanceof List<?>)) {
            throw new IllegalArgumentException("Data type not supported for Film serialization.");
        }
        // Similmente, qui si assume che data sia del tipo corretto (List<IFilm>).
        adaptee.serializeFilmList((List<IFilm>) data, filePath);
    }

    // Implementa il metodo deserialize dell'interfaccia Target.
    // Delega la chiamata al metodo dell'Adaptee e ritorna il risultato appropriato.
    @Override
    public Object deserialize(String filePath) {
        return adaptee.deserializeFilmList(filePath);
    }
}
