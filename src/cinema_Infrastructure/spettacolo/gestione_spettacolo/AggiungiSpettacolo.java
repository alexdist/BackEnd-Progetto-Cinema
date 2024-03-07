package cinema_Infrastructure.spettacolo.gestione_spettacolo;

import cinema_Infrastructure.spettacolo.IGeneratoreIDSpettacolo;
import cinema_Infrastructure.spettacolo.ISpettacolo;
import cinema_Infrastructure.spettacolo.ValidatoreSpettacolo;
import exception.SovrapposizioneSpettacoloException;
import java.util.ArrayList;
import java.util.List;

public class AggiungiSpettacolo implements IAggiungiSpettacolo {

    private IGeneratoreIDSpettacolo generatoreID;
    private List<ISpettacolo> spettacoli; // Usa l'interfaccia ISpettacolo anziché la classe concreta

    public AggiungiSpettacolo(List<ISpettacolo> spettacoli, IGeneratoreIDSpettacolo generatoreID){
        this.spettacoli = spettacoli;
        this.generatoreID = generatoreID;
    }

    @Override
    public void aggiungiSpettacolo(ISpettacolo nuovoSpettacolo) throws SovrapposizioneSpettacoloException{
        // Validazione della sovrapposizione degli spettacoli (l'implementazione della validazione rimane invariata)
        ValidatoreSpettacolo.validaSpettacolo(nuovoSpettacolo, spettacoli);

        // Assegna un ID univoco al nuovo spettacolo e lo aggiunge alla lista
        long id = generatoreID.generaProssimoId();
        nuovoSpettacolo.setId(id);
        spettacoli.add(nuovoSpettacolo);

        // Stampa o logga un messaggio di conferma
        System.out.println("Spettacolo aggiunto con successo con ID: " + id);
    }

    @Override
    public List<ISpettacolo> getSpettacoli() {
        return new ArrayList<>(spettacoli); // Restituisce una copia della lista per evitare modifiche esterne
    }
}




