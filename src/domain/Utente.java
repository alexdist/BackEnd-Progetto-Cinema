package domain;


import java.io.Serializable;

public class Utente extends Persona implements Serializable {

    private int eta;

    // Costruttore specifico per Utente che chiama il costruttore della superclasse Persona
    public Utente(String nome, String cognome, int eta, Ruolo ruolo) {

        super(nome, cognome, ruolo);
        this.eta = eta;
    }
}



