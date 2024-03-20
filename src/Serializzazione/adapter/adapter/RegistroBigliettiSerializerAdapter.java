package Serializzazione.adapter.adapter;

import Serializzazione.adapter.adaptee.RegistroBigliettiSerializer;
import Serializzazione.adapter.target.IDataSerializer;
import revenues_observer.observable.AbstractRegistroBiglietti;

public class RegistroBigliettiSerializerAdapter implements IDataSerializer {
    private RegistroBigliettiSerializer adaptee;

    public RegistroBigliettiSerializerAdapter(RegistroBigliettiSerializer adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void serialize(Object data, String filePath) {
        if (!(data instanceof AbstractRegistroBiglietti)) {
            throw new IllegalArgumentException("Data type not supported for serialization.");
        }
        adaptee.serializeRegistroBiglietti((AbstractRegistroBiglietti) data, filePath);
    }

    @Override
    public Object deserialize(String filePath) {
        return adaptee.deserializeRegistroBiglietti(filePath);
    }
}