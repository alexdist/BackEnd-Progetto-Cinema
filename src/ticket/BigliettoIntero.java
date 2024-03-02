package ticket;

import cinema_Infrastructure.Spettacolo;
import domain.Utente;
import singleton.*;

import java.io.Serializable;
import java.util.UUID;

public class BigliettoIntero implements Biglietto, Serializable {
    private static final long serialVersionUID = 1L;
    // Dettagli specifici del biglietto intero
    private final String id;
    private Spettacolo spettacolo;

    private Utente acquirente;
    private double costo;
    private boolean isValid; // Indica se il biglietto è valido

    // Costruttore che inizializza il biglietto intero
    public BigliettoIntero(Spettacolo spettacolo, Utente acquirente) {
        this.id = UUID.randomUUID().toString(); // Genera un ID univoco
        this.spettacolo = spettacolo;
        this.acquirente = acquirente;
        // Calcola il costo del biglietto intero tramite il GestorePrezzi del cinema
        this.costo = Cinema.getInstance().getGestorePrezzi().calcolaPrezzoFinale(spettacolo, "intero");
        this.isValid = true; // All'inizio, il biglietto è valido
    }

    @Override
    public void invalidate() {
        this.isValid = false; // Invalida il biglietto
    }

    @Override
    public boolean isValid() {
        return this.isValid;
    }

    @Override
    public String getColore() {
        // Restituisce il colore
        return "Blu";
    }

    @Override
    public String getLogoCinema() {
        // Restituisce il logo
        return "Logo Cinema XYZ";
    }

    @Override
    public Spettacolo getSpettacolo() {
        // Restituisce sempre lo spettacolo, indipendentemente dalla validità
        return this.spettacolo;
    }

    @Override
    public Utente getAcquirente() {
        // Restituisce sempre l'acquirente, indipendentemente dalla validità
        return this.acquirente;
    }

    @Override
    public double getCosto() {
        // Restituisce sempre il costo, indipendentemente dalla validità
        return this.costo;
    }

    @Override
    public String getId() {
        return id;
    }
}

