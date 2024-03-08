package ticket;

import cinema_Infrastructure.film.Film;
import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.sala.ISala;
import cinema_Infrastructure.sala.Sala;
import cinema_Infrastructure.spettacolo.GeneratoreIDSpettacolo;
import cinema_Infrastructure.spettacolo.IGeneratoreIDSpettacolo;
import cinema_Infrastructure.spettacolo.ISpettacolo;
import cinema_Infrastructure.spettacolo.Spettacolo;
import cinema_Infrastructure.spettacolo.gestione_spettacolo.AggiungiSpettacolo;
import domain.Ruolo;
import domain.Utente;
import exception.film.FilmNonValidoException;
import exception.sala.SalaNonValidaException;
import exception.spettacolo.SovrapposizioneSpettacoloException;
import ticket.factory.BigliettoFactory;
import ticket.factory.BigliettoInteroFactory;
import ticket.factory.BigliettoRidottoFactory;
import ticket.factory.IBiglietto;
import ticket_pricing.PrezziBiglietto;
import ticket_pricing.strategy.Context;
import ticket_pricing.strategy.PrezzoBaseStrategy;
import ticket_pricing.strategy.PrezzoWeekEndStrategy;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestTicket {

    public static void main(String[] args) {
        // Creazione di un generatore di ID per i biglietti
        IGeneratoreIDBiglietto generatoreIDBiglietto = GeneratoreIDBiglietto.getInstance();



        // Creazione di esempi di film e sale
        IFilm film = new Film("Titolo Film", 120, "Drammatico"); // Implementazione di IFilm
        ISala sala = new Sala(1, 100); // Implementazione di ISala

        LocalDateTime nextSaturday = LocalDateTime.of(2024,3,9,20,45);
        // Creazione di uno spettacolo
        Spettacolo spettacolo = new Spettacolo(film, sala, nextSaturday);



        // Creazione di un utente
        Utente acquirente = new Utente("Mario", "Rossi", 30, Ruolo.UTENTE);

        // Inizializzazione dei prezzi
        PrezziBiglietto prezzi = new PrezziBiglietto(10.0, 7.5);

        // Controllo se lo spettacolo è nel weekend e applicazione della strategia di prezzo
        DayOfWeek giorno = spettacolo.getOrarioProiezione().getDayOfWeek();
        Context contextPrezzo;

        if (giorno == DayOfWeek.SATURDAY || giorno == DayOfWeek.SUNDAY) {
            contextPrezzo = new Context(new PrezzoWeekEndStrategy(prezzi, 0.2)); // 20% di aumento
        } else {
            contextPrezzo = new Context(new PrezzoBaseStrategy(prezzi));
        }

        contextPrezzo.executeStrategy();

        // Creazione delle factory per i biglietti
        BigliettoFactory bigliettoInteroFactory = new BigliettoInteroFactory();
        BigliettoFactory bigliettoRidottoFactory = new BigliettoRidottoFactory();

        // Creazione di un biglietto intero e ridotto utilizzando i prezzi aggiornati
        IBiglietto bigliettoIntero = bigliettoInteroFactory.creaBiglietto(spettacolo, acquirente, prezzi.getPrezzoIntero(), generatoreIDBiglietto);
        IBiglietto bigliettoRidotto = bigliettoRidottoFactory.creaBiglietto(spettacolo, acquirente, prezzi.getPrezzoRidotto(), generatoreIDBiglietto);

        System.out.println("Biglietto Intero - ID: " + bigliettoIntero.getId() +
                ", Costo: " + bigliettoIntero.getCosto() +
                ", Spettacolo: Film '" + spettacolo.getFilm().getTitolo() +
                "' in Sala '" + spettacolo.getSala().getNumeroSala() +
                "', Orario: " + spettacolo.getOrarioProiezione() +
                ", Acquirente: " + bigliettoIntero.getAcquirente().getNome() +
                " " + bigliettoIntero.getAcquirente().getCognome());

        System.out.println("Biglietto Ridotto - ID: " + bigliettoRidotto.getId() +
                ", Costo: " + bigliettoRidotto.getCosto() +
                ", Spettacolo: Film '" + spettacolo.getFilm().getTitolo() +
                "' in Sala '" + spettacolo.getSala().getNumeroSala() +
                "', Orario: " + spettacolo.getOrarioProiezione() +
                ", Acquirente: " + bigliettoRidotto.getAcquirente().getNome() +
                " " + bigliettoRidotto.getAcquirente().getCognome());

    }
    }


