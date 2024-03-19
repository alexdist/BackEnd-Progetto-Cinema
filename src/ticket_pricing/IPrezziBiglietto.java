package ticket_pricing;

public interface IPrezziBiglietto {

    double getPrezzoIntero();

    void setPrezzoIntero(double prezzoIntero);

    double getPrezzoRidotto();

    void setPrezzoRidotto(double prezzoRidotto);

    void setSovrapprezzo(double sovrapprezzo);

    double getSovrapprezzo();
}
