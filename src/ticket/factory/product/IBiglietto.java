package ticket.factory.product;

import cinema_Infrastructure.spettacolo.ISpettacolo;
import cinema_Infrastructure.spettacolo.Spettacolo;
import domain.Utente;

import java.time.LocalDateTime;

// IBiglietto funge da 'Product' nel pattern Factory Method, definendo le operazioni e caratteristiche
// comuni a tutti i tipi di biglietti che il Factory Method creerà.
public interface IBiglietto {
    // Verifica se il biglietto è valido
    boolean isValid();

    // Invalida il biglietto
    void invalidate();

    // Restituisce il colore del biglietto
    String getColore();

    // Restituisce il logo del cinema
    String getLogoCinema();

    // Restituisce lo spettacolo associato al biglietto
    ISpettacolo getSpettacolo();

    // Restituisce l'utente che ha acquistato il biglietto
    Utente getAcquirente();

    // Restituisce il costo del biglietto
    double getCosto();

    long getId();

    // Restituisce il timestamp dell'acquisto del biglietto
    LocalDateTime getTimestampAcquisto();


}