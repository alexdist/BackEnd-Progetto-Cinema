package cinema_Infrastructure.spettacolo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import cinema_Infrastructure.film.Film;
import cinema_Infrastructure.sala.Sala;

//public class Spettacolo implements Serializable {
//    private static final long serialVersionUID = 1L;
//    private String id;
//
//    // Variabili d'istanza private per memorizzare i dettagli dello spettacolo, inclusi il film, la sala e l'orario di proiezione.
//    private Film film;
//    private Sala sala;
//    private LocalDateTime orarioProiezione;
//
//
//    public Spettacolo(String id, Film film, Sala sala, LocalDateTime orarioProiezione){
//        this.id = id; // L'ID è ora passato al costruttore e impostato manualmente
//        this.film = film;
//        this.sala = sala;
//       this.orarioProiezione = orarioProiezione;
//    }
//
//    // Getter e Setter per l'ID
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    // Metodo getter per ottenere il film dello spettacolo.
//    public Film getFilm() {
//        return film;
//    }
//
//    // Metodo setter per impostare il film dello spettacolo.
//    public void setFilm(Film film) {
//        this.film = film;
//    }
//
//    // Metodo getter per ottenere la sala dello spettacolo.
//    public Sala getSala() {
//        return sala;
//    }
//
//    // Metodo setter per impostare la sala dello spettacolo.
//    public void setSala(Sala sala) {
//        this.sala = sala;
//    }
//
//    // Metodo getter per ottenere l'orario di proiezione dello spettacolo.
//    public LocalDateTime getOrarioProiezione() {
//        return orarioProiezione;
//    }
//
//    // Metodo setter per impostare l'orario di proiezione dello spettacolo.
//    public void setOrarioProiezione(LocalDateTime orarioProiezione) {
//        this.orarioProiezione = orarioProiezione;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Spettacolo that = (Spettacolo) o;
//        return Objects.equals(id, that.id); // Supponendo che ogni spettacolo abbia un ID univoco.
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id); // Usa lo stesso campo (o campi) che usi in equals.
//    }
//}
/**
 * Classe Spettacolo rappresenta uno spettacolo cinematografico nel sistema di gestione del cinema.
 * Include dettagli come il film proiettato, la sala in cui avviene la proiezione e l'orario di proiezione.
 * Implementa l'interfaccia Serializable per consentire la serializzazione e la persistenza degli oggetti Spettacolo.
 */
public class Spettacolo implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id; // Identificativo univoco dello spettacolo.

    // Dettagli dello spettacolo.
    private Film film;
    private Sala sala;
    private LocalDateTime orarioProiezione;

    /**
     * Costruttore per creare uno spettacolo.
     * L'ID viene ora generato esternamente e passato a questo costruttore.
     * @param id Identificativo dello spettacolo.
     * @param film Il film proiettato.
     * @param sala La sala di proiezione.
     * @param orarioProiezione L'orario di inizio dello spettacolo.
     */
    public Spettacolo(long id, Film film, Sala sala, LocalDateTime orarioProiezione) {
        this.id = id;
        this.film = film;
        this.sala = sala;
        this.orarioProiezione = orarioProiezione;
    }

    // Metodi getter e setter
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public Film getFilm() { return film; }
    public void setFilm(Film film) { this.film = film; }
    public Sala getSala() { return sala; }
    public void setSala(Sala sala) { this.sala = sala; }
    public LocalDateTime getOrarioProiezione() { return orarioProiezione; }
    public void setOrarioProiezione(LocalDateTime orarioProiezione) { this.orarioProiezione = orarioProiezione; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spettacolo that = (Spettacolo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
