package id_generator_factory.concrete_product;

import Serializzazione.adapter.adaptee.SalaSerializer;
import Serializzazione.adapter.adapter.SalaSerializerAdapter;
import Serializzazione.adapter.target.IDataSerializer;
import cinema_Infrastructure.sala.ISala;
import id_generator_factory.product.IGeneratoreID;

import java.util.List;
public class GeneratoreIDSala implements IGeneratoreID {
    private static GeneratoreIDSala istanza; // Modificato per usare il tipo corretto
    private long ultimoIdAssegnato;

    private GeneratoreIDSala() {
        this.ultimoIdAssegnato = -1; // Inizia da -1 così il primo ID sarà 0.
    }

    // Metodo statico per ottenere l'istanza Singleton
    public static synchronized GeneratoreIDSala getInstance() {
        if (istanza == null) {
            istanza = new GeneratoreIDSala();
        }
        return istanza;
    }

    @Override // Implementazione dell'interfaccia
    public synchronized long generaProssimoId() {
        return ++ultimoIdAssegnato; // Incrementa l'ID e lo restituisce.
    }

    // Metodo per resettare l'ID (opzionale, a seconda delle necessità)
    public synchronized void reset() {
        ultimoIdAssegnato = -1;
    }

}
