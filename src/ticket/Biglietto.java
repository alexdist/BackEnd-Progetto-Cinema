package ticket;
import cinema_Infrastructure.Spettacolo;
import domain.Utente;

public interface Biglietto {
    // Verifica se il biglietto è valido
    boolean isValid();

    // Invalida il biglietto
    void invalidate();

    // Restituisce il colore del biglietto
    String getColore();

    // Restituisce il logo del cinema
    String getLogoCinema();

    // Restituisce lo spettacolo associato al biglietto
    Spettacolo getSpettacolo();

    // Restituisce l'utente che ha acquistato il biglietto
    Utente getAcquirente();

    // Restituisce il costo del biglietto
    double getCosto();

    String getId();
}


