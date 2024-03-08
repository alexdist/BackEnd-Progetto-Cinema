package ticket.factory;

import cinema_Infrastructure.spettacolo.Spettacolo;
import domain.Utente;

public interface IBiglietto {
    // Verifica se il biglietto è valido
    boolean isValid();

    // Invalida il biglietto
    void invalidate();

    // Restituisce il colore del biglietto
    String getColore();

   // void setColore(String colore);

    // Restituisce il logo del cinema
    String getLogoCinema();

    // Restituisce lo spettacolo associato al biglietto
    Spettacolo getSpettacolo();



    // Restituisce l'utente che ha acquistato il biglietto
    Utente getAcquirente();



    // Restituisce il costo del biglietto
    double getCosto();



    long getId();


}