package cinema_Infrastructure.spettacolo.gestione_spettacolo;

import cinema_Infrastructure.spettacolo.ISpettacolo;
import cinema_Infrastructure.spettacolo.ValidatoreSpettacolo;
import exception.film.FilmNonValidoException;
import exception.sala.SalaNonValidaException;
import exception.spettacolo.SovrapposizioneSpettacoloException;
import prova_id_PERSISTENTE.IGeneratoreIDPersistente;
import java.util.ArrayList;
import java.util.List;

public class AggiungiSpettacolo implements IAggiungiSpettacolo {

    IGeneratoreIDPersistente generatoreID;
    private List<ISpettacolo> spettacoli; //

    public AggiungiSpettacolo(List<ISpettacolo> spettacoli, IGeneratoreIDPersistente generatoreID){
        this.spettacoli = spettacoli;
        this.generatoreID = generatoreID;
    }

    @Override
    public void aggiungiSpettacolo(ISpettacolo nuovoSpettacolo) throws SovrapposizioneSpettacoloException, FilmNonValidoException, SalaNonValidaException {
        // Validazione della sovrapposizione degli spettacoli
        ValidatoreSpettacolo.validaSpettacolo(nuovoSpettacolo, spettacoli);


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




