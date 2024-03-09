package Serializzazione.adapter.adapter;

import Serializzazione.adapter.adaptee.SalaSerializer;
import Serializzazione.adapter.target.IDataSerializer;

import cinema_Infrastructure.sala.ISala;

import java.util.List;

public class SalaSerializerAdapter implements IDataSerializer {
    private SalaSerializer adaptee;

    public SalaSerializerAdapter() {
        this.adaptee = new SalaSerializer();
    }

    public SalaSerializerAdapter(SalaSerializer adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void serialize(Object data, String filePath) {
        if (!(data instanceof List<?>)) {
            throw new IllegalArgumentException("Data type not supported for Sala serialization.");
        }
        // Il controllo del tipo specifico di List non è possibile a runtime a causa dell'erase del tipo generico,
        // ma si assume che sia una List<ISala>.
        adaptee.serializeSaleList((List<ISala>) data, filePath);
    }

    @Override
    public Object deserialize(String filePath) {
        return adaptee.deserializeSaleList(filePath);
    }
}
