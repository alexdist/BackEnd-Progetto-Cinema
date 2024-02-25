package cinema_Infrastructure;

import java.io.Serializable;

public class Sala implements Serializable {
    private static final long serialVersionUID = 1L; // Aggiungi un serialVersionUID
    private final int numeroSala;
    private final int capacita; // Numero totale dei posti disponibili nella sala
    private int postiOccupati; // Numero dei posti attualmente occupati

    public Sala(int numeroSala, int capacita) {
        this.numeroSala = numeroSala;
        this.capacita = capacita;
        this.postiOccupati = 0; // Inizialmente, nessun posto è occupato
    }

    public boolean occupaPosto() {
        if (postiOccupati < capacita) {
            postiOccupati++; // Occupa un posto se disponibile
            return true;
        } else {
            System.out.println("La sala è piena, non ci sono più posti disponibili.");
            return false;
        }
    }

    // Metodo per liberare un posto (potrebbe essere utile per funzionalità future)
    public void liberaPosto() {
        if (postiOccupati > 0) {
            postiOccupati--;
        }
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public int getPostiDisponibili() {
        return capacita - postiOccupati;
    }
}
