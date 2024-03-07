package cinema_Infrastructure.spettacolo.gestione_spettacolo;

import cinema_Infrastructure.spettacolo.ISpettacolo;
import cinema_Infrastructure.spettacolo.gestione_spettacolo.IRimuoviSpettacolo;
import exception.SpettacoloNonTrovatoException;

import java.util.List;

public class RimuoviSpettacolo implements IRimuoviSpettacolo {


        private List<ISpettacolo> spettacoli; // Usa l'interfaccia ISpettacolo

        public RimuoviSpettacolo(List<ISpettacolo> spettacoli) {
            this.spettacoli = spettacoli;
        }

        // Metodo per verificare se una sala esiste, basato sull'ID
        private boolean esisteSpettacoloPerId(long idSpettacolo) {
            return spettacoli.stream()
                    .anyMatch(spettacolo -> spettacolo.getId() == idSpettacolo);
        }

        // Metodo per rimuovere una sala dall'elenco, basato sull'ID
        public void rimuoviSpettacoloPerId(long idSpettacolo) throws SpettacoloNonTrovatoException {
            boolean esisteSpettacolo = esisteSpettacoloPerId(idSpettacolo);
            if (esisteSpettacolo) {
                spettacoli.removeIf(spettacolo -> spettacolo.getId() == idSpettacolo);
                System.out.println("Spettacolo con ID: " + idSpettacolo + " rimossa con successo.");
            } else {
                throw new SpettacoloNonTrovatoException("Spettacolo con ID " + idSpettacolo + " non presente nella lista.");
            }
        }

}
