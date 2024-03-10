package id_generator_factory.concrete_product;


import id_generator_factory.product.IGeneratoreID;

public class GeneratoreIDFilm implements IGeneratoreID {
    private static GeneratoreIDFilm istanza; // Modificato per usare il tipo corretto
    private long ultimoIdAssegnato;

    private GeneratoreIDFilm() {
        this.ultimoIdAssegnato = -1; // Inizia da -1 così il primo ID sarà 0.
    }

    // Metodo statico per ottenere l'istanza Singleton
    public static synchronized GeneratoreIDFilm getInstance() {
        if (istanza == null) {
            istanza = new GeneratoreIDFilm();
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
