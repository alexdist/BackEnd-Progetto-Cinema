package Serializzazione.adapter.adapter;

import Serializzazione.adapter.adaptee.SpettacoloSerializer;
import Serializzazione.adapter.target.IDataSerializer;
import cinema_Infrastructure.spettacolo.ISpettacolo;

import java.io.IOException;
import java.util.List;

// SpettacoloSerializerAdapter è l'Adapter che implementa l'interfaccia Target IDataSerializer.
// Questa classe adatta l'interfaccia dell'Adaptee SpettacoloSerializer a quella richiesta dal client.
public class SpettacoloSerializerAdapter implements IDataSerializer {
    private SpettacoloSerializer adaptee;

    public SpettacoloSerializerAdapter() {
        this.adaptee = new SpettacoloSerializer();
    }

    public SpettacoloSerializerAdapter(SpettacoloSerializer adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void serialize(Object data, String filePath) {
        adaptee.serializeSpettacoloList((List<ISpettacolo>) data, filePath);
    }

    @Override
    public Object deserialize(String filePath) {
        return adaptee.deserializeSpettacoloList(filePath);
    }
}
