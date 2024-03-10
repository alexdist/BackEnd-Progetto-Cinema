package ticket.factory.test;

import cinema_Infrastructure.film.Film;
import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.sala.ISala;
import cinema_Infrastructure.sala.Sala;
import cinema_Infrastructure.spettacolo.ISpettacolo;
import cinema_Infrastructure.spettacolo.Spettacolo;
import domain.Ruolo;
import domain.Utente;
import id_generator_factory.abstract_factory.GeneratoreIDFactory;
import id_generator_factory.concrete_factories.GeneratoreIDBigliettoFactory;
import id_generator_factory.concrete_factories.GeneratoreIDFilmFactory;
import id_generator_factory.concrete_factories.GeneratoreIDSalaFactory;
import id_generator_factory.concrete_factories.GeneratoreIDSpettacoloFactory;
import ticket.factory.BigliettoFactory;
import ticket.factory.BigliettoInteroFactory;
import ticket.factory.BigliettoRidottoFactory;
import ticket.factory.IBiglietto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestBiglietti {

    public static void main(String[] args) {
        // Inizializzazione delle factory per i generatori di ID
        GeneratoreIDFactory generatoreIDFilmFactory = new GeneratoreIDFilmFactory();
        GeneratoreIDFactory generatoreIDSalaFactory = new GeneratoreIDSalaFactory();
        GeneratoreIDFactory generatoreIDSpettacoloFactory = new GeneratoreIDSpettacoloFactory();
        GeneratoreIDFactory generatoreIDBigliettoFactory = new GeneratoreIDBigliettoFactory();

        ArrayList<IFilm> filmInProgrammazione = new ArrayList<>();
        ArrayList<ISala> saleInProgrammazione = new ArrayList<>();
        ArrayList<ISpettacolo> spettacoliInProgrammazione = new ArrayList<>();

        // Aggiungi alcuni film, sale, e spettacoli per test (omesso per brevità)

        // Creazione degli spettacoli da utilizzare per i biglietti
        IFilm filmPerBiglietto = new Film("Film Test", 120, "Dramma");
        ISala salaPerBiglietto = new Sala(1, 100);
        ISpettacolo spettacoloTest = new Spettacolo(filmPerBiglietto, salaPerBiglietto, LocalDateTime.now().plusHours(2));

        // Creazione di utenti
        Utente acquirente1 = new Utente("Mario", "Rossi", 14,Ruolo.UTENTE);
        Utente acquirente2 = new Utente("Luigi", "Bianchi",18,Ruolo.UTENTE);

        // Creazione delle factory per i biglietti
        BigliettoFactory bigliettoInteroFactory = new BigliettoInteroFactory(generatoreIDBigliettoFactory);
        BigliettoFactory bigliettoRidottoFactory = new BigliettoRidottoFactory(generatoreIDBigliettoFactory);

        // Generazione dei biglietti
        IBiglietto bigliettoIntero = bigliettoInteroFactory.creaBiglietto(spettacoloTest, acquirente1, 10.0);
        IBiglietto bigliettoRidotto = bigliettoRidottoFactory.creaBiglietto(spettacoloTest, acquirente2, 5.0);

        IBiglietto bigliettoIntero2 = bigliettoInteroFactory.creaBiglietto(spettacoloTest,acquirente1,10);

        // Stampa dei dettagli dei biglietti
        stampaDettagliBiglietto(bigliettoIntero);

        stampaDettagliBiglietto(bigliettoRidotto);

        stampaDettagliBiglietto(bigliettoIntero2);
    }

    private static void stampaDettagliBiglietto(IBiglietto biglietto) {
        System.out.println("Biglietto ID: " + biglietto.getId() +
                ", Film: " + biglietto.getSpettacolo().getFilm().getTitolo() +
                ", Sala: " + biglietto.getSpettacolo().getSala().getNumeroSala() +
                ", Orario: " + biglietto.getSpettacolo().getOrarioProiezione() +
                ", Acquirente: " + biglietto.getAcquirente().getNome() +
                ", Costo: " + biglietto.getCosto() +
                ", Colore: " + biglietto.getColore() +
                ", Logo Cinema: " + biglietto.getLogoCinema() +
                ", Validità: " + (biglietto.isValid() ? "Valido" : "Non Valido"));
    }
}
