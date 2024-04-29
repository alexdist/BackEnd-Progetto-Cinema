package cinema_Infrastructure.sala.gestione_sala;

//import Serializzazione.sale.SalaSerializer;
import cinema_Infrastructure.sala.ISala;
import cinema_Infrastructure.sala.gestione_sala.IRimuoviSala;
import exception.sala.SalaNonTrovataException;

import java.util.List;

// RimuoviSala è la classe concreta che implementa l'interfaccia IRimuoviSala,
// agendo come il 'Receiver' nel pattern Command.
// Ha il compito di gestire la rimozione di una Sala.
public class RimuoviSala implements IRimuoviSala {

    // Lista delle sale
    private List<ISala> sale; // Usa l'interfaccia ISala

    // Costruttore che inizializza la classe con una lista di sale.
    public RimuoviSala(List<ISala> sale) {
        this.sale = sale;
    }


    // Metodo per verificare se una sala esiste, basato sull'ID
    private boolean esisteSalaPerId(long idSala) {
        return sale.stream()
                .anyMatch(sala -> sala.getId() == idSala);
    }

    // Metodo per rimuovere una sala dall'elenco, basato sull'ID
    public void rimuoviSalaPerId(long idSala) throws SalaNonTrovataException {
        boolean esisteSala = esisteSalaPerId(idSala);
        if (esisteSala) {
            sale.removeIf(sala -> sala.getId() == idSala);
            System.out.println("Sala con ID: " + idSala + " rimossa con successo.");
        } else {
            throw new SalaNonTrovataException("Sala con ID " + idSala + " non presente nella lista.");
        }
    }
}