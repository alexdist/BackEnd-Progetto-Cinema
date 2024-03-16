package prova_id_PERSISTENTE;

import Serializzazione.adapter.adapter.IdSpettacoloSerializerAdapter;
import Serializzazione.adapter.target.IDataSerializer;

public class GeneratoreIDPersistenteSpettacolo implements IGeneratoreIDPersistente {

    private long ultimoId;
    private static final String FILE_PATH = "ultimoIdSpettacolo.txt";
    private IDataSerializer idSpettacoloSerializerAdapter;

    public GeneratoreIDPersistenteSpettacolo() {
        // Inizializza l'adapter
        this.idSpettacoloSerializerAdapter = new IdSpettacoloSerializerAdapter();
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

    public void salvaUltimoIdUsato() {
        // Delega al SerializerAdapter il compito di salvare l'ultimo ID
        idSpettacoloSerializerAdapter.serialize(ultimoId, FILE_PATH);
    }

    public void caricaUltimoIdUsato() {
        // Delega al SerializerAdapter il compito di caricare l'ultimo ID
        Long idCaricato = (Long) idSpettacoloSerializerAdapter.deserialize(FILE_PATH);
        if (idCaricato != null) {
            ultimoId = idCaricato;
        } else {
            ultimoId = 0; // Gestisce il caso di fallimento o file non trovato
        }
    }
}