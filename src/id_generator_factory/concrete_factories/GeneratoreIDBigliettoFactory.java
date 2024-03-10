package id_generator_factory.concrete_factories;

import id_generator_factory.abstract_factory.GeneratoreIDFactory;
import id_generator_factory.concrete_product.GeneratoreIDBiglietto;
import id_generator_factory.product.IGeneratoreID;

public class GeneratoreIDBigliettoFactory extends GeneratoreIDFactory {
    @Override
    public IGeneratoreID creaGeneratoreID() {
        return GeneratoreIDBiglietto.getInstance();
    }
}
