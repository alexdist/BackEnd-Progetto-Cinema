package ID_persistente;

//import Serializzazione.adapter.adapter.IdSpettacoloSerializerAdapter;
import Serializzazione.adapter.adapter.IdSerializerAdapter;
import Serializzazione.adapter.target.IDataSerializer;

public class GeneratoreIDPersistenteSpettacolo implements IGeneratoreIDPersistente {

    // Variabile privata per tenere traccia dell'ultimo ID usato
    private long ultimoId;
    private static final String FILE_PATH = "ultimoIdSpettacolo.txt";

    // Adapter per la serializzazione dell'ID
    private IDataSerializer idSerializerAdapter;

    public GeneratoreIDPersistenteSpettacolo(){
        // Inizializza l'adapter per la serializzazione/deserializzazione degli ID
        this.idSerializerAdapter = new IdSerializerAdapter();
        // Carica l'ultimo ID usato da File utilizzando l'adapter
        caricaUltimoIdUsato();
    }

    @Override
    public synchronized long generaProssimoId() {
        ultimoId++;
        // Salva l'ultimo ID usato utilizzando l'adapter
        salvaUltimoIdUsato();
        return ultimoId;
    }

    public void salvaUltimoIdUsato(){
        // Delega al SerializerAdapter il compito di salvare l'ultimo ID
        idSerializerAdapter.serialize(ultimoId, FILE_PATH);
    }

    public void caricaUltimoIdUsato(){
        // Delega al SerializerAdapter il compito di caricare l'ultimo ID
        Long idCaricato = (Long) idSerializerAdapter.deserialize(FILE_PATH);
        if (idCaricato != null) {
            ultimoId = idCaricato;
        } else {
            ultimoId = 0; // Gestisce il caso di fallimento o file non trovato
        }
    }
}