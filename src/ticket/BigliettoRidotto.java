//package ticket;
//
//
//
//import cinema_Infrastructure.spettacolo.Spettacolo;
//import domain.Utente;
//import singleton.*;
//
//import java.io.Serializable;
//import java.util.UUID;
//
//public class BigliettoRidotto implements Biglietto, Serializable {
//    private static final long serialVersionUID = 1L;
//
//    private final String id;
//    private Spettacolo spettacolo;
//    private Utente acquirente;
//    private double costo;
//    private boolean isValid;
//
//    public BigliettoRidotto(Spettacolo spettacolo, Utente acquirente) {
//        this.id = UUID.randomUUID().toString(); // Genera un ID univoco
//        this.spettacolo = spettacolo;
//        this.acquirente = acquirente;
//        this.costo = Cinema.getInstance().getGestorePrezzi().calcolaPrezzoFinale(spettacolo, "ridotto");
//        this.isValid = true;
//    }
//
//    @Override
//    public void invalidate() {
//        this.isValid = false;
//    }
//
//    @Override
//    public boolean isValid() {
//        return this.isValid;
//    }
//
//    @Override
//    public String getColore() {
//        return "Verde";
//    }
//
//    @Override
//    public String getLogoCinema() {
//        return "Logo Cinema XYZ";
//    }
//
//    @Override
//    public Spettacolo getSpettacolo() {
//        return this.spettacolo;
//    }
//
//    @Override
//    public Utente getAcquirente() {
//        return this.acquirente;
//    }
//
//    @Override
//    public double getCosto() {
//        return this.costo;
//    }
//
//    @Override
//    public String getId() {
//        return id;
//    }
//}
