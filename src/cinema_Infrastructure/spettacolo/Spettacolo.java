package cinema_Infrastructure.spettacolo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import cinema_Infrastructure.film.Film;
import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.sala.ISala;
import cinema_Infrastructure.sala.Sala;

/**
 * Classe Spettacolo rappresenta uno spettacolo cinematografico nel sistema di gestione del cinema.
 * Include dettagli come il film proiettato, la sala in cui avviene la proiezione e l'orario di proiezione.
 * Implementa l'interfaccia Serializable per consentire la serializzazione e la persistenza degli oggetti Spettacolo.
 */
public class Spettacolo implements ISpettacolo, Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private IFilm film; // Usa l'interfaccia IFilm anziché la classe Film
    private ISala sala; // Usa l'interfaccia ISala anziché la classe Sala
    private LocalDateTime orarioProiezione;

    public Spettacolo(IFilm film, ISala sala, LocalDateTime orarioProiezione) {
        this.film = film;
        this.sala = sala;
        this.orarioProiezione = orarioProiezione;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public IFilm getFilm() {
        return film;
    }

    @Override
    public void setFilm(IFilm film) {
        this.film = film;
    }

    @Override
    public ISala getSala() {
        return sala;
    }

    @Override
    public void setSala(ISala sala) {
        this.sala = sala;
    }

    @Override
    public LocalDateTime getOrarioProiezione() {
        return orarioProiezione;
    }

    @Override
    public void setOrarioProiezione(LocalDateTime orarioProiezione) {
        this.orarioProiezione = orarioProiezione;
    }

    @Override
    public String toString() {
        String nomeFilm = film.getTitolo(); // Assumendo che IFilm abbia un metodo getNome()
        int nomeSala = sala.getNumeroSala(); // Assumendo che ISala abbia un metodo getNome()
        String dataFormato = orarioProiezione.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        return "Spettacolo " + nomeFilm + ", Sala: " + nomeSala + ", " + dataFormato;
    }
}


