package domain;

import admin_interfaces.ICommand;
import exception.film.FilmNonValidoException;
import exception.sala.SalaNonValidaException;
import exception.spettacolo.SovrapposizioneSpettacoloException;
import exception.film.DurataFilmNonValidaException;
import exception.film.FilmGiaPresenteException;
import exception.film.FilmNonTrovatoException;
import exception.film.TitoloVuotoException;
import exception.sala.SalaGiaEsistenteException;
import exception.sala.SalaNonTrovataException;
import exception.spettacolo.SpettacoloNonTrovatoException;

import java.io.IOException;

// La classe Amministratore agisce come 'Invoker' nel pattern Command (Il Pattern Command utilizzato per i comandi admin).
// È responsabile per l'invocazione del comando, ma non conosce i dettagli dell'esecuzione.
public class Amministratore extends Persona {

    // Variabile privata per memorizzare il riferimento al comando che deve essere eseguito.
    private ICommand command;

    // Costruttore che inizializza l'Amministratore con il nome, cognome e ruolo,
    // sfruttando anche il costruttore della superclasse Persona.
    public Amministratore(String nome, String cognome, Ruolo ruolo) {
        super(nome, cognome, ruolo);

    }

    // Metodo per impostare il comando specifico da eseguire.
    // Il comando viene passato dall'esterno, permettendo flessibilità.
    public void setCommand(ICommand command){
        this.command = command;
    }

    // Metodo per eseguire il comando.
    // Quando chiamato, questo metodo invocherà il metodo execute del comando impostato.
    // Gestisce una serie di eccezioni che possono essere lanciate durante l'esecuzione del comando.
    public void eseguiComando() throws FilmGiaPresenteException, DurataFilmNonValidaException, TitoloVuotoException, FilmNonTrovatoException, SalaGiaEsistenteException, SalaNonTrovataException, SovrapposizioneSpettacoloException, FilmNonValidoException, SalaNonValidaException, SpettacoloNonTrovatoException, IOException {
        command.execute();
    }

}
