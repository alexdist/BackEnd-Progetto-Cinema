package Serializzazione.adapter.adapter;

import Serializzazione.adapter.adaptee.IdSerializer;
import Serializzazione.adapter.target.IDataSerializer;

import java.io.IOException;

public class IdSerializerAdapter implements IDataSerializer {
    private IdSerializer adaptee;

    public IdSerializerAdapter() {
        this.adaptee = new IdSerializer();
    }

    public IdSerializerAdapter(IdSerializer idSerializer) {
        this.adaptee = idSerializer;
    }

    @Override
    public void serialize(Object data, String filePath) {
        if (!(data instanceof Long)) {
            throw new IllegalArgumentException("Data type not supported for ID serialization.");
        }
        adaptee.saveId((Long) data, filePath);
    }

    @Override
    public Object deserialize(String filePath) {
        return adaptee.loadId(filePath);
    }
}