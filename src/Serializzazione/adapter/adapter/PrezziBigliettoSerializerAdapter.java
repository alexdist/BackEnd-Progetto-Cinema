package Serializzazione.adapter.adapter;

import Serializzazione.adapter.adaptee.PrezziBigliettoSerializer;
import Serializzazione.adapter.target.IDataSerializer;

import ticket_pricing.PrezziBiglietto;

import java.io.IOException;

// PrezziBigliettoSerializerAdapter è l'Adapter che implementa l'interfaccia Target IDataSerializer.
// Questa classe adatta l'interfaccia dell'Adaptee PrezziBigliettoSerializer a quella richiesta dal client.
public class PrezziBigliettoSerializerAdapter implements IDataSerializer {
    private PrezziBigliettoSerializer adaptee;

    public PrezziBigliettoSerializerAdapter() {
        this.adaptee = new PrezziBigliettoSerializer();
    }

    public PrezziBigliettoSerializerAdapter(PrezziBigliettoSerializer adaptee) {
        this.adaptee = adaptee;
    }

    // Metodo override che implementa la serializzazione dell'interfaccia IDataSerializer.
    // Controlla se l'oggetto data è di tipo PrezziBiglietto, che è il tipo richiesto dall'Adaptee.
    @Override
    public void serialize(Object data, String filePath) {
        if (!(data instanceof PrezziBiglietto)) {
            // Se data non è del tipo atteso, viene lanciata un'eccezione per indicare l'errore al client.
            throw new IllegalArgumentException("Data type not supported for PrezziBiglietto serialization.");
        }
        // Se il tipo è corretto, delega la serializzazione a PrezziBigliettoSerializer.
        adaptee.serialize((PrezziBiglietto) data, filePath);
    }

    // Metodo override che implementa la deserializzazione dell'interfaccia IDataSerializer.
    // Delega il compito di deserializzazione a PrezziBigliettoSerializer e restituisce il risultato.
    @Override
    public Object deserialize(String filePath) {
        return adaptee.deserialize(filePath);
    }
}
