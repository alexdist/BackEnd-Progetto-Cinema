package ticket_pricing;

import java.io.Serializable;

public class PrezziBiglietto implements IPrezziBiglietto, Serializable {
    private   double prezzoIntero;
    private   double prezzoRidotto;

    private double sovrapprezzo;

    public PrezziBiglietto(double prezzoIntero, double prezzoRidotto) {
        this.prezzoIntero = prezzoIntero;
        this.prezzoRidotto = prezzoRidotto;
    }

    public PrezziBiglietto(double prezzoIntero, double prezzoRidotto, double sovrapprezzo) {
        this.prezzoIntero = prezzoIntero;
        this.prezzoRidotto = prezzoRidotto;
        this.sovrapprezzo = sovrapprezzo;
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

    public void setSovrapprezzo(double sovrapprezzo){this.sovrapprezzo = sovrapprezzo;}

    public double getSovrapprezzo(){
        return this.sovrapprezzo;
    }
}



