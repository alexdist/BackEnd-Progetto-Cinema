package id_generator_factory.concrete_factories;

import id_generator_factory.abstract_factory.GeneratoreIDFactory;
import id_generator_factory.concrete_product.GeneratoreIDSpettacolo;
import id_generator_factory.product.IGeneratoreID;

public class GeneratoreIDSpettacoloFactory extends GeneratoreIDFactory {
    @Override
    public IGeneratoreID creaGeneratoreID() {
        return GeneratoreIDSpettacolo.getInstance();
    }
}