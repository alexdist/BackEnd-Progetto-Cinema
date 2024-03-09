package Serializzazione.adapter;

import Serializzazione.adapter.adaptee.FilmSerializer;
import Serializzazione.adapter.adaptee.PrezziBigliettoSerializer;
import Serializzazione.adapter.adaptee.SalaSerializer;
import Serializzazione.adapter.adaptee.SpettacoloSerializer;
import Serializzazione.adapter.adapter.FilmSerializerAdapter;
import Serializzazione.adapter.adapter.PrezziBigliettoSerializerAdapter;
import Serializzazione.adapter.adapter.SalaSerializerAdapter;
import Serializzazione.adapter.adapter.SpettacoloSerializerAdapter;
import Serializzazione.adapter.target.IDataSerializer;
import cinema_Infrastructure.film.Film;
import cinema_Infrastructure.film.IFilm;
import cinema_Infrastructure.sala.ISala;
import cinema_Infrastructure.sala.Sala;
import cinema_Infrastructure.spettacolo.ISpettacolo;
import cinema_Infrastructure.spettacolo.Spettacolo;
import ticket_pricing.PrezziBiglietto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestGlobaleSerializer {

    public static void main(String[] args) {
//        // Adaptee instances
        SalaSerializer salaSerializer = new SalaSerializer();
        FilmSerializer filmSerializer = new FilmSerializer();
        SpettacoloSerializer spettacoloSerializer = new SpettacoloSerializer();
        PrezziBigliettoSerializer prezziBigliettoSerializer = new PrezziBigliettoSerializer();

        // Adapter instances
        IDataSerializer salaSerializerAdapter = new SalaSerializerAdapter(salaSerializer);
        IDataSerializer filmSerializerAdapter = new FilmSerializerAdapter(filmSerializer);
        IDataSerializer spettacoloSerializerAdapter = new SpettacoloSerializerAdapter(spettacoloSerializer);
        IDataSerializer prezziBigliettoSerializerAdapter = new PrezziBigliettoSerializerAdapter(prezziBigliettoSerializer);
//
//        // Sample data
//        List<ISala> sale = new ArrayList<>();
//        sale.add(new Sala(1, 120));
//        List<IFilm> film = new ArrayList<>();
//        film.add(new Film("Inception", 148, "Sci-Fi"));
//        List<ISpettacolo> spettacoli = new ArrayList<>();
//        spettacoli.add(new Spettacolo(film.get(0), sale.get(0), LocalDateTime.now()));
//        PrezziBiglietto prezziBiglietto = new PrezziBiglietto(10.0, 7.5);
//
//        // Serializing
//        salaSerializerAdapter.serialize(sale, "sale.ser");
//        filmSerializerAdapter.serialize(film, "film.ser");
//        spettacoloSerializerAdapter.serialize(spettacoli, "spettacoli.ser");
//        prezziBigliettoSerializerAdapter.serialize(prezziBiglietto, "prezziBiglietto.ser");

        // Deserializing
        List<ISala> loadedSale = (List<ISala>) salaSerializerAdapter.deserialize("sale.ser");
        List<IFilm> loadedFilm = (List<IFilm>) filmSerializerAdapter.deserialize("film.ser");
        List<ISpettacolo> loadedSpettacoli = (List<ISpettacolo>) spettacoloSerializerAdapter.deserialize("spettacoli.ser");
        PrezziBiglietto loadedPrezziBiglietto = (PrezziBiglietto) prezziBigliettoSerializerAdapter.deserialize("prezziBiglietto.ser");

        // Output to verify
        System.out.println("Sale caricate:");
        loadedSale.forEach(s -> System.out.println(s.getNumeroSala()));
        System.out.println("Film caricati:");
        loadedFilm.forEach(f -> System.out.println(f.getTitolo()));
        System.out.println("Spettacoli caricati:");
        loadedSpettacoli.forEach(s -> System.out.println(s.getFilm().getTitolo() + " in sala " + s.getSala().getNumeroSala()));
        System.out.println("Prezzi Biglietto caricati:");
        System.out.println("Prezzo intero: " + loadedPrezziBiglietto.getPrezzoIntero() + ", Prezzo ridotto: " + loadedPrezziBiglietto.getPrezzoRidotto());


//        private void serializeFilmList() {
//            IDataSerializer filmSerializerAdapter = new FilmSerializerAdapter(new FilmSerializer());
//            filmSerializerAdapter.serialize(filmInProgrammazione, filePath);
//        }
    }
}
