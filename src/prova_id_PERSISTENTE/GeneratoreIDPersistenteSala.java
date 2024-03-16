package prova_id_PERSISTENTE;

import Serializzazione.adapter.adapter.IdSalaSerializerAdapter;
import Serializzazione.adapter.target.IDataSerializer;

import java.io.*;

public class GeneratoreIDPersistenteSala implements IGeneratoreIDPersistente {

private long ultimoId;
    private static final String FILE_PATH = "ultimoIdSala.txt";
    private IDataSerializer idSalaSerializerAdapter;

    public GeneratoreIDPersistenteSala() {
        // Inizializza l'adapter
        this.idSalaSerializerAdapter = new IdSalaSerializerAdapter();
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
        idSalaSerializerAdapter.serialize(ultimoId, FILE_PATH);
    }

    public void caricaUltimoIdUsato() {
        // Delega al SerializerAdapter il compito di caricare l'ultimo ID
        Long idCaricato = (Long) idSalaSerializerAdapter.deserialize(FILE_PATH);
        if (idCaricato != null) {
            ultimoId = idCaricato;
        } else {
            ultimoId = 0; // Gestisce il caso di fallimento o file non trovato
        }
    }
}


