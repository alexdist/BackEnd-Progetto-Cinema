package cinema_Infrastructure.film;


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