package Serializzazione.adapter.adapter;

import Serializzazione.adapter.adaptee.IdSalaSerializer;
import Serializzazione.adapter.target.IDataSerializer;

public class IdSalaSerializerAdapter implements IDataSerializer {
    private IdSalaSerializer adaptee;

    public IdSalaSerializerAdapter() {
        this.adaptee = new IdSalaSerializer();
    }

    public IdSalaSerializerAdapter(IdSalaSerializer adaptee) {
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