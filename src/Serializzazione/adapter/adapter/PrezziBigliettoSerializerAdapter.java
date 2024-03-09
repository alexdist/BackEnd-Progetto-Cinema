package Serializzazione.adapter.adapter;

import Serializzazione.adapter.adaptee.PrezziBigliettoSerializer;
import Serializzazione.adapter.target.IDataSerializer;

import ticket_pricing.PrezziBiglietto;

public class PrezziBigliettoSerializerAdapter implements IDataSerializer {
    private PrezziBigliettoSerializer adaptee;

    public PrezziBigliettoSerializerAdapter() {
        this.adaptee = new PrezziBigliettoSerializer();
    }

    public PrezziBigliettoSerializerAdapter(PrezziBigliettoSerializer adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void serialize(Object data, String filePath) {
        if (!(data instanceof PrezziBiglietto)) {
            throw new IllegalArgumentException("Data type not supported for PrezziBiglietto serialization.");
        }
        adaptee.serialize((PrezziBiglietto) data, filePath);
    }

    @Override
    public Object deserialize(String filePath) {
        return adaptee.deserialize(filePath);
    }
}
