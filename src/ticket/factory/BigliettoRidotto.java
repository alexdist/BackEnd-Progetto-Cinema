package ticket.factory;



import cinema_Infrastructure.spettacolo.Spettacolo;
import domain.Utente;
import ticket.GeneratoreIDBiglietto;
import ticket.IGeneratoreIDBiglietto;

import java.io.Serializable;

public class BigliettoRidotto implements IBiglietto, Serializable {


    private final long id;
    private Spettacolo spettacolo;
    private Utente acquirente;
    private double costo;
    private boolean isValid;

    public BigliettoRidotto(Spettacolo spettacolo, Utente acquirente, double costo, IGeneratoreIDBiglietto id) {
        this.id = id.generaProssimoId();
        this.spettacolo = spettacolo;
        this.acquirente = acquirente;
        this.costo = costo;
        this.isValid = true;
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
        return "Verde";
    }

    @Override
    public String getLogoCinema() {
        return "Logo Cinema XYZ";
    }

    @Override
    public Spettacolo getSpettacolo() {
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
}
