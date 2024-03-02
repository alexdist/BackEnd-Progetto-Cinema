package singleton;
import cinema_Infrastructure.Film;
import cinema_Infrastructure.Sala;
import cinema_Infrastructure.Spettacolo;
import exception.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestioneCinema implements Serializable {
    private static final long serialVersionUID = 1L;
    // Mappa che tiene traccia delle sale del cinema, usando come chiave il numero della sala
    private Map<Integer, Sala> sale;
    // Lista dei film attualmente in programmazione nel cinema
    private List<Film> filmInProgrammazione;
    // Lista degli spettacoli programmati nel cinema
    private List<Spettacolo> programmazione;

    // Costruttore della classe che inizializza le strutture dati
    public GestioneCinema() {
        this.sale = new HashMap<>(); // Inizializza la mappa delle sale
        this.filmInProgrammazione = new ArrayList<>(); // Inizializza la lista dei film
        this.programmazione = new ArrayList<>(); // Inizializza la lista degli spettacoli
    }

    // Metodo per aggiungere una nuova sala al cinema
    public void aggiungiSala(Sala sala) throws SalaGiaEsistenteException {
        if (sale.containsKey(sala.getNumeroSala())) {
            // Se la sala esiste già, lancia un'eccezione
            throw new SalaGiaEsistenteException("Sala numero " + sala.getNumeroSala() + " esiste già.");
        }
        // Altrimenti, aggiunge la sala alla mappa
        sale.put(sala.getNumeroSala(), sala);
        System.out.println("Sala " + sala.getNumeroSala() + " aggiunta con successo.");
    }

    // Metodo per aggiungere un nuovo film alla lista dei film in programmazione
    public void aggiungiFilm(Film film) throws FilmGiaPresenteException {
        // Verifica che il film non sia già presente nella lista
        if (filmInProgrammazione.stream().noneMatch(f -> f.getTitolo().equalsIgnoreCase(film.getTitolo()))) {
            // Se il film non è presente, lo aggiunge alla lista
            filmInProgrammazione.add(film);
            System.out.println("Film \"" + film.getTitolo() + "\" aggiunto con successo.");
        } else {
            // Se il film è già presente, lancia un'eccezione
            throw new FilmGiaPresenteException("Film \"" + film.getTitolo() + "\" è già presente.");
        }
    }



    public boolean creaSpettacolo(String idSpettacolo, Film film, int numeroSala, LocalDateTime orarioProiezione) throws SalaNonEsistenteException, FilmNonInProgrammazioneException, SovrapposizioneSpettacoloException, IDSpettacoloEsistenteException {
        Sala sala = sale.get(numeroSala);
        // Verifica l'esistenza della sala
        if (sala == null) {
            throw new SalaNonEsistenteException("Sala numero " + numeroSala + " non esiste.");
        }
        // Verifica che il film sia in programmazione
        if (filmInProgrammazione.stream().noneMatch(f -> f.getTitolo().equalsIgnoreCase(film.getTitolo()))) {
            throw new FilmNonInProgrammazioneException("Film \"" + film.getTitolo() + "\" non è presente nella programmazione.");
        }

        LocalDateTime orarioFinePrevisto = orarioProiezione.plusMinutes(film.getDurata());
        // Controlla la sovrapposizione degli spettacoli
        for (Spettacolo spettacoloEsistente : programmazione) {
            if (spettacoloEsistente.getSala().getNumeroSala() == numeroSala) {
                LocalDateTime inizioEsistente = spettacoloEsistente.getOrarioProiezione();
                LocalDateTime fineEsistente = inizioEsistente.plusMinutes(spettacoloEsistente.getFilm().getDurata());
                if (orarioProiezione.isBefore(fineEsistente) && orarioFinePrevisto.isAfter(inizioEsistente)) {
                    throw new SovrapposizioneSpettacoloException("Impossibile programmare: sovrapposizione con spettacolo esistente.");
                }
            }
        }

        // Verifica che l'ID non sia già utilizzato
        if (programmazione.stream().anyMatch(s -> s.getId().equals(idSpettacolo))) {
            throw new IDSpettacoloEsistenteException("Un spettacolo con l'ID fornito esiste già.");
        }

        // Se non ci sono sovrapposizioni e l'ID è unico, aggiunge lo spettacolo alla lista
        Spettacolo nuovoSpettacolo = new Spettacolo(idSpettacolo, film, sala, orarioProiezione);
        programmazione.add(nuovoSpettacolo);
        return true; // Indica il successo dell'operazione
    }


    public Spettacolo trovaSpettacolo(String idSpettacolo) {
        for (Spettacolo spettacolo : programmazione) {
            if (spettacolo.getId().equals(idSpettacolo)) {
                return spettacolo; // Ritorna lo spettacolo con l'ID corrispondente
            }
        }
        return null; // Nessuno spettacolo trovato con l'ID fornito
    }

    // Metodi getter per accedere alle strutture dati interne dalla classe
    public Map<Integer, Sala> getSale() {
        return sale;
    }

    public List<Film> getFilmInProgrammazione() {
        return filmInProgrammazione;
    }

    public List<Spettacolo> getProgrammazione() {
        return programmazione;
    }


}
