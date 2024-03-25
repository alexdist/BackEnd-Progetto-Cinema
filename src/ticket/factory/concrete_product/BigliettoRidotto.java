package ticket.factory.concrete_product;



import cinema_Infrastructure.spettacolo.ISpettacolo;
import domain.Utente;
import id_generator_factory.abstract_factory.GeneratoreIDFactory;
import id_generator_factory.product.IGeneratoreID;
import prova_id_PERSISTENTE.IGeneratoreIDPersistente;
import ticket.factory.product.IBiglietto;
//import ticket.GeneratoreIDBiglietto;
//import ticket.IGeneratoreIDBiglietto;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;

public class BigliettoRidotto implements IBiglietto, Serializable {


    private final long id;

    private final LocalDateTime timestampAcquisto;
    private ISpettacolo spettacolo;
    private Utente acquirente;
    private double costo;
    private boolean isValid;

    public BigliettoRidotto(ISpettacolo spettacolo, Utente acquirente, double costo, IGeneratoreIDPersistente generatoreID) {
        this.timestampAcquisto = LocalDateTime.now();
        // Utilizza la factory per ottenere il generatore di ID specifico per i biglietti
        //IGeneratoreID generatoreID = generatoreIDFactory.creaGeneratoreID();
        // Ora genera il prossimo ID
        this.id = generatoreID.generaProssimoId();
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
        return "green";
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
