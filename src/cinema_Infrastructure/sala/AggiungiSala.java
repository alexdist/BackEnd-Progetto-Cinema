package cinema_Infrastructure.sala;

import exception.sala.NumeroPostiNegativoException;
import exception.sala.NumeroSalaNegativoException;
import exception.sala.SalaGiaEsistenteException;

import java.util.List;

//public class AggiungiSala implements IAggiungiSala {
//    private IGeneratoreIDSala generatoreID;
//
//    // La mappa dovrebbe mappare un Integer, che rappresenta il numero della sala, a un oggetto Sala.
//    private Map<Integer, Sala> sale;
//
//    // L'IGeneratoreIDSala è iniettato, invece di essere inizializzato all'interno della classe.
//    public AggiungiSala(Map<Integer, Sala> sale, IGeneratoreIDSala generatoreID) {
//        this.sale = sale;
//        this.generatoreID = generatoreID;
//    }
//
//    // Metodo per aggiungere una nuova sala al cinema
//    @Override
//    public void aggiungiSala(Sala nuovaSala) throws SalaGiaEsistenteException {
//        // Controlla se il numero della sala è già presente come chiave nella mappa
//        if (sale.containsKey(nuovaSala.getNumeroSala())) {
//            // Se la sala esiste già, lancia un'eccezione
//            throw new SalaGiaEsistenteException("Sala numero " + nuovaSala.getNumeroSala() + " esiste già.");
//        } else {
//            // Assegna un ID univoco alla nuova sala
//            long id = generatoreID.generaProssimoId();
//            nuovaSala.setId(id);
//            // Altrimenti, aggiunge la sala alla mappa
//            sale.put(nuovaSala.getNumeroSala(), nuovaSala);
//            System.out.println("Sala " + nuovaSala.getNumeroSala() + " aggiunta con successo.");
//        }
//    }
//}


public class AggiungiSala implements IAggiungiSala {
    private IGeneratoreIDSala generatoreID;
    private List<Sala> sale;

    public AggiungiSala(List<Sala> sale, IGeneratoreIDSala generatoreID) {

        this.sale = sale; // Inizializza la lista vuota di sale
        this.generatoreID = generatoreID;
    }

@Override
public void aggiungiSala(Sala nuovaSala) throws SalaGiaEsistenteException, NumeroSalaNegativoException, NumeroPostiNegativoException {
    // Prima valida i parametri della sala
    ValidatoreSala.validaParametri(nuovaSala);

    // Poi valida l'unicità del numero della sala nell'elenco delle sale esistenti
    ValidatoreSala.validaUnicitaSala(sale, nuovaSala.getNumeroSala());

    // Se nessuna eccezione è stata sollevata, procedi con l'aggiunta della sala
    // Assegna un ID univoco alla nuova sala
    long id = generatoreID.generaProssimoId();
    nuovaSala.setId(id);

    // Aggiunge la sala alla lista
    sale.add(nuovaSala);

    // (Opzionale) Stampa o logga un messaggio di conferma
    System.out.println("Sala " + nuovaSala.getNumeroSala() + " aggiunta con successo con ID: " + id);
}

    // Aggiungi eventuali altri metodi necessari per la gestione delle sale...
}
