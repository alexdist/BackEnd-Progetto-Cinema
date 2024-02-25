package domain;




public class Utente extends Persona {
    // Costruttore specifico per Utente che chiama il costruttore della superclasse Persona
    public Utente(String nome, String cognome, Ruolo ruolo) {
        super(nome, cognome, ruolo);
    }
}



