package cinema_Infrastructure.spettacolo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import cinema_Infrastructure.film.Film;
import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.sala.ISala;
import cinema_Infrastructure.sala.Sala;


 // Classe Spettacolo rappresenta uno spettacolo cinematografico nel sistema di gestione del cinema.
 // Include dettagli come il film proiettato, la sala in cui avviene la proiezione e l'orario di proiezione.
 // Implementa l'interfaccia Serializable per consentire la serializzazione e la persistenza degli oggetti Spettacolo.
public class Spettacolo implements ISpettacolo, Serializable {
    private static final long serialVersionUID = 1L;
    private long id; // ID univoco per Spettacolo
    private IFilm film; // Riferimento all'interfaccia IFilm
    private ISala sala; // Riferimento all'interfaccia ISala
    private LocalDateTime orarioProiezione; // Data e ora della proiezione.

     // Costruttore per creare un nuovo spettacolo con il film, la sala e l'orario specificati.
    public Spettacolo(IFilm film, ISala sala, LocalDateTime orarioProiezione) {
        this.film = film;
        this.sala = sala;
        this.orarioProiezione = orarioProiezione;
    }

    // // Metodi getter e setter per le proprietà dello spettacolo.
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

    // Metodo toString per fornire una rappresentazione testuale dello spettacolo,
    // includendo il nome del film, il numero della sala e l'orario di proiezione formattato.
    @Override
    public String toString() {
        String nomeFilm = film.getTitolo();
        int nomeSala = sala.getNumeroSala();
        String dataFormato = orarioProiezione.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        return "Spettacolo " + nomeFilm + ", Sala: " + nomeSala + ", " + dataFormato;
    }
}


