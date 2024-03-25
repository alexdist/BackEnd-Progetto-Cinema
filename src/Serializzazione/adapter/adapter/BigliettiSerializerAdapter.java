package Serializzazione.adapter.adapter;

import Serializzazione.adapter.adaptee.BigliettiSerializer;
import Serializzazione.adapter.target.IDataSerializer;
import ticket.factory.product.IBiglietto;

import java.io.IOException;
import java.util.List;

public class BigliettiSerializerAdapter implements IDataSerializer {
    private BigliettiSerializer adaptee;

    public BigliettiSerializerAdapter(BigliettiSerializer adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void serialize(Object data, String filePath){
        if (!(data instanceof List<?>)) {
            throw new IllegalArgumentException("Data type not supported for serialization.");
        }
        adaptee.serializeBigliettiList((List<IBiglietto>) data, filePath);
    }

    @Override
    public Object deserialize(String filePath){
        return adaptee.deserializeBigliettiList(filePath);
    }
}
