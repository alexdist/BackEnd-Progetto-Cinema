package Serializzazione.adapter.adapter;

import Serializzazione.adapter.adaptee.SalaSerializer;
import Serializzazione.adapter.target.IDataSerializer;

import cinema_Infrastructure.sala.ISala;

import java.io.IOException;
import java.util.List;

// SalaSerializerAdapter è l'Adapter che implementa l'interfaccia Target IDataSerializer.
// Questa classe adatta l'interfaccia dell'Adaptee SalaSerializer a quella richiesta dal client.
public class SalaSerializerAdapter implements IDataSerializer {
    private SalaSerializer adaptee;

    public SalaSerializerAdapter() {
        this.adaptee = new SalaSerializer();
    }

    public SalaSerializerAdapter(SalaSerializer adaptee) {
        this.adaptee = adaptee;
    }

    // si assicura che l'oggetto sia un'istanza di AbstractRegistroBiglietti prima di procedere.
    @Override
    public void serialize(Object data, String filePath){
        if (!(data instanceof List<?>)) {
            // Solleva un'eccezione se l'oggetto data non è del tipo atteso dall'Adaptee.
            throw new IllegalArgumentException("Data type not supported for Sala serialization.");
        }
        // Se il controllo del tipo ha esito positivo, delega la serializzazione all'Adaptee.
        adaptee.serializeSaleList((List<ISala>) data, filePath);
    }

    // Implementa il metodo deserialize dell'interfaccia IDataSerializer.
    // Delega semplicemente il compito di deserializzazione all'Adaptee.
    // Non è necessario alcun controllo del tipo in questo caso poiché si presume che il file
    // sia del tipo corretto.
    @Override
    public Object deserialize(String filePath) {
        return adaptee.deserializeSaleList(filePath);
    }
}
