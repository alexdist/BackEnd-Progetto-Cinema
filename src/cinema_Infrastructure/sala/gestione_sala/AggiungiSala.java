package cinema_Infrastructure.sala.gestione_sala;

//import Serializzazione.sale.SalaSerializer;
//import cinema_Infrastructure.sala.IGeneratoreIDSala;
import cinema_Infrastructure.sala.ISala;
import cinema_Infrastructure.sala.ValidatoreSala;
import exception.sala.NumeroPostiNegativoException;
import exception.sala.NumeroSalaNegativoException;
import exception.sala.SalaGiaEsistenteException;
import id_generator_factory.abstract_factory.GeneratoreIDFactory;
import id_generator_factory.product.IGeneratoreID;

import java.util.ArrayList;
import java.util.List;

public class AggiungiSala implements IAggiungiSala {
    private GeneratoreIDFactory generatoreIDFactory;
    private List<ISala> sale; // Usa l'interfaccia ISala
    private static final String FILE_PATH = "sale.ser"; // Definisce il percorso del file
    public AggiungiSala(List<ISala> sale, GeneratoreIDFactory generatoreIDFactory) {
        this.sale = sale;
        this.generatoreIDFactory = generatoreIDFactory;
    }

    @Override
    public void aggiungiSala(ISala nuovaSala) throws SalaGiaEsistenteException, NumeroSalaNegativoException, NumeroPostiNegativoException {
        // Validazione dei parametri della sala e controllo unicità numero sala
        ValidatoreSala.validaParametri(nuovaSala);
        ValidatoreSala.validaUnicitaSala(sale, nuovaSala.getNumeroSala());

        // Usa la factory per ottenere un generatore di ID e genera il prossimo ID
        IGeneratoreID generatoreID = generatoreIDFactory.creaGeneratoreID();
        // Assegnazione ID e aggiunta della sala alla lista
        long id = generatoreID.generaProssimoId();
        nuovaSala.setId(id);
        sale.add(nuovaSala);
        // Salva lo stato aggiornato delle sale su file
      //  SalaSerializer.serializeSaleList(sale, FILE_PATH);

        System.out.println("Sala " + nuovaSala.getNumeroSala() + " aggiunta con successo con ID: " + id);
    }

    public List<ISala> getSale() {
        return new ArrayList<>(sale);
    }
}