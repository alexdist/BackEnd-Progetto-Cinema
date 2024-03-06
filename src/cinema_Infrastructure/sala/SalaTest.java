package cinema_Infrastructure.sala;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalaTest {


    public static void main(String[] args) {

        // Inizializza il generatore di ID per le sale
        IGeneratoreIDSala generatoreID = GeneratoreIDSala.getInstance();

        // Inizializza la lista che terrà traccia delle sale
        List<Sala> listaSale = new ArrayList<>();

        // Crea l'oggetto che si occupa dell'aggiunta delle sale, passando la lista invece della mappa
        IAggiungiSala aggiungiSala = new AggiungiSala(listaSale, generatoreID);

        // Crea alcune sale
        Sala sala1 = new Sala(1, 100);
        Sala sala2 = new Sala(2, 150);

        // Prova ad aggiungere le sale al cinema
        try {
            aggiungiSala.aggiungiSala(sala1);
            System.out.println("Sala " + sala1.getNumeroSala() + " con ID "+sala1.getId() + " aggiunta con successo.");
        } catch (Exception e) {
            System.out.println("Non è stato possibile aggiungere la sala " + sala1.getNumeroSala() + ": " + e.getMessage());
        }

        try {
            aggiungiSala.aggiungiSala(sala2);
            System.out.println("Sala " + sala2.getNumeroSala() + " con ID "+sala2.getId() + " aggiunta con successo.");
        } catch (Exception e) {
            System.out.println("Non è stato possibile aggiungere la sala " + sala2.getNumeroSala() + ": " + e.getMessage());
        }

        // Prova ad aggiungere una sala che ha lo stesso numero di una già esistente
        Sala salaDuplicata = new Sala(-3, 200);
        try {
            aggiungiSala.aggiungiSala(salaDuplicata);
        } catch (Exception e) {
            System.out.println("Non è stato possibile aggiungere la sala " + salaDuplicata.getNumeroSala() + ": " + e.getMessage());
        }

        // Stampa le sale esistenti per verificare che siano state aggiunte correttamente
        System.out.println("\nSale in programmazione:");
        listaSale.forEach(sala -> System.out.println("Sala numero: " + sala.getNumeroSala() + " - Capacità: " + sala.getPostiDisponibili() + " posti"));
    }
    }

