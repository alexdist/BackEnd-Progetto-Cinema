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

public class Utente extends Persona implements Serializable {

    private int eta;
    private IUserCommand command;

    // Costruttore specifico per Utente che chiama il costruttore della superclasse Persona
    public Utente(String nome, String cognome, int eta, Ruolo ruolo) {

        super(nome, cognome, ruolo);
        this.eta = eta;
    }

    public int getEta(){
        return this.eta;
    }


    public void setCommand(IUserCommand command){
        this.command = command;
    }

    public void eseguiComando() {
        command.execute();
    }
}



