package ticket_pricing;

import java.io.Serializable;

public class PrezziBiglietto implements IPrezziBiglietto, Serializable {
    private   double prezzoIntero;
    private   double prezzoRidotto;

    public PrezziBiglietto(double prezzoIntero, double prezzoRidotto) {
        this.prezzoIntero = prezzoIntero;
        this.prezzoRidotto = prezzoRidotto;
    }

    public double getPrezzoIntero() {
        return prezzoIntero;
    }

    public void setPrezzoIntero(double prezzoIntero){
        this.prezzoIntero = prezzoIntero;
    }

    public double getPrezzoRidotto() {
        return prezzoRidotto;
    }

    public void setPrezzoRidotto(double prezzoRidotto){
        this.prezzoRidotto = prezzoRidotto;
    }
}



