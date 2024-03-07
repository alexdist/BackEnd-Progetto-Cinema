package cinema_Infrastructure.film;


public interface IFilm {
    // Metodo getter per ottenere l'ID del film
    long getId();

    // Metodo setter per impostare l'ID del film
    void setId(long id);

    // Metodo getter per ottenere il titolo del film
    String getTitolo();

    // Metodo setter per impostare il titolo del film
    void setTitolo(String titolo);

    //Metodo setter per impostare il genere
    void setGenere(String genere);

    String getGenere();

    // Metodo getter per ottenere la durata del film in minuti
    int getDurata();

    // Metodo setter per impostare la durata del film
    void setDurata(int durata);
}