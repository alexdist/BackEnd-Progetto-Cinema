package ticket.factory;

import cinema_Infrastructure.spettacolo.ISpettacolo;
import cinema_Infrastructure.spettacolo.Spettacolo;
import domain.Utente;
import ticket.GeneratoreIDBiglietto;
import ticket.IGeneratoreIDBiglietto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BigliettoIntero implements IBiglietto, Serializable {

    // Dettagli specifici del biglietto intero
    private final long id;
    private ISpettacolo spettacolo;
    private final LocalDateTime timestampAcquisto;

    private Utente acquirente;
    private double costo;
    private boolean isValid; // Indica se il biglietto è valido

    // Costruttore che inizializza il biglietto intero
    public BigliettoIntero(ISpettacolo spettacolo, Utente acquirente, double costo, IGeneratoreIDBiglietto id) {
        this.timestampAcquisto = LocalDateTime.now();
        this.id = id.generaProssimoId();
        this.spettacolo = spettacolo;
        this.acquirente = acquirente;
        // Calcola il costo del biglietto intero tramite il GestorePrezzi del cinema
        this.costo = costo;
        this.isValid = true; // All'inizio, il biglietto è valido
    }

    @Override
    public void invalidate() {
        this.isValid = false;
    }

    @Override
    public boolean isValid() {
        return this.isValid;
    }

    @Override
    public String getColore() {
        return "Blu";
    }

    @Override
    public String getLogoCinema() {
        return "Logo Cinema XYZ";
    }

    @Override
    public ISpettacolo getSpettacolo() {
        return this.spettacolo;
    }

    @Override
    public Utente getAcquirente() {
        return this.acquirente;
    }

    @Override
    public double getCosto() {
        return this.costo;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public LocalDateTime getTimestampAcquisto() {
        return timestampAcquisto;
    }
}

