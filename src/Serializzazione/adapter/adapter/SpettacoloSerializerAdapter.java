package Serializzazione.adapter.adapter;

import Serializzazione.adapter.adaptee.SpettacoloSerializer;
import Serializzazione.adapter.target.IDataSerializer;
import cinema_Infrastructure.spettacolo.ISpettacolo;

import java.util.List;

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