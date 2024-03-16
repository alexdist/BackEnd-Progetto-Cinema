package Serializzazione.adapter.adapter;

import Serializzazione.adapter.adaptee.IdFilmSerializer;
import Serializzazione.adapter.target.IDataSerializer;

public class IdFilmSerializerAdapter implements IDataSerializer {
    private IdFilmSerializer adaptee;

    public IdFilmSerializerAdapter() {
        this.adaptee = new IdFilmSerializer();
    }

    public IdFilmSerializerAdapter(IdFilmSerializer adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void serialize(Object data, String filePath) {
        if (!(data instanceof Long)) {
            throw new IllegalArgumentException("Data type not supported for ID serialization.");
        }
        adaptee.saveLastUsedId((Long) data, filePath);
    }

    @Override
    public Object deserialize(String filePath) {
        return adaptee.loadLastUsedId(filePath);
    }
}