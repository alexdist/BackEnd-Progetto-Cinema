package cinema_Infrastructure.film;

import java.io.Serializable;

//Classe Film che implementa l'interfaccia IFilm e Serializable per la persistenza dei dati.
//Rappresenta un film con attributi come titolo, genere, durata e un ID univoco.
public class Film implements IFilm, Serializable {
    private static final long serialVersionUID = 1L; // Aggiunge un serialVersionUID per la Serializzazione
    private String titolo;
    private String genere;
    private int durata;
    private long id; // Identificativo univoco del film.


    // Costruttore per creare un nuovo film con titolo, durata e genere specificati.
    public Film(String titolo, int durata, String genere){
        this.titolo = titolo;
        this.durata = durata;
        this.genere = genere;

    }

    // Metodi getter e setter per gli attributi del film.
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

