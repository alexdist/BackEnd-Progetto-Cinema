package cinema_Infrastructure.film;



 // Interfaccia IFilm che definisce il contratto per le operazioni base su un film.
public interface IFilm {
    long getId();
    void setId(long id);
    String getTitolo();
    void setTitolo(String titolo);
    void setGenere(String genere);
    String getGenere();
    int getDurata();
    void setDurata(int durata);
}