package Serializzazione.adapter.adapter;

import Serializzazione.adapter.adaptee.IdSpettacoloSerializer;
import Serializzazione.adapter.target.IDataSerializer;

public class IdSpettacoloSerializerAdapter implements IDataSerializer {
    private IdSpettacoloSerializer adaptee;

    public IdSpettacoloSerializerAdapter() {
        this.adaptee = new IdSpettacoloSerializer();
    }

    public IdSpettacoloSerializerAdapter(IdSpettacoloSerializer adaptee) {
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
