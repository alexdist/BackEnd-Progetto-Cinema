package domain;


import admin_interfaces.ICommand;
import exception.film.*;
import exception.sala.SalaGiaEsistenteException;
import exception.sala.SalaNonTrovataException;
import exception.sala.SalaNonValidaException;
import exception.spettacolo.SovrapposizioneSpettacoloException;
import exception.spettacolo.SpettacoloNonTrovatoException;
import user_interfaces.IUserCommand;

import java.io.Serializable;

// La classe Utente agisce come 'Invoker' nel pattern Command (Il Pattern Command utilizzato per i comandi user).
// È responsabile per l'invocazione del comando, ma non conosce i dettagli dell'esecuzione.
public class Utente extends Persona implements Serializable {

    private int eta;
    private IUserCommand command;// Riferimento al Command.

    // Costruttore specifico per Utente che chiama il costruttore della superclasse Persona
    public Utente(String nome, String cognome, int eta, Ruolo ruolo) {

        super(nome, cognome, ruolo);
        this.eta = eta;
    }

    public int getEta(){
        return this.eta;
    }

    // Metodo per associare un comando specifico all'utente.
    public void setCommand(IUserCommand command){
        this.command = command;
    }

    // Metodo che esegue il comando. Questo è il punto in cui l'Invoker attiva il Command.
    public void eseguiComando() {
        command.execute();
    }
}



