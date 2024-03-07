package cinema_Infrastructure.sala;

import cinema_Infrastructure.sala.gestione_sala.AggiungiSala;
import cinema_Infrastructure.sala.gestione_sala.IAggiungiSala;
import cinema_Infrastructure.sala.gestione_sala.IRimuoviSala;
import cinema_Infrastructure.sala.gestione_sala.RimuoviSala;
import exception.sala.SalaNonTrovataException;

import java.util.ArrayList;
import java.util.List;

public class SalaTest {

    public static void main(String[] args) {
        // Inizializza il generatore di ID per le sale
        IGeneratoreIDSala generatoreID = GeneratoreIDSala.getInstance();

        // Inizializza la lista che terrà traccia delle sale utilizzando l'interfaccia ISala
        List<ISala> listaSale = new ArrayList<>();

        // Crea l'oggetto che si occupa dell'aggiunta delle sale
        IAggiungiSala aggiungiSala = new AggiungiSala(listaSale, generatoreID);

        // Crea alcune sale utilizzando l'interfaccia ISala
        ISala sala1 = new Sala(1, 100);
        ISala sala2 = new Sala(2, 150);

        // Prova ad aggiungere le sale
        try {
            aggiungiSala.aggiungiSala(sala1);
            System.out.println("Sala " + sala1.getNumeroSala() + " con ID " + sala1.getId() + " aggiunta con successo.");
        } catch (Exception e) {
            System.out.println("Non è stato possibile aggiungere la sala " + sala1.getNumeroSala() + ": " + e.getMessage());
        }

        try {
            aggiungiSala.aggiungiSala(sala2);
            System.out.println("Sala " + sala2.getNumeroSala() + " con ID " + sala2.getId() + " aggiunta con successo.");
        } catch (Exception e) {
            System.out.println("Non è stato possibile aggiungere la sala " + sala2.getNumeroSala() + ": " + e.getMessage());
        }

        // Prova ad aggiungere una sala duplicata o con dati non validi
        ISala salaDuplicata = new Sala(-3, 200);
        try {
            aggiungiSala.aggiungiSala(salaDuplicata);
        } catch (Exception e) {
            System.out.println("Non è stato possibile aggiungere la sala " + salaDuplicata.getNumeroSala() + ": " + e.getMessage());
        }

        // Stampa le sale esistenti
        System.out.println("\nSale in programmazione dopo le operazioni:");
        listaSale.forEach(sala -> System.out.println("Sala numero: " + sala.getNumeroSala() + " - Capacità: " + sala.getCapacita() + " posti"));

        // Rimozione di una sala dalla lista delle sale
        IRimuoviSala rimuovi = new RimuoviSala(listaSale);
        try {
            rimuovi.rimuoviSalaPerId(1);
        } catch (SalaNonTrovataException e) {
            System.out.println(e.getMessage());
        }

        try {
            rimuovi.rimuoviSalaPerId(5); // ID inesistente per testare l'eccezione
        } catch (SalaNonTrovataException e) {
            System.out.println(e.getMessage());
        }

        // Stampa finale delle sale per verificare le modifiche
        System.out.println("\nSale in programmazione dopo le rimozioni:");
        listaSale.forEach(sala -> System.out.println("Sala numero: " + sala.getNumeroSala() + " - Capacità: " + sala.getCapacita() + " posti"));
    }
}

