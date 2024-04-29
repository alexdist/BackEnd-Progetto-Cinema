package user_interfaces;

import ticket.factory.product.IBiglietto;

// Questa interfaccia rappresenta un Receiver nel pattern Command
public interface AcquistoBiglietto {
    public boolean acquistaBiglietto(IBiglietto biglietto);
}
