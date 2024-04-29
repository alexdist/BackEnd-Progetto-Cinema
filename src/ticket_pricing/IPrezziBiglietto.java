package ticket_pricing;

// Interfaccia che definisce le operazioni per la gestione dei prezzi dei biglietti.
public interface IPrezziBiglietto {

    double getPrezzoIntero();

    void setPrezzoIntero(double prezzoIntero);

    double getPrezzoRidotto();

    void setPrezzoRidotto(double prezzoRidotto);

    void setSovrapprezzo(double sovrapprezzo);

    double getSovrapprezzo();
}
