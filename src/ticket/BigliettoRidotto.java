package ticket;



import cinema_Infrastructure.Spettacolo;
import domain.Ruolo;
import domain.Utente;
import singleton.*;

public class BigliettoRidotto implements Biglietto {
    private Spettacolo spettacolo;
    private Utente acquirente;
    private double costo;
    private boolean isValid;

    public BigliettoRidotto(Spettacolo spettacolo, Utente acquirente) {
        this.spettacolo = spettacolo;
        this.acquirente = acquirente;
        this.costo = Cinema.getInstance().getGestorePrezzi().calcolaPrezzoFinale(spettacolo, "ridotto");
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
}
