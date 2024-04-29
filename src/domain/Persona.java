package domain;

import java.io.Serializable;

// Classe astratta Persona che implementa Serializable per permettere la serializzazione degli oggetti.
// Serve come base per rappresentare persone con attributi comuni come nome, cognome e ruolo.
public abstract class Persona implements Serializable {
    private String nome;
    private String cognome;
    private Ruolo ruolo; // Enumerazione Ruolo che specifica il ruolo della persona (es. AMMINISTRATORE, UTENTE)


    public Persona(String nome, String cognome, Ruolo ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
    }

    // Getter e setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }
}
