package cinema_Infrastructure.film;

import java.io.Serializable;

public class Film implements Serializable {
    private static final long serialVersionUID = 1L; // Aggiungi un serialVersionUID

    private String titolo;
    private int durata;
    private long id; // Identificativo univoco del film.

    // Costruttore che accetta solo il titolo del film.

    public Film(String titolo, int durata){
        this.titolo = titolo;
        this.durata = durata;
    }

    // Costruttore che accetta sia il titolo sia la durata del film.

    public Film(String titolo, int durata, long id){
        this.titolo = titolo;
        this.durata = durata;
        this.id = id;
    }

    // Metodo getter per ottenere il titolo del film.

    public long getId(){return id;}

    public void setId(long id){
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    // Metodo setter per impostare il titolo del film.

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    // Metodo getter per ottenere la durata del film in minuti.

    public int getDurata() {
        return durata;
    }

    // Metodo setter per impostare la durata del film.

    public void setDurata(int durata) {
        this.durata = durata;
    }

    // Metodo toString() sovrascritto per fornire una rappresentazione in stringa dell'oggetto Film.

    @Override
    public String toString() {
        return "Film{" +
                "titolo='" + titolo + '\'' +
                ", durata=" + durata +
                '}';
    }
}

