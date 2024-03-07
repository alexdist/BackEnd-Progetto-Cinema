package cinema_Infrastructure.film;

import java.io.Serializable;

public class Film implements IFilm, Serializable {
    private static final long serialVersionUID = 1L; // Aggiungi un serialVersionUID

    private String titolo;
    private String genere;
    private int durata;
    private long id; // Identificativo univoco del film.

    // Costruttore che accetta solo il titolo del film.

    public Film(String titolo, int durata, String genere){
        this.titolo = titolo;
        this.durata = durata;
        this.genere = genere;
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

    //Metodo getter per ottenere il genere del film
    public String getGenere(){return genere;}

    //Metodo setter per impostare il genere del film.
    public void setGenere(String genere){this.genere = genere;}

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

