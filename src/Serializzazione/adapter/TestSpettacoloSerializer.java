//package Serializzazione.adapter;
//
//import Serializzazione.adapter.adaptee.SpettacoloSerializer;
//import Serializzazione.adapter.adapter.SpettacoloSerializerAdapter;
//import Serializzazione.adapter.target.IDataSerializer;
//import cinema_Infrastructure.film.Film;
//import cinema_Infrastructure.film.IFilm;
////import cinema_Infrastructure.sala.GeneratoreIDSala;
////import cinema_Infrastructure.sala.IGeneratoreIDSala;
//import cinema_Infrastructure.sala.ISala;
//import cinema_Infrastructure.sala.Sala;
//import cinema_Infrastructure.sala.gestione_sala.AggiungiSala;
//import cinema_Infrastructure.sala.gestione_sala.RimuoviSala;
//import cinema_Infrastructure.spettacolo.ISpettacolo;
//import cinema_Infrastructure.spettacolo.Spettacolo;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestSpettacoloSerializer {
//
//    public static void main(String[] args) {
////
////        List<ISala> sale = new ArrayList<>();
////        sale.add(new Sala(1, 100));
////        sale.add(new Sala(2, 100));
////
////
////
////        List<IFilm> filmInProgrammazione = new ArrayList<>();
////        filmInProgrammazione.add(new Film("Il Signore degli Anelli", 178, "Fantasy"));
////        filmInProgrammazione.add(new Film("Matrix", 136, "Azione/Sci-fi"));
////
////        // Creazione della lista di spettacoli (usando mock o implementazioni ipotetiche di ISpettacolo)
////        List<ISpettacolo> spettacoli = new ArrayList<>();
////        spettacoli.add(new Spettacolo(filmInProgrammazione.get(0),sale.get(0), LocalDateTime.now()));
////        spettacoli.add(new Spettacolo(filmInProgrammazione.get(0),sale.get(1), LocalDateTime.now().plusHours(3)));
////       // spettacoli.add(new Spettacolo(/* ancora un film */, /* ancora una sala */, LocalDateTime.now().plusHours(6)));
////
////        // Creazione dell'adaptee come istanza
//        SpettacoloSerializer adaptee = new SpettacoloSerializer();
////
////        // Creazione dell'adapter passando l'istanza dell'adaptee
//        IDataSerializer spettacoloSerializerAdapter = new SpettacoloSerializerAdapter(adaptee);
////
////        // Serializzazione della lista di spettacoli usando l'adapter
////        spettacoloSerializerAdapter.serialize(spettacoli, "spettacoli.ser");
//
//        // Deserializzazione della lista di spettacoli usando l'adapter
//        List<ISpettacolo> spettacoliDeserializzati = (List<ISpettacolo>) spettacoloSerializerAdapter.deserialize("spettacoli.ser");
//
//        // Stampa dei spettacoli deserializzati
//        System.out.println("Spettacoli deserializzati:");
//        for (ISpettacolo spettacolo : spettacoliDeserializzati) {
//            System.out.println("Spettacolo: " + spettacolo.getFilm().getTitolo() + " in sala: " + spettacolo.getSala().getNumeroSala() + " alle ore: " + spettacolo.getOrarioProiezione());
//        }
//    }
//}
