package cinema_Infrastructure.sala.gestione_sala;

//import Serializzazione.sale.SalaSerializer;
import cinema_Infrastructure.sala.ISala;
import cinema_Infrastructure.sala.gestione_sala.IRimuoviSala;
import exception.sala.SalaNonTrovataException;

import java.util.List;

public class RimuoviSala implements IRimuoviSala {

    private List<ISala> sale; // Usa l'interfaccia ISala

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
            // Salva lo stato aggiornato delle sale su file dopo la rimozione
            //SalaSerializer.serializeSaleList(sale, FILE_PATH);
            System.out.println("Sala con ID: " + idSala + " rimossa con successo.");
        } else {
            throw new SalaNonTrovataException("Sala con ID " + idSala + " non presente nella lista.");
        }
    }
}