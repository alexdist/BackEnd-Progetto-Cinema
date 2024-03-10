package id_generator_factory.concrete_product;

import id_generator_factory.product.IGeneratoreID;

public class GeneratoreIDBiglietto implements IGeneratoreID {
    private static GeneratoreIDBiglietto istanza;
    private long ultimoIdAssegnato = -1;

    private GeneratoreIDBiglietto() { }

    public static synchronized GeneratoreIDBiglietto getInstance() {
        if (istanza == null) {
            istanza = new GeneratoreIDBiglietto();
        }
        return istanza;
    }

    @Override
    public synchronized long generaProssimoId() {
        return ++ultimoIdAssegnato;
    }
}
