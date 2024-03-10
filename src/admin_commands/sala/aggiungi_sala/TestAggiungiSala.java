package admin_commands.sala.aggiungi_sala;

import admin_commands.sala.aggiungi_sala.AggiungiSalaCommand;
import admin_interfaces.ICommand;

import cinema_Infrastructure.sala.ISala;
import cinema_Infrastructure.sala.Sala;
import cinema_Infrastructure.sala.gestione_sala.AggiungiSala;
import cinema_Infrastructure.sala.gestione_sala.IAggiungiSala;
import domain.Amministratore;
import domain.Ruolo;
import id_generator_factory.abstract_factory.GeneratoreIDFactory;
import id_generator_factory.concrete_factories.GeneratoreIDSalaFactory;

import java.util.ArrayList;
import java.util.List;

public class TestAggiungiSala {
    public static void main(String[] args) {
        try {
            // Inizializzazione dell'ambiente di test
            List<ISala> sale = new ArrayList<>();
            GeneratoreIDFactory generatoreIDSalaFactory = new GeneratoreIDSalaFactory();
            IAggiungiSala servizioAggiungiSala = new AggiungiSala(sale, generatoreIDSalaFactory);

            // Creazione di una nuova sala da aggiungere
            ISala sala1 = new Sala(1,50);

            // Creazione di una nuova sala da aggiungere
            ISala sala2 = new Sala(2,50);

            // Creazione del comando per aggiungere la sala1
            ICommand aggiungiSalaCommand = new AggiungiSalaCommand(servizioAggiungiSala, sala1);

            // Creazione del comando per aggiungere la sala2
            ICommand aggiungiSalaCommand2 = new AggiungiSalaCommand(servizioAggiungiSala, sala2);

            // Creazione dell'amministratore e assegnazione del comando
            Amministratore amministratore = new Amministratore("Luca", "Rossi", Ruolo.AMMINISTRATORE);
            amministratore.setCommand(aggiungiSalaCommand);

            // Esecuzione del comando attraverso l'amministratore
            amministratore.eseguiComando();

            amministratore.setCommand(aggiungiSalaCommand2);
            amministratore.eseguiComando();

            // Stampa dei film in programmazione dopo l'aggiunta
            System.out.println("Sale esistenti:");
            for (ISala sala : servizioAggiungiSala.getSale()) {
                System.out.println("Sala " + sala.getNumeroSala() + " Capacita: " + sala.getCapacita() + " (ID: " + sala.getId() + ")");
            }
        } catch (Exception e) {
            // Catch-all per qualsiasi altra eccezione non prevista
            System.err.println("Errore imprevisto: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
