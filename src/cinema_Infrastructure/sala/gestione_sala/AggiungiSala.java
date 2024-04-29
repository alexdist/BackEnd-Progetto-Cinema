package cinema_Infrastructure.sala.gestione_sala;

import cinema_Infrastructure.sala.ISala;
import cinema_Infrastructure.sala.ValidatoreSala;
import exception.sala.NumeroPostiNegativoException;
import exception.sala.NumeroSalaNegativoException;
import exception.sala.SalaGiaEsistenteException;
import ID_persistente.IGeneratoreIDPersistente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// AggiungiSala è la classe concreta che implementa l'interfaccia IAggiungiSala,
// agendo come il 'Receiver' nel pattern Command.
// Ha il compito di gestire l'aggiunta di nuove Sale.
public class AggiungiSala implements IAggiungiSala {
    IGeneratoreIDPersistente generatoreID;
    private List<ISala> sale; // Usa l'interfaccia ISala
   // private static final String FILE_PATH = "sale.ser"; // Definisce il percorso del file
    public AggiungiSala(List<ISala> sale, IGeneratoreIDPersistente generatoreID) {
        this.sale = sale;
        this.generatoreID = generatoreID;
    }

    @Override
    public void aggiungiSala(ISala nuovaSala) throws SalaGiaEsistenteException, NumeroSalaNegativoException, NumeroPostiNegativoException, IOException {
        // Validazione dei parametri della sala e controllo unicità numero sala
        ValidatoreSala.validaParametri(nuovaSala);
        ValidatoreSala.validaUnicitaSala(sale, nuovaSala.getNumeroSala());

        // Assegnazione ID e aggiunta della sala alla lista
        long id = generatoreID.generaProssimoId();
        nuovaSala.setId(id);
        sale.add(nuovaSala);

        System.out.println("Sala " + nuovaSala.getNumeroSala() + " aggiunta con successo con ID: " + id);
    }

    public List<ISala> getSale() {
        return new ArrayList<>(sale);
    }
}