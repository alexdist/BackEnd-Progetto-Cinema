package prova_id_PERSISTENTE;

//import Serializzazione.adapter.adapter.IdBigliettiSerializerAdapter;
import Serializzazione.adapter.adapter.IdSerializerAdapter;
import Serializzazione.adapter.target.IDataSerializer;

public class GeneratoreIDPersistenteBiglietti implements IGeneratoreIDPersistente {

    private long ultimoId;
    private static final String FILE_PATH = "ultimoIdBiglietti.txt";
    private IDataSerializer idSerializerAdapter;

    public GeneratoreIDPersistenteBiglietti() {
        // Inizializza l'adapter
        this.idSerializerAdapter = new IdSerializerAdapter();
        // Carica l'ultimo ID usato utilizzando l'adapter
        caricaUltimoIdUsato();
    }

    @Override
    public synchronized long generaProssimoId() {
        ultimoId++;
        // Salva l'ultimo ID usato utilizzando l'adapter
        salvaUltimoIdUsato();
        return ultimoId;
    }

    @Override
    public void salvaUltimoIdUsato() {
        // Delega al SerializerAdapter il compito di salvare l'ultimo ID
        idSerializerAdapter.serialize(ultimoId, FILE_PATH);
    }

    @Override
    public void caricaUltimoIdUsato() {
        // Delega al SerializerAdapter il compito di caricare l'ultimo ID
        Long idCaricato = (Long) idSerializerAdapter.deserialize(FILE_PATH);
        if (idCaricato != null) {
            ultimoId = idCaricato;
        } else {
            ultimoId = 0; // Gestisce il caso di fallimento o file non trovato
        }
    }
}
