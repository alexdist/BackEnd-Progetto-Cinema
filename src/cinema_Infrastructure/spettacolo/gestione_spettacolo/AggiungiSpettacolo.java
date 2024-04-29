package cinema_Infrastructure.spettacolo.gestione_spettacolo;

import cinema_Infrastructure.spettacolo.ISpettacolo;
import cinema_Infrastructure.spettacolo.ValidatoreSpettacolo;
import exception.film.FilmNonValidoException;
import exception.sala.SalaNonValidaException;
import exception.spettacolo.SovrapposizioneSpettacoloException;
import ID_persistente.IGeneratoreIDPersistente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// AggiungiSpettacolo è la classe concreta che implementa l'interfaccia IAggiungiSpettacolo,
// agendo come il 'Receiver' nel pattern Command.
// Ha il compito di gestire l'aggiunta di nuovi Spettacolo.
public class AggiungiSpettacolo implements IAggiungiSpettacolo {

    // Componente per la generazione di ID persistenti, utile per assegnare un identificativo univoco ad ogni Spettacolo.
    IGeneratoreIDPersistente generatoreID;

    // Lista che tiene traccia degli Spettacoli attualmente in programmazione.
    private List<ISpettacolo> spettacoli; //

    // Costruttore che inizializza la classe con una lista esistente degli Spettacoli e un generatore di ID.
    public AggiungiSpettacolo(List<ISpettacolo> spettacoli, IGeneratoreIDPersistente generatoreID){
        this.spettacoli = spettacoli;
        this.generatoreID = generatoreID;
    }

    // Implementazione del metodo per aggiungere uno Spettacolo alla programmazione.
    // Prima di aggiungere lo Spettacolo, valida i suoi parametri e controlla che non sia già presente.
    // Se lo Spettacolo è valido e non presente, gli viene assegnato un ID e viene aggiunto alla lista.
    @Override
    public void aggiungiSpettacolo(ISpettacolo nuovoSpettacolo) throws SovrapposizioneSpettacoloException, FilmNonValidoException, SalaNonValidaException, IOException {
        // Validazione della sovrapposizione degli spettacoli
        ValidatoreSpettacolo.validaSpettacolo(nuovoSpettacolo, spettacoli);
        long id = generatoreID.generaProssimoId();
        nuovoSpettacolo.setId(id);
        spettacoli.add(nuovoSpettacolo);

        System.out.println("Spettacolo aggiunto con successo con ID: " + id);
    }

    @Override
    public List<ISpettacolo> getSpettacoli() {
        return new ArrayList<>(spettacoli); // Restituisce una copia della lista per evitare modifiche esterne
    }
}




