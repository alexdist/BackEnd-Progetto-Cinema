package cinema_Infrastructure.film;

import java.io.Serializable;

public class Film implements IFilm, Serializable {
    private static final long serialVersionUID = 1L;
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


    public long getId(){return id;}

    public void setId(long id){
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getGenere(){return genere;}

    public void setGenere(String genere){this.genere = genere;}

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

}

