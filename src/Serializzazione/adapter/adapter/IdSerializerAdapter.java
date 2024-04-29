package Serializzazione.adapter.adapter;

import Serializzazione.adapter.adaptee.IdSerializer;
import Serializzazione.adapter.target.IDataSerializer;

import java.io.IOException;

// IdSerializerAdapter è l'Adapter che implementa l'interfaccia Target IDataSerializer.
// Questa classe adatta l'interfaccia dell'Adaptee idSerializer a quella richiesta dal client.
public class IdSerializerAdapter implements IDataSerializer {
    private IdSerializer adaptee;// L'istanza dell'Adaptee che verrà utilizzata per le operazioni di serializzazione.

    public IdSerializerAdapter() {
        this.adaptee = new IdSerializer();
    }

    public IdSerializerAdapter(IdSerializer idSerializer) {
        this.adaptee = idSerializer;
    }

    // Metodo di serializzazione dell'interfaccia IDataSerializer.
    // Esegue un controllo di tipo per assicurarsi che i dati siano di tipo Long,
    // poiché questo è il tipo di dato che IdSerializer è in grado di gestire.
    @Override
    public void serialize(Object data, String filePath) {
        if (!(data instanceof Long)) {
            // Solleva un'eccezione se il tipo di dato non è compatibile con l'Adaptee.
            throw new IllegalArgumentException("Data type not supported for ID serialization.");
        }
        // Delega il compito di salvataggio dell'ID a IdSerializer una volta confermato che il tipo è corretto.
        adaptee.saveId((Long) data, filePath);
    }

    // Metodo di deserializzazione dell'interfaccia IDataSerializer.
    // Delega semplicemente la chiamata al metodo loadId di IdSerializer.
    // Non è necessario alcun controllo del tipo qui perché i file contenenti ID sono presumibilmente ben formati.
    @Override
    public Object deserialize(String filePath) {
        return adaptee.loadId(filePath);
    }
}