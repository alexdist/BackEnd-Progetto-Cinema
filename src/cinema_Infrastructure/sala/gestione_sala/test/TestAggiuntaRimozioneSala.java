//package cinema_Infrastructure.sala.gestione_sala.test;
//
//import cinema_Infrastructure.sala.ISala;
//import cinema_Infrastructure.sala.Sala;
//import cinema_Infrastructure.sala.gestione_sala.AggiungiSala;
//import cinema_Infrastructure.sala.gestione_sala.IAggiungiSala;
//import cinema_Infrastructure.sala.gestione_sala.IRimuoviSala;
//import cinema_Infrastructure.sala.gestione_sala.RimuoviSala;
//import exception.sala.SalaNonTrovataException;
//import id_generator_factory.abstract_factory.GeneratoreIDFactory;
//import id_generator_factory.concrete_factories.GeneratoreIDSalaFactory;
//
//import java.util.ArrayList;
//
//public class TestAggiuntaRimozioneSala {
//
//    public static void main(String[] args) {
//        // Creazione di una lista vuota per le sale in programmazione
//        ArrayList<ISala> saleInProgrammazione = new ArrayList<>();
//
//        // Creazione della factory per i generatori di ID delle sale
//        GeneratoreIDFactory generatoreIDFactory = new GeneratoreIDSalaFactory();
//
//        // Creazione dell'oggetto AggiungiSala
//        IAggiungiSala aggiungiSala = new AggiungiSala(saleInProgrammazione, generatoreIDFactory);
//
//        // Creazione dell'oggetto RimuoviSala
//        IRimuoviSala rimuoviSala = new RimuoviSala(saleInProgrammazione);
//
//        try {
//            // Aggiunta di tre sale utilizzando AggiungiSala
//            ISala sala1 = new Sala(1, 100);
//            aggiungiSala.aggiungiSala(sala1);
//            System.out.println("Aggiunta sala numero: " + sala1.getNumeroSala() + " con ID: " + sala1.getId());
//
//            ISala sala2 = new Sala(2, 150);
//            aggiungiSala.aggiungiSala(sala2);
//            System.out.println("Aggiunta sala numero: " + sala2.getNumeroSala() + " con ID: " + sala2.getId());
//
//            ISala sala3 = new Sala(3, 200);
//            aggiungiSala.aggiungiSala(sala3);
//            System.out.println("Aggiunta sala numero: " + sala3.getNumeroSala() + " con ID: " + sala3.getId());
//
//            // Rimozione della sala con ID 1
//            System.out.println("\nRimozione della sala con ID: 1");
//            rimuoviSala.rimuoviSalaPerId(1);
//
//        } catch (SalaNonTrovataException e) {
//            System.err.println("Errore: " + e.getMessage());
//        } catch (Exception e) {
//            System.err.println("Errore generico: " + e.getMessage());
//        }
//
//        // Stampa finale della lista delle sale per verificare la rimozione
//        System.out.println("\nSale rimanenti dopo la rimozione:");
//        for (ISala sala : aggiungiSala.getSale()) {
//            System.out.println("Sala Numero: " + sala.getNumeroSala() + " - ID: " + sala.getId() + " - Posti Disponibili: " + sala.getPostiDisponibili());
//        }
//    }
//}
