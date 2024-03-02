package singleton;

import admin_interfaces.Command;
import memento.Caretaker;
import ticket_pricing.GestorePrezzi;
import ticket_pricing.GestoreRicavi;

// Implementato come SINGLETON
public class Cinema {
    // Variabile statica per mantenere l'unica istanza della classe Cinema
    private static Cinema instance;

    // Componenti del sistema di gestione del cinema
    private GestioneCinema gestioneCinema; // Gestisce le sale, i film e gli spettacoli
    private GestorePrezzi gestorePrezzi; // Gestisce i prezzi dei biglietti
    private GestoreRicavi gestoreRicavi; // Gestisce i ricavi generati dalla vendita dei biglietti
    private Caretaker caretaker; // Gestisce il pattern Memento per gli acquisti

    // Costruttore privato per prevenire l'istanziazione diretta
    private Cinema() {
        gestioneCinema = new GestioneCinema(); // Inizializza la gestione del cinema
        gestorePrezzi = new GestorePrezzi(0, 0); // Inizializza il gestore dei prezzi con valori di default
        gestoreRicavi = new GestoreRicavi(); // Inizializza il gestore dei ricavi
        caretaker = new Caretaker(); // Inizializza il caretaker per il pattern Memento
    }

    // Metodo statico synchronized per ottenere l'unica istanza della classe
    public static synchronized Cinema getInstance() {
        if (instance == null) {
            instance = new Cinema(); // Crea l'istanza se non esiste
        }
        return instance; // Restituisce l'istanza esistente
    }

    // Metodo setter per GestoreRicavi
    public void setGestoreRicavi(GestoreRicavi gestoreRicavi) {
        this.gestoreRicavi = gestoreRicavi;
    }
    public void setCaretaker(Caretaker caretaker) {
        this.caretaker = caretaker;
    }
    public void setGestioneCinema(GestioneCinema gestioneCinema) {
        this.gestioneCinema = gestioneCinema;
    }
    // Metodo getter per ottenere l'istanza di GestioneCinema
    public GestioneCinema getGestioneCinema() {
        return gestioneCinema;
    }

    public void setGestorePrezzi(GestorePrezzi gestorePrezzi) {
        this.gestorePrezzi = gestorePrezzi;
    }

    // Metodo getter per ottenere l'istanza di GestorePrezzi
    public GestorePrezzi getGestorePrezzi() {
        return gestorePrezzi;
    }

    // Metodo getter per ottenere l'istanza di GestoreRicavi
    public GestoreRicavi getGestoreRicavi() {
        return gestoreRicavi;
    }

    // Metodo getter per ottenere l'istanza di Caretaker
    public Caretaker getCaretaker() {
        return caretaker;
    }

    // Metodo per eseguire un comando all'interno del sistema di gestione del cinema
    public void eseguiComando(Command comando) {
        comando.execute(); // Esegue il comando specificato
    }
}


