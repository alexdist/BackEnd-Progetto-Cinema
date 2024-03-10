package cinema_Infrastructure.spettacolo.gestione_spettacolo.test;

import cinema_Infrastructure.film.Film;
import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.film.gestione_film.AggiungiFilm;
import cinema_Infrastructure.film.gestione_film.IAggiungiFilm;
import cinema_Infrastructure.sala.ISala;
import cinema_Infrastructure.sala.Sala;
import cinema_Infrastructure.sala.gestione_sala.AggiungiSala;
import cinema_Infrastructure.sala.gestione_sala.IAggiungiSala;
import cinema_Infrastructure.spettacolo.ISpettacolo;
import cinema_Infrastructure.spettacolo.Spettacolo;
import cinema_Infrastructure.spettacolo.gestione_spettacolo.AggiungiSpettacolo;
import cinema_Infrastructure.spettacolo.gestione_spettacolo.IAggiungiSpettacolo;
import cinema_Infrastructure.spettacolo.gestione_spettacolo.IModificaSpettacolo;
import cinema_Infrastructure.spettacolo.gestione_spettacolo.ModificaSpettacolo;
import id_generator_factory.abstract_factory.GeneratoreIDFactory;
import id_generator_factory.concrete_factories.GeneratoreIDFilmFactory;
import id_generator_factory.concrete_factories.GeneratoreIDSalaFactory;
import id_generator_factory.concrete_factories.GeneratoreIDSpettacoloFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestModificaSpettacolo {

    public static void main(String[] args) {
        ArrayList<IFilm> filmInProgrammazione = new ArrayList<>();
        ArrayList<ISala> saleInProgrammazione = new ArrayList<>();
        ArrayList<ISpettacolo> spettacoliInProgrammazione = new ArrayList<>();

        GeneratoreIDFactory generatoreIDFilmFactory = new GeneratoreIDFilmFactory();
        GeneratoreIDFactory generatoreIDSalaFactory = new GeneratoreIDSalaFactory();
        GeneratoreIDFactory generatoreIDSpettacoloFactory = new GeneratoreIDSpettacoloFactory();

        IAggiungiFilm aggiungiFilm = new AggiungiFilm(filmInProgrammazione, generatoreIDFilmFactory);
        IAggiungiSala aggiungiSala = new AggiungiSala(saleInProgrammazione, generatoreIDSalaFactory);
        IAggiungiSpettacolo aggiungiSpettacolo = new AggiungiSpettacolo(spettacoliInProgrammazione, generatoreIDSpettacoloFactory);
        IModificaSpettacolo modificaSpettacolo = new ModificaSpettacolo(spettacoliInProgrammazione);

        try {

            // Aggiunta di 3 film
            for (int i = 1; i <= 3; i++) {
                IFilm nuovoFilm = new Film("Film " + i, 120 + i, "Genere " + i);
                aggiungiFilm.aggiungiFilm(nuovoFilm);
                System.out.println("Aggiunto film: " + nuovoFilm.getTitolo() + " con ID: " + nuovoFilm.getId());
            }

            // Aggiunta di 3 sale
            for (int i = 1; i <= 3; i++) {
                ISala nuovaSala = new Sala(i, 100 + i * 10);
                aggiungiSala.aggiungiSala(nuovaSala);
                System.out.println("Aggiunta sala numero: " + nuovaSala.getNumeroSala() + " con ID: " + nuovaSala.getId());
            }

            // Aggiunta di 3 spettacoli
            for (int i = 0; i < 3; i++) {
                ISpettacolo nuovoSpettacolo = new Spettacolo(filmInProgrammazione.get(i), saleInProgrammazione.get(i), LocalDateTime.now().plusHours(i));
                aggiungiSpettacolo.aggiungiSpettacolo(nuovoSpettacolo);
                System.out.println("Aggiunto spettacolo con ID: " + nuovoSpettacolo.getId() + " per il film: " + nuovoSpettacolo.getFilm().getTitolo() + " nella sala: " + nuovoSpettacolo.getSala().getNumeroSala());
            }

            // Supponiamo che lo spettacolo con ID 1 esista e vogliamo modificarlo
            long idSpettacoloDaModificare = 1;

            // Modifica del film dello spettacolo con ID 1
            IFilm nuovoFilm = new Film("Nuovo Film", 130, "Nuovo Genere");
            modificaSpettacolo.modificaFilmPerIdSpettacolo(idSpettacoloDaModificare, nuovoFilm);

            // Modifica della sala dello spettacolo con ID 1
            ISala nuovaSala = new Sala(4, 250); // Supponendo che questa sala non sia ancora in programmazione
            modificaSpettacolo.modificaSalaPerIdSpettacolo(idSpettacoloDaModificare, nuovaSala);

            // Modifica dell'orario dello spettacolo con ID 1
            LocalDateTime nuovoOrario = LocalDateTime.now().plusDays(1); // Cambio l'orario al giorno successivo
            modificaSpettacolo.modificaOrarioProiezionePerIdSpettacolo(idSpettacoloDaModificare, nuovoOrario);

            // Ristampa dello spettacolo modificato
            ISpettacolo spettacoloModificato = spettacoliInProgrammazione.stream()
                    .filter(spettacolo -> spettacolo.getId() == idSpettacoloDaModificare)
                    .findFirst()
                    .orElseThrow(() -> new Exception("Spettacolo modificato non trovato."));

            System.out.println("Spettacolo modificato:");
            System.out.println("ID: " + spettacoloModificato.getId() + ", Film: " + spettacoloModificato.getFilm().getTitolo() + ", Sala: " + spettacoloModificato.getSala().getNumeroSala() + ", Orario: " + spettacoloModificato.getOrarioProiezione());

        } catch (Exception e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }
}
