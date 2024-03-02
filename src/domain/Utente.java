package domain;


import java.io.Serializable;

public class Utente extends Persona implements Serializable {
    // Costruttore specifico per Utente che chiama il costruttore della superclasse Persona
    public Utente(String nome, String cognome, Ruolo ruolo) {
        super(nome, cognome, ruolo);
    }
}



