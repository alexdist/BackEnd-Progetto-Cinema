package domain;

import java.io.Serializable;

public abstract class Persona implements Serializable {
    private String nome;
    private String cognome;
    private Ruolo ruolo; // Aggiunto il campo ruolo

    // Costruttore modificato per includere il ruolo
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
