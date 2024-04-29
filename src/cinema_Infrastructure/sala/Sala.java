package cinema_Infrastructure.sala;

import java.io.Serializable;

// Classe Sala che implementa l'interfaccia ISala e supporta la clonazione e la serializzazione.
// Rappresenta una sala cinematografica con un numero identificativo, una capacità totale di posti
// e un conteggio dei posti attualmente occupati.
public class Sala implements ISala,Cloneable,Serializable {
    private static final long serialVersionUID = 1L; // Aggiunge un serialVersionUID per la Serializzazione
    private final int numeroSala;
    private final int capacita; // Numero totale dei posti disponibili nella sala
    private int postiOccupati; // Numero dei posti attualmente occupati

    private long id; // ID univoco

    // Costruttore per creare una sala specificando il numero della sala e la sua capacità.
    public Sala(int numeroSala, int capacita) {
        this.numeroSala = numeroSala;
        this.capacita = capacita;
        this.postiOccupati = 0; // Inizialmente, nessun posto è occupato
    }

    // Altro Costruttore che include un identificatore.
    public Sala(int numeroSala, int capacita, long id){
        this.numeroSala = numeroSala;
        this.capacita = capacita;
        this.id = id;
        this.postiOccupati = 0; // Inizialmente, nessun posto è occupato
    }

    // Metodo per occupare un posto nella sala, se disponibile.
    public boolean occupaPosto() {
        if (postiOccupati < capacita) {
            postiOccupati++; // Occupa un posto se disponibile
            return true;
        } else {
            //System.out.println("La sala è piena, non ci sono più posti disponibili.");
            return false;
        }
    }

    // Metodo per liberare un posto, decrementando il conteggio dei posti occupati.
    public void liberaPosto() {
        if (postiOccupati > 0) {
            postiOccupati--;
        }
    }


    // Metodo per clonare l'oggetto Sala. Utilizza il metodo clone() di Object per creare una copia di Sala
    @Override
    public ISala clone() {
        try {
            // Utilizza il metodo clone() di Object per clonare l'oggetto e poi esegue il casting al tipo appropriato
            Sala salaClonata = (Sala) super.clone();

            return salaClonata;
        } catch (CloneNotSupportedException e) {
            // Questa eccezione non dovrebbe mai essere sollevata a meno che non si rimuova 'implements Cloneable'
            throw new AssertionError(e);
        }
    }

    // Metodi getter e setter per Sala
    public void setId(long id){this.id = id;}

    public long getId(){return id;}

    public int getCapacita(){return capacita;}

    public int getNumeroSala() {
        return numeroSala;
    }

    public int getPostiDisponibili() {
        return capacita - postiOccupati;
    }
}
