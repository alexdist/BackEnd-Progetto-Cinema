package cinema_Infrastructure.spettacolo.gestione_spettacolo;

import cinema_Infrastructure.spettacolo.ISpettacolo;
import exception.spettacolo.SpettacoloNonTrovatoException;

import java.util.List;

public class RimuoviSpettacolo implements IRimuoviSpettacolo {

    // Lista di spettacoli che rappresenta l'elenco completo degli eventi programmati.
    private List<ISpettacolo> spettacoli; // Usa l'interfaccia ISpettacolo

    // Costruttore della classe RimuoviSpettacolo.
    // Accetta una lista di spettacoli da gestire.
    public RimuoviSpettacolo(List<ISpettacolo> spettacoli) {
            this.spettacoli = spettacoli;
        }


     // Metodo privato che verifica l'esistenza di uno spettacolo nell'elenco, basandosi sull'ID dello spettacolo.
     // Utilizza lo streaming degli spettacoli per controllare se almeno uno soddisfa il criterio dell'ID corrispondente.

        private boolean esisteSpettacoloPerId(long idSpettacolo) {
            return spettacoli.stream()
                    .anyMatch(spettacolo -> spettacolo.getId() == idSpettacolo);
        }

    //rimuove uno spettacolo dall'elenco basandosi sull'ID fornito.
    // Prima verifica l'esistenza dello spettacolo usando il metodo privato esisteSpettacoloPerId.
    // Se lo spettacolo esiste, lo rimuove dall'elenco; altrimenti, lancia una SpettacoloNonTrovatoException.
        public void rimuoviSpettacoloPerId(long idSpettacolo) throws SpettacoloNonTrovatoException {
            boolean esisteSpettacolo = esisteSpettacoloPerId(idSpettacolo);
            if (esisteSpettacolo) {
                // Utilizza il metodo removeIf per eliminare lo spettacolo che corrisponde all'ID dato.
                spettacoli.removeIf(spettacolo -> spettacolo.getId() == idSpettacolo);
                System.out.println("Spettacolo con ID: " + idSpettacolo + " rimossa con successo.");
            } else {
                // Se lo spettacolo con l'ID fornito non è trovato, lancia un'eccezione.
                throw new SpettacoloNonTrovatoException("Spettacolo con ID " + idSpettacolo + " non presente nella lista.");
            }
        }

}
